package by.isysoi.dao;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 */
@WebService(name = "RaceDAO", targetNamespace = "http://dao.isysoi.by/")
@XmlSeeAlso({
        ObjectFactory.class
})
public interface RaceDAO {


    /**
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setHoresPositionInRace", targetNamespace = "http://dao.isysoi.by/", className = "by.isysoi.dao.SetHoresPositionInRace")
    @ResponseWrapper(localName = "setHoresPositionInRaceResponse", targetNamespace = "http://dao.isysoi.by/", className = "by.isysoi.dao.SetHoresPositionInRaceResponse")
    @Action(input = "http://dao.isysoi.by/RaceDAO/setHoresPositionInRaceRequest", output = "http://dao.isysoi.by/RaceDAO/setHoresPositionInRaceResponse")
    void setHoresPositionInRace(
            @WebParam(name = "arg0", targetNamespace = "")
                    int arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    int arg1,
            @WebParam(name = "arg2", targetNamespace = "")
                    int arg2);

    /**
     * @param arg0
     * @return returns java.util.List<by.isysoi.dao.Race>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readRacesByDate", targetNamespace = "http://dao.isysoi.by/", className = "by.isysoi.dao.ReadRacesByDate")
    @ResponseWrapper(localName = "readRacesByDateResponse", targetNamespace = "http://dao.isysoi.by/", className = "by.isysoi.dao.ReadRacesByDateResponse")
    @Action(input = "http://dao.isysoi.by/RaceDAO/readRacesByDateRequest", output = "http://dao.isysoi.by/RaceDAO/readRacesByDateResponse")
    List<Race> readRacesByDate(
            @WebParam(name = "arg0", targetNamespace = "")
                    XMLGregorianCalendar arg0);

    /**
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "insertRace", targetNamespace = "http://dao.isysoi.by/", className = "by.isysoi.dao.InsertRace")
    @ResponseWrapper(localName = "insertRaceResponse", targetNamespace = "http://dao.isysoi.by/", className = "by.isysoi.dao.InsertRaceResponse")
    @Action(input = "http://dao.isysoi.by/RaceDAO/insertRaceRequest", output = "http://dao.isysoi.by/RaceDAO/insertRaceResponse")
    void insertRace(
            @WebParam(name = "arg0", targetNamespace = "")
                    Race arg0);

    /**
     * @param arg0
     * @return returns by.isysoi.dao.Race
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readRaceById", targetNamespace = "http://dao.isysoi.by/", className = "by.isysoi.dao.ReadRaceById")
    @ResponseWrapper(localName = "readRaceByIdResponse", targetNamespace = "http://dao.isysoi.by/", className = "by.isysoi.dao.ReadRaceByIdResponse")
    @Action(input = "http://dao.isysoi.by/RaceDAO/readRaceByIdRequest", output = "http://dao.isysoi.by/RaceDAO/readRaceByIdResponse")
    Race readRaceById(
            @WebParam(name = "arg0", targetNamespace = "")
                    int arg0);

    /**
     * @return returns java.util.List<by.isysoi.dao.Race>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readRaces", targetNamespace = "http://dao.isysoi.by/", className = "by.isysoi.dao.ReadRaces")
    @ResponseWrapper(localName = "readRacesResponse", targetNamespace = "http://dao.isysoi.by/", className = "by.isysoi.dao.ReadRacesResponse")
    @Action(input = "http://dao.isysoi.by/RaceDAO/readRacesRequest", output = "http://dao.isysoi.by/RaceDAO/readRacesResponse")
    List<Race> readRaces();

    /**
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addHorseToRace", targetNamespace = "http://dao.isysoi.by/", className = "by.isysoi.dao.AddHorseToRace")
    @ResponseWrapper(localName = "addHorseToRaceResponse", targetNamespace = "http://dao.isysoi.by/", className = "by.isysoi.dao.AddHorseToRaceResponse")
    @Action(input = "http://dao.isysoi.by/RaceDAO/addHorseToRaceRequest", output = "http://dao.isysoi.by/RaceDAO/addHorseToRaceResponse")
    void addHorseToRace(
            @WebParam(name = "arg0", targetNamespace = "")
                    int arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    int arg1);

}
