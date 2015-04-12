package models;

/**
 * A class that represents subscriptions held by the user.
 */
public class Subscription {

  /** An enumeration of service types. */
  public static enum ServiceType { NEWS, COMMUTE, BLOGS }

  /** An enumeration of news service sites. */
  public static enum ServiceSite { HONOLULU_STAR_ADVERTISER, MAUI_NEWS, CIVIL_BEAT }

  /** An enumeration of news service names. */
  public static enum ServiceName { BREAKING, POPULAR, SPORTS, HONOLULU, HAWAII, EDUCATION, POLITICS,
                                   ENERGY_AND_ENVIRONMENT, DEVELOPMENT, HAWAII_NEWS, LOCAL_NEWS,
                                   BREAKING_NEWS, BUSINESS_NEWS }

  private ServiceType serviceType;        // Commute, News, Blogs, etc...
  private ServiceSite serviceSite;        // Honolulu Star Advertiser, Maui News, Civil Beat...
  private ServiceName serviceName;        // Specific service, Breaking news, Popular news, sports, etc.

  private String notifyBy = "";         // Email or text.
  private String notifyAtHour = "";     // Hour of time to send notification.
  private String notifyAtMinute = "";   // Minute of time to send notification.


  /**
   * Creates a new subscription instance with the given parameters.
   * @param serviceType The subscription type.
   * @param serviceSite The subscription site.
   * @param serviceName The subscription name.
   * @param notifyBy The method of notification.
   * @param notifyAtHour The hour to notify the user.
   * @param notifyAtMinute The minute to notify the user.
   */
  public Subscription(ServiceType serviceType, ServiceSite serviceSite, ServiceName serviceName, String notifyBy,
                      String notifyAtHour, String notifyAtMinute) {
    this.serviceType = serviceType;
    this.serviceSite = serviceSite;
    this.serviceName = serviceName;
    this.notifyBy = notifyBy;
    this.notifyAtHour = notifyAtHour;
    this.notifyAtMinute = notifyAtMinute;
  }

  /**
   * Gets the service type.
   * @return The service type.
   */
  public ServiceType getServiceType() {
    return serviceType;
  }

  /**
   * Sets the service type.
   * @param serviceType The new service type.
   */
  public void setServiceType(ServiceType serviceType) {
    this.serviceType = serviceType;
  }

  /**
   * Gets the service site.
   * @return The service site.
   */
  public ServiceSite getServiceSite() {
    return serviceSite;
  }

  /**
   * Sets the service site.
   * @param serviceSite The new service site.
   */
  public void setServiceSite(ServiceSite serviceSite) {
    this.serviceSite = serviceSite;
  }

  /**
   * Gets the service name.
   * @return The service name.
   */
  public ServiceName getServiceName() {
    return serviceName;
  }

  /**
   * Sets the service name.
   * @param serviceName The new service name.
   */
  public void setServiceName(ServiceName serviceName) {
    this.serviceName = serviceName;
  }

  /**
   * Gets the notification preference.
   * @return The users notification preference.
   */
  public String getNotifyBy() {
    return notifyBy;
  }

  /**
   * Sets the notification preference.
   * @param notifyBy The new notification preference.
   */
  public void setNotifyBy(String notifyBy) {
    this.notifyBy = notifyBy;
  }

  /**
   * Gets the hour to notify the user.
   * @return The hour to notify the user.
   */
  public String getNotifyAtHour() {
    return notifyAtHour;
  }

  /**
   * Sets the hour to notify the user.
   * @param notifyAtHour The new hour value to notify the user.
   */
  public void setNotifyAtHour(String notifyAtHour) {
    this.notifyAtHour = notifyAtHour;
  }

  /**
   * Gets the minute to notify the user.
   * @return The minute to notify the user.
   */
  public String getNotifyAtMinute() {
    return notifyAtMinute;
  }

  /**
   * Sets the minute to notify the user.
   * @param notifyAtMinute The new minute value to notify the user.
   */
  public void setNotifyAtMinute(String notifyAtMinute) {
    this.notifyAtMinute = notifyAtMinute;
  }
}
