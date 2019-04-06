package by.isysoi.dao;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 */
@WebServiceClient(name = "BetDAOService", targetNamespace = "http://dao.isysoi.by/", wsdlLocation = "http://desktop-03g58vn:8080/Server_lab12_war_exploded/BetDAOService?wsdl")
public class BetDAOService
        extends Service {

    private final static URL BETDAOSERVICE_WSDL_LOCATION;
    private final static WebServiceException BETDAOSERVICE_EXCEPTION;
    private final static QName BETDAOSERVICE_QNAME = new QName("http://dao.isysoi.by/", "BetDAOService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://desktop-03g58vn:8080/Server_lab12_war_exploded/BetDAOService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BETDAOSERVICE_WSDL_LOCATION = url;
        BETDAOSERVICE_EXCEPTION = e;
    }

    public BetDAOService() {
        super(__getWsdlLocation(), BETDAOSERVICE_QNAME);
    }

    public BetDAOService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BETDAOSERVICE_QNAME, features);
    }

    public BetDAOService(URL wsdlLocation) {
        super(wsdlLocation, BETDAOSERVICE_QNAME);
    }

    public BetDAOService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BETDAOSERVICE_QNAME, features);
    }

    public BetDAOService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BetDAOService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (BETDAOSERVICE_EXCEPTION != null) {
            throw BETDAOSERVICE_EXCEPTION;
        }
        return BETDAOSERVICE_WSDL_LOCATION;
    }

    /**
     * @return returns BetDAO
     */
    @WebEndpoint(name = "BetDAOPort")
    public BetDAO getBetDAOPort() {
        return super.getPort(new QName("http://dao.isysoi.by/", "BetDAOPort"), BetDAO.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns BetDAO
     */
    @WebEndpoint(name = "BetDAOPort")
    public BetDAO getBetDAOPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dao.isysoi.by/", "BetDAOPort"), BetDAO.class, features);
    }

}
