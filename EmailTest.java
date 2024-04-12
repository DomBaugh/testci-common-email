// Dominic Baughman 
// CIS 376 assignment 3 
// Also just a note i found this very hard so I tried my best 
// Also please excuse if this tests badly my internet is very slow and my phone hotspot does not work so actually running the code was very difficult 

// intial setup and imports 
package org.apache.commons.mail;
import static org.junit.Assert.*;

import javax.mail.MessagingException;

public class EmailTest {
	//setting up the emial varibale 
    private Email email;

    // making an emial instance to test
    public void instance() {
        email = new SimpleEmail();
    }

    //testing all the classes 
    public void testAddBcc() throws EmailException {
        email.addBcc("test1@example.com", "test2@example.com");
        assertEquals(2, email.getBccAddresses().size());
    }

    // checking to see if the CCs match 
    public void testAddCc() throws EmailException {
        email.addCc("test@example.com");
        assertEquals(1, email.getCcAddresses().size());
    }

    //testing this needs double exception 
    public void testAddHeader() throws EmailException, MessagingException {
        email.addHeader("X-MyHeader", "MyValue");
        assertEquals("MyValue", email.getMimeMessage().getHeader("X-MyHeader", null));
    }

    //testing to see if the reply goes thru 
    public void testAddReplyTo() throws EmailException {
        email.addReplyTo("test@example.com", "Test");
        assertEquals("test@example.com", email.getReplyToAddresses().get(0).getAddress());
        assertEquals("Test", email.getReplyToAddresses().get(0).getPersonal());
    }

    // testing to see if the mime message exists 
    public void testBuildMimeMessage() throws EmailException {
        email.setMsg("This is a test message");
        email.setFrom("test@example.com");
        email.setSubject("Test");
        email.addTo("test@example.com");
        email.buildMimeMessage();
        assertNotNull(email.getMimeMessage());
    }
    // basic testing to see if the next few exist or not since they are simple methods 
    // this is really all I could think they would need 
    public void testGetHostName() throws EmailException{
        assertNotNull(email.getHostName());
    }

    
    public void testGetMailSession() throws EmailException {
        assertNotNull(email.getMailSession());
    }

    
    public void testGetSentDate() throws EmailException{
        assertNotNull(email.getSentDate());
    }

    // testing timeout with big number 
    public void testGetSocketConnectionTimeout() throws EmailException{
        assertEquals(40000, email.getSocketConnectionTimeout());
    }

    //testing to see if setfrom lines up with reality 
    public void testSetFrom() throws EmailException {
        email.setFrom("test@example.com");
        assertEquals("test@example.com", email.getFromAddress().getAddress());
    }
}

