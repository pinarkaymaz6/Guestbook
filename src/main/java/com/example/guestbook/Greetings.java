package com.example.guestbook;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "guestbook")
@XmlAccessorType(XmlAccessType.FIELD)
public class Greetings {

    @XmlElement(name = "greeting")
    private List<Greeting> greetings = null;

    public Greetings(){

    }

    public Greetings(List<Greeting> greetings) {
        this.greetings = greetings;
    }
}
