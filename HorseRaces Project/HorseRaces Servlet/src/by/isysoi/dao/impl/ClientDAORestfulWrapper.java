package by.isysoi.dao.impl;

import by.isysoi.dao.ClientDAOInterface;
import by.isysoi.dao.HorseRacesEndPointConstants;
import by.isysoi.entity.Client;
import by.isysoi.exception.DAOException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * client dao wrapper class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class ClientDAORestfulWrapper implements ClientDAOInterface {

    //protected Logger logger = LogManager.getLogger("dao_layer");

    private WebTarget target;

    public ClientDAORestfulWrapper() {
        target = ClientBuilder.newClient().target(HorseRacesEndPointConstants.clientEndPoint);
    }

    /**
     * read clients
     *
     * @return list of clients
     */
    public List<Client> readClients() throws DAOException {
        List clients = null;
        try {
            clients = target.path("all")
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<List<Client>>() {});
        } catch (Exception e) {
            throw new DAOException("Failed request to find all clients", e);
        }
        return clients;
    }

    /**
     * read client by id
     *
     * @param id client id
     * @return client
     */
    public Client readClientById(int id) throws DAOException {
        Client client = null;
        try {
            client = target.path(String.valueOf(id))
                    .request(MediaType.APPLICATION_XML)
                    .get(Client.class);
        } catch (Exception e) {
            throw new DAOException("Failed request to find client with id - " + id, e);
        }
        return client;
    }

    /**
     * insert client
     *
     * @param client client object
     */
    public void insertClient(Client client) throws DAOException {
        try {
            target.path("new")
                    .request()
                    .post(Entity.entity(client, MediaType.APPLICATION_XML));
        } catch (Exception e) {
            throw new DAOException("Failed request to insert client", e);
        }
    }

}
