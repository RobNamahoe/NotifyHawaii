package controllers.Communication;

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
  public static void send(String phoneNumber, String carrier, String content) {

    String sendTo = getSmsGateway(phoneNumber, carrier);

    String emailAddress = "notifyhawaii@gmail.com";
    String password = "zes5utedraqabAx";

    // Create the email message
    SimpleEmail email = new SimpleEmail();

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

  /**
   * Get the SMS gateway for the specified carrier.
   * @param phoneNumber The users telephone number.
   * @param carrier The carrier.
   * @return The SMS gateway specific to the carrier.
   */
  private static String getSmsGateway(String phoneNumber, String carrier) {
    String gateway = null;

    switch (carrier) {
      case "Alltel Wireless":
        gateway = "@text.wireless.alltel.com";
        break;
      case "AT&T Wireless":
        gateway = "@txt.att.net";
        break;
      case "AT&T Mobility (formerly Cingular)":
        gateway = "@cingularme.com";
        break;
      case "Boost Mobile":
        gateway = "@myboostmobile.com";
        break;
      case "Cricket":
        gateway = "@sms.mycricket.com";
        break;
      case "Metro PCS":
        gateway = "@mymetropcs.com";
        break;
      case "Sprint (PCS)":
        gateway = "@messaging.sprintpcs.com";
        break;
      case "Sprint (Nextel)":
        gateway = "@page.nextel.com";
        break;
      case "Straight Talk":
        gateway = "@VTEXT.COM";
        break;
      case "T-Mobile":
        gateway = "@tmomail.net";
        break;
      case "U.S. Cellular":
        gateway = "@email.uscc.net";
        break;
      case "Verizon":
        gateway = "@vtext.com";
        break;
      case "Virgin Mobile":
        gateway = "@vmobl.com";
        break;
      default:
        // No default action.
    }

    // If the carrier is valid, append the phone number to create the correct gateway.
    if (gateway != null) {
      gateway = phoneNumber + gateway;
    }

    return gateway;
  }

}
