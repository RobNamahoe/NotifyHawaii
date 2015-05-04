package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * A class that represents news services subscriptions held by the user.
 */
@Entity
public class NewsServicesSubscription extends Model {

  @Id
  private long id;

  private String site;    // Honolulu Star Advertiser, Maui News, Civil Beat
  private String topic;   // Breaking News, Sports, etc.
  private String method;  // Text, Email
  private String hour;       // 1-12
  private String period;  // AM/PM

  @ManyToOne // Many of me maps to one of the following (UserInfo)
  private UserInfo user;

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, NewsServicesSubscription> find() {
    return new Finder<Long, NewsServicesSubscription>(Long.class, NewsServicesSubscription.class);
  }

  /**
   * Creates a new NewsServiceSubscription with the specified values.
   * @param user The user to notify.
   * @param site The news paper website.
   * @param topic The topic to retrieve.
   * @param method The method to notify the user.
   * @param hour The hour to notify the user.
   * @param period The period to notify the user.
   */
  public NewsServicesSubscription(UserInfo user, String site, String topic, String method, String hour, String period) {
    this.user = user;
    this.site = site;
    this.topic = topic;
    this.method = method;
    this.hour = hour;
    this.period = period;
  }

  /**
   * Get the id value.
   * @return The id value.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id value.
   * @param id The new id value.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Get the site.
   * @return The site.
   */
  public String getSite() {
    return site;
  }

  /**
   * Sets the site.
   * @param site The new site.
   */
  public void setSite(String site) {
    this.site = site;
  }

  /**
   * Gets the topic.
   * @return The topic.
   */
  public String getTopic() {
    return topic;
  }

  /**
   * Sets the topic.
   * @param topic The new topic.
   */
  public void setTopic(String topic) {
    this.topic = topic;
  }

  /**
   * Gets the method of communication.
   * @return The method.
   */
  public String getMethod() {
    return method;
  }

  /**
   * Sets the method of communication.
   * @param method The new method.
   */
  public void setMethod(String method) {
    this.method = method;
  }

  /**
   * Get the hours to notify.
   * @return The hour to notify.
   */
  public String getHour() {
    return hour;
  }

  /**
   * Sets the hour of communication.
   * @param hour The new hour.
   */
  public void setHour(String hour) {
    this.hour = hour;
  }


  /**
   * Gets the period.
   * @return The period.
   */
  public String getPeriod() {
    return period;
  }

  /**
   * Sets the period.
   * @param period The period.
   */
  public void setPeriod(String period) {
    this.period = period;
  }

  /**
   * Get the user.
   * @return The user.
   */
  public UserInfo getUser() {
    return user;
  }

  /**
   * Sets the user.
   * @param user The user.
   */
  public void setUser(UserInfo user) {
    this.user = user;
  }

  /**
   * Creates and returns the header value: Site: + Topic.
   * @return The header value.
   */
  public String getHeader() {
    String header = this.site + ": " + this.topic;
    switch (this.site) {
      case "Honolulu Star Advertiser":
        header += (this.topic.equals("Sports")) ? "" : " News";
        break;
      case "Maui News":
        header += " News";
        break;
      case "Civil Beat":
        if (this.topic.equals("Honolulu") || this.topic.equals("Hawai'i")) {
          header += " News";
        }
        if (this.topic.equals("Popular")) {
          header += " Stories";
        }
        if (this.topic.equals("Energy")) {
          header += " and Environment";
        }
        break;
      default:
        break;
    }
    return header;
  }

  /**
   * Gets the notification time for the curernt subscription.
   * @return The notification time.
   */
  public String getNotificationTime() {
    return this.getHour() + " " + this.period;
  }

}
