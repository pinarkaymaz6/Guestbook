package com.example.guestbook;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import javax.xml.bind.JAXBContext;
import java.util.List;


public class GuestbookResource extends ServerResource {
 private Greetings list;

@Get("xml")
public String represent() {

    String result = null;
    try {

        Key<Guestbook> theBook = Key.create(Guestbook.class, "default");
        List<Greeting> greetings = ObjectifyService.ofy()
                .load()
                .type(Greeting.class)
                .ancestor(theBook)
                .order("-date")
                .list();

        list = new Greetings(greetings);
        JAXBContext jaxbContext = JAXBContext.newInstance(Greetings.class);
        result = XmlHelper.buildXml(jaxbContext, list);

    } catch(Exception e) {
        e.printStackTrace();
    }
    return result;
}

}

