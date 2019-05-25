package by.isysoi.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * class that represent user of system
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "User")
@Table(name = by.isysoi.entity.User.tableName)
@NamedQueries({
        @NamedQuery(name = "getUserInfo",
                query = "select u from User u" +
                        " where :login = u.login and :password = u.password")
})

public class User implements Serializable {

    public static final String tableName = "user";
    private static final long serialVersionUID = 1;
    /**
     * login of user
     */
    @XmlAttribute
    @XmlID
    @Id
    private String login;
    /**
     * password of user
     */
    @Basic(fetch = FetchType.LAZY)
    private String password;
    /**
     * type of user
     */
    private String type;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        switch (type) {
            case "admin":
                return UserType.ADMIN;
            case "client":
                return UserType.CLIENT;
            case "guest":
                return UserType.GUEST;
            default:
                return UserType.GUEST;
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeString() {
        return type;
    }

    public enum UserType {
        GUEST,
        CLIENT,
        ADMIN
    }

}
