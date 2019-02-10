package com.example.guestbook;

import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.logging.Logger;

public class GreetingResource extends ServerResource {
    private static final Logger LOGGER = Logger.getLogger(GreetingResource.class.getName());

    @Get("xml")
    public String request() {

        String out = null;
        Long id = Long.parseLong((String)getRequest().getAttributes().get("id"));
            if (id == null) {
                LOGGER.info("Not a valid ID");
                getResponse().setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
            } else {
                Greeting greeting = new Greeting();
                Greeting message = greeting.getGreetingById("default", id);
                if (message.equals(null)) {
                    getResponse().setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
                    LOGGER.info("Empty greeting has been returned");
                } else {
                    JAXBContext jaxbContext= null;
                    try {
                        jaxbContext = JAXBContext.newInstance(Greeting.class);
                        out = XmlHelper.buildXml(jaxbContext, message);
                        LOGGER.info(out);
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                }
            }
            return out;
        }
}
