package controllers.Communication;

import models.Carrier;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * A class that handles the sending of text messages.
 */
public class TextMessage {

  /**
   * Sends the list of articles to the user as a text message.
   * @param phoneNumber The users phone number.
   * @param carrier The carrier.
   * @param content The content of the message.
   */
  public static void send(String phoneNumber, Carrier carrier, String content) {

    String emailAddress = "notifyhawaii@gmail.com";
    String password = "zes5utedraqabAx";

    // Create the email message
    SimpleEmail email = new SimpleEmail();
    String sendTo = phoneNumber + carrier.getGateway();

    email.setSmtpPort(587);
    email.setHostName("smtp.gmail.com");
    email.setAuthentication(emailAddress, password);
    email.setStartTLSEnabled(true);

    try {
      email.setFrom(emailAddress, "The Notify Hawai'i Team");
      email.addTo(sendTo);
      email.setMsg(content);
      email.send();

    }
    catch (EmailException e) {
      e.printStackTrace();
    }

  }

}
