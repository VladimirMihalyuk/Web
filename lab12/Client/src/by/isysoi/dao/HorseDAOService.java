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
@WebServiceClient(name = "HorseDAOService", targetNamespace = "http://dao.isysoi.by/", wsdlLocation = "http://desktop-03g58vn:8080/Server_lab12_war_exploded/HorseDAOService?wsdl")
public class HorseDAOService
        extends Service {

    private final static URL HORSEDAOSERVICE_WSDL_LOCATION;
    private final static WebServiceException HORSEDAOSERVICE_EXCEPTION;
    private final static QName HORSEDAOSERVICE_QNAME = new QName("http://dao.isysoi.by/", "HorseDAOService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://desktop-03g58vn:8080/Server_lab12_war_exploded/HorseDAOService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HORSEDAOSERVICE_WSDL_LOCATION = url;
        HORSEDAOSERVICE_EXCEPTION = e;
    }

    public HorseDAOService() {
        super(__getWsdlLocation(), HORSEDAOSERVICE_QNAME);
    }

    public HorseDAOService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HORSEDAOSERVICE_QNAME, features);
    }

    public HorseDAOService(URL wsdlLocation) {
        super(wsdlLocation, HORSEDAOSERVICE_QNAME);
    }

    public HorseDAOService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HORSEDAOSERVICE_QNAME, features);
    }

    public HorseDAOService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HorseDAOService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (HORSEDAOSERVICE_EXCEPTION != null) {
            throw HORSEDAOSERVICE_EXCEPTION;
        }
        return HORSEDAOSERVICE_WSDL_LOCATION;
    }

    /**
     * @return returns HorseDAO
     */
    @WebEndpoint(name = "HorseDAOPort")
    public HorseDAO getHorseDAOPort() {
        return super.getPort(new QName("http://dao.isysoi.by/", "HorseDAOPort"), HorseDAO.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns HorseDAO
     */
    @WebEndpoint(name = "HorseDAOPort")
    public HorseDAO getHorseDAOPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dao.isysoi.by/", "HorseDAOPort"), HorseDAO.class, features);
    }

}
