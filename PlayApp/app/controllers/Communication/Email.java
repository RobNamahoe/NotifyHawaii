package controllers.Communication;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * A class that handles the sending of emails.
 */
public class Email {

  /**
   * Sends an email to the specified user.
   * @param sendTo The email address of the recipient.
   * @param subject The subject of the email.
   * @param content The content of the email.
   */
  public static void send(String sendTo, String subject, String content) {

    String emailAddress = "notifyhawaii@gmail.com";
    String password = "zes5utedraqabAx";

    // Create the email message
    HtmlEmail email = new HtmlEmail();

    email.setSmtpPort(587);
    email.setHostName("smtp.gmail.com");
    email.setAuthentication(emailAddress, password);
    email.setStartTLSEnabled(true);

    try {
      email.setFrom(emailAddress, "The Notify Hawai'i Team");
      email.setSubject(subject);
      email.addTo(sendTo);
      email.setHtmlMsg(content);
      email.setTextMsg("Your email client does not support HTML messages");
      email.send();


      //String url = "http://www.google.com";
      //String content = "<html><a href=\"" + url + "\">click here</a></html>";
      // set the alternative message


    }
    catch (EmailException e) {
      e.printStackTrace();
    }



  }



}
