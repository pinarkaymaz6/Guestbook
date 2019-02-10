package com.example.guestbook;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;

public class XmlHelper {

    public static String buildXml(JAXBContext jaxbContext, Object message){
        String result = null;
        try{
            Marshaller jaxbMarshaller=jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            StringWriter writer = new StringWriter();
            jaxbMarshaller.marshal(message, writer);
            result = writer.toString();
            writer.flush();
            writer.close();

        }catch(JAXBException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
