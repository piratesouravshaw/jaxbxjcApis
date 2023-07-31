package org.soap;

import com.soshaw.patient.Patient;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("MAin method");
        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(Patient.class);
            Patient patient=new Patient();
            patient.setName("Abhishaek");
            patient.setAge(25);
            Marshaller marshaller=jaxbContext.createMarshaller();
            StringWriter stringWriter=new StringWriter();
            marshaller.marshal(patient,stringWriter);
            System.out.println(stringWriter.toString());
            Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
            StringReader stringReader=new StringReader(stringWriter.toString());
            Patient pat=(Patient) unmarshaller.unmarshal(stringReader);
            System.out.println(pat.getName());
            System.out.println(pat.getAge());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}
