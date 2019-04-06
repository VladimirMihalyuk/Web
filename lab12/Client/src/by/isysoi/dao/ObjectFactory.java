package by.isysoi.dao;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the by.isysoi.dao package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddHorseToRace_QNAME = new QName("http://dao.isysoi.by/", "addHorseToRace");
    private final static QName _AddHorseToRaceResponse_QNAME = new QName("http://dao.isysoi.by/", "addHorseToRaceResponse");
    private final static QName _Bet_QNAME = new QName("http://dao.isysoi.by/", "bet");
    private final static QName _Client_QNAME = new QName("http://dao.isysoi.by/", "client");
    private final static QName _Horse_QNAME = new QName("http://dao.isysoi.by/", "horse");
    private final static QName _InsertRace_QNAME = new QName("http://dao.isysoi.by/", "insertRace");
    private final static QName _InsertRaceResponse_QNAME = new QName("http://dao.isysoi.by/", "insertRaceResponse");
    private final static QName _Race_QNAME = new QName("http://dao.isysoi.by/", "race");
    private final static QName _ReadRaceById_QNAME = new QName("http://dao.isysoi.by/", "readRaceById");
    private final static QName _ReadRaceByIdResponse_QNAME = new QName("http://dao.isysoi.by/", "readRaceByIdResponse");
    private final static QName _ReadRaces_QNAME = new QName("http://dao.isysoi.by/", "readRaces");
    private final static QName _ReadRacesByDate_QNAME = new QName("http://dao.isysoi.by/", "readRacesByDate");
    private final static QName _ReadRacesByDateResponse_QNAME = new QName("http://dao.isysoi.by/", "readRacesByDateResponse");
    private final static QName _ReadRacesResponse_QNAME = new QName("http://dao.isysoi.by/", "readRacesResponse");
    private final static QName _SetHoresPositionInRace_QNAME = new QName("http://dao.isysoi.by/", "setHoresPositionInRace");
    private final static QName _SetHoresPositionInRaceResponse_QNAME = new QName("http://dao.isysoi.by/", "setHoresPositionInRaceResponse");
    private final static QName _RaceHorse_QNAME = new QName("", "horse");
    private final static QName _RaceBet_QNAME = new QName("", "bet");
    private final static QName _HorseRace_QNAME = new QName("", "race");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.isysoi.dao
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddHorseToRace }
     */
    public AddHorseToRace createAddHorseToRace() {
        return new AddHorseToRace();
    }

    /**
     * Create an instance of {@link AddHorseToRaceResponse }
     */
    public AddHorseToRaceResponse createAddHorseToRaceResponse() {
        return new AddHorseToRaceResponse();
    }

    /**
     * Create an instance of {@link Bet }
     */
    public Bet createBet() {
        return new Bet();
    }

    /**
     * Create an instance of {@link Client }
     */
    public Client createClient() {
        return new Client();
    }

    /**
     * Create an instance of {@link Horse }
     */
    public Horse createHorse() {
        return new Horse();
    }

    /**
     * Create an instance of {@link InsertRace }
     */
    public InsertRace createInsertRace() {
        return new InsertRace();
    }

    /**
     * Create an instance of {@link InsertRaceResponse }
     */
    public InsertRaceResponse createInsertRaceResponse() {
        return new InsertRaceResponse();
    }

    /**
     * Create an instance of {@link Race }
     */
    public Race createRace() {
        return new Race();
    }

    /**
     * Create an instance of {@link ReadRaceById }
     */
    public ReadRaceById createReadRaceById() {
        return new ReadRaceById();
    }

    /**
     * Create an instance of {@link ReadRaceByIdResponse }
     */
    public ReadRaceByIdResponse createReadRaceByIdResponse() {
        return new ReadRaceByIdResponse();
    }

    /**
     * Create an instance of {@link ReadRaces }
     */
    public ReadRaces createReadRaces() {
        return new ReadRaces();
    }

    /**
     * Create an instance of {@link ReadRacesByDate }
     */
    public ReadRacesByDate createReadRacesByDate() {
        return new ReadRacesByDate();
    }

    /**
     * Create an instance of {@link ReadRacesByDateResponse }
     */
    public ReadRacesByDateResponse createReadRacesByDateResponse() {
        return new ReadRacesByDateResponse();
    }

    /**
     * Create an instance of {@link ReadRacesResponse }
     */
    public ReadRacesResponse createReadRacesResponse() {
        return new ReadRacesResponse();
    }

    /**
     * Create an instance of {@link SetHoresPositionInRace }
     */
    public SetHoresPositionInRace createSetHoresPositionInRace() {
        return new SetHoresPositionInRace();
    }

    /**
     * Create an instance of {@link SetHoresPositionInRaceResponse }
     */
    public SetHoresPositionInRaceResponse createSetHoresPositionInRaceResponse() {
        return new SetHoresPositionInRaceResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddHorseToRace }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "addHorseToRace")
    public JAXBElement<AddHorseToRace> createAddHorseToRace(AddHorseToRace value) {
        return new JAXBElement<AddHorseToRace>(_AddHorseToRace_QNAME, AddHorseToRace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddHorseToRaceResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "addHorseToRaceResponse")
    public JAXBElement<AddHorseToRaceResponse> createAddHorseToRaceResponse(AddHorseToRaceResponse value) {
        return new JAXBElement<AddHorseToRaceResponse>(_AddHorseToRaceResponse_QNAME, AddHorseToRaceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bet }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "bet")
    public JAXBElement<Bet> createBet(Bet value) {
        return new JAXBElement<Bet>(_Bet_QNAME, Bet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Client }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "client")
    public JAXBElement<Client> createClient(Client value) {
        return new JAXBElement<Client>(_Client_QNAME, Client.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Horse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "horse")
    public JAXBElement<Horse> createHorse(Horse value) {
        return new JAXBElement<Horse>(_Horse_QNAME, Horse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertRace }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "insertRace")
    public JAXBElement<InsertRace> createInsertRace(InsertRace value) {
        return new JAXBElement<InsertRace>(_InsertRace_QNAME, InsertRace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertRaceResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "insertRaceResponse")
    public JAXBElement<InsertRaceResponse> createInsertRaceResponse(InsertRaceResponse value) {
        return new JAXBElement<InsertRaceResponse>(_InsertRaceResponse_QNAME, InsertRaceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Race }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "race")
    public JAXBElement<Race> createRace(Race value) {
        return new JAXBElement<Race>(_Race_QNAME, Race.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadRaceById }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "readRaceById")
    public JAXBElement<ReadRaceById> createReadRaceById(ReadRaceById value) {
        return new JAXBElement<ReadRaceById>(_ReadRaceById_QNAME, ReadRaceById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadRaceByIdResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "readRaceByIdResponse")
    public JAXBElement<ReadRaceByIdResponse> createReadRaceByIdResponse(ReadRaceByIdResponse value) {
        return new JAXBElement<ReadRaceByIdResponse>(_ReadRaceByIdResponse_QNAME, ReadRaceByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadRaces }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "readRaces")
    public JAXBElement<ReadRaces> createReadRaces(ReadRaces value) {
        return new JAXBElement<ReadRaces>(_ReadRaces_QNAME, ReadRaces.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadRacesByDate }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "readRacesByDate")
    public JAXBElement<ReadRacesByDate> createReadRacesByDate(ReadRacesByDate value) {
        return new JAXBElement<ReadRacesByDate>(_ReadRacesByDate_QNAME, ReadRacesByDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadRacesByDateResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "readRacesByDateResponse")
    public JAXBElement<ReadRacesByDateResponse> createReadRacesByDateResponse(ReadRacesByDateResponse value) {
        return new JAXBElement<ReadRacesByDateResponse>(_ReadRacesByDateResponse_QNAME, ReadRacesByDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadRacesResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "readRacesResponse")
    public JAXBElement<ReadRacesResponse> createReadRacesResponse(ReadRacesResponse value) {
        return new JAXBElement<ReadRacesResponse>(_ReadRacesResponse_QNAME, ReadRacesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetHoresPositionInRace }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "setHoresPositionInRace")
    public JAXBElement<SetHoresPositionInRace> createSetHoresPositionInRace(SetHoresPositionInRace value) {
        return new JAXBElement<SetHoresPositionInRace>(_SetHoresPositionInRace_QNAME, SetHoresPositionInRace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetHoresPositionInRaceResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://dao.isysoi.by/", name = "setHoresPositionInRaceResponse")
    public JAXBElement<SetHoresPositionInRaceResponse> createSetHoresPositionInRaceResponse(SetHoresPositionInRaceResponse value) {
        return new JAXBElement<SetHoresPositionInRaceResponse>(_SetHoresPositionInRaceResponse_QNAME, SetHoresPositionInRaceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "horse", scope = Race.class)
    @XmlIDREF
    public JAXBElement<Object> createRaceHorse(Object value) {
        return new JAXBElement<Object>(_RaceHorse_QNAME, Object.class, Race.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "bet", scope = Race.class)
    @XmlIDREF
    public JAXBElement<Object> createRaceBet(Object value) {
        return new JAXBElement<Object>(_RaceBet_QNAME, Object.class, Race.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "race", scope = Horse.class)
    @XmlIDREF
    public JAXBElement<Object> createHorseRace(Object value) {
        return new JAXBElement<Object>(_HorseRace_QNAME, Object.class, Horse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "bet", scope = Horse.class)
    @XmlIDREF
    public JAXBElement<Object> createHorseBet(Object value) {
        return new JAXBElement<Object>(_RaceBet_QNAME, Object.class, Horse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "bet", scope = Client.class)
    @XmlIDREF
    public JAXBElement<Object> createClientBet(Object value) {
        return new JAXBElement<Object>(_RaceBet_QNAME, Object.class, Client.class, value);
    }

}
