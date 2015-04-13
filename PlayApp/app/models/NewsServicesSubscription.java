package models;

import views.formdata.NewsServicesFormData;

import java.util.ArrayList;

/**
 * A class that represents news services subscriptions held by the user.
 */
public class NewsServicesSubscription {

  // Honolulu Star Advertiser
  private String hsaBreakingSubscribe;
  private String hsaBreakingNotifyBy;
  private String hsaBreakingNotifyAtHour;
  private String hsaBreakingNotifyAtMinute;

  private String hsaPopularSubscribe;
  private String hsaPopularNotifyBy;
  private String hsaPopularNotifyAtHour;
  private String hsaPopularNotifyAtMinute;

  private String hsaSportsSubscribe;
  private String hsaSportsNotifyBy;
  private String hsaSportsNotifyAtHour;
  private String hsaSportsNotifyAtMinute;

  // Maui News
  private String mnBreakingSubscribe;
  private String mnBreakingNotifyBy;
  private String mnBreakingNotifyAtHour;
  private String mnBreakingNotifyAtMinute;

  private String mnBusinessSubscribe;
  private String mnBusinessNotifyBy;
  private String mnBusinessNotifyAtHour;
  private String mnBusinessNotifyAtMinute;

  private String mnHawaiiSubscribe;
  private String mnHawaiiNotifyBy;
  private String mnHawaiiNotifyAtHour;
  private String mnHawaiiNotifyAtMinute;

  private String mnLocalSubscribe;
  private String mnLocalNotifyBy;
  private String mnLocalNotifyAtHour;
  private String mnLocalNotifyAtMinute;

  // Civil Beat
  private String cbPopularSubscribe;
  private String cbPopularNotifyBy;
  private String cbPopularNotifyAtHour;
  private String cbPopularNotifyAtMinute;

  private String cbHonoluluSubscribe;
  private String cbHonoluluNotifyBy;
  private String cbHonoluluNotifyAtHour;
  private String cbHonoluluNotifyAtMinute;

  private String cbHawaiiSubscribe;
  private String cbHawaiiNotifyBy;
  private String cbHawaiiNotifyAtHour;
  private String cbHawaiiNotifyAtMinute;

  private String cbEducationSubscribe;
  private String cbEducationNotifyBy;
  private String cbEducationNotifyAtHour;
  private String cbEducationNotifyAtMinute;

  private String cbPoliticsSubscribe;
  private String cbPoliticsNotifyBy;
  private String cbPoliticsNotifyAtHour;
  private String cbPoliticsNotifyAtMinute;

  private String cbEnergyAndEnvironmentSubscribe;
  private String cbEnergyAndEnvironmentNotifyBy;
  private String cbEnergyAndEnvironmentNotifyAtHour;
  private String cbEnergyAndEnvironmentNotifyAtMinute;

  private String cbDevelopmentSubscribe;
  private String cbDevelopmentNotifyBy;
  private String cbDevelopmentNotifyAtHour;
  private String cbDevelopmentNotifyAtMinute;

  /**
   * Creates a new NewsServicesSubscription object from the given formdata object.
   * @param data The form data object.
   */
  public NewsServicesSubscription(NewsServicesFormData data) {

    // Honolulu Star Advertiser
    hsaBreakingSubscribe = data.hsaBreakingSubscribe;
    hsaBreakingNotifyBy = data.hsaBreakingNotifyBy;
    hsaBreakingNotifyAtHour = data.hsaBreakingNotifyAtHour;
    hsaBreakingNotifyAtMinute = data.hsaBreakingNotifyAtMinute;

    hsaPopularSubscribe = data.hsaPopularSubscribe;
    hsaPopularNotifyBy = data.hsaPopularNotifyBy;
    hsaPopularNotifyAtHour = data.hsaPopularNotifyAtHour;
    hsaPopularNotifyAtMinute = data.hsaPopularNotifyAtMinute;

    hsaSportsSubscribe = data.hsaSportsSubscribe;
    hsaSportsNotifyBy = data.hsaSportsNotifyBy;
    hsaSportsNotifyAtHour = data.hsaSportsNotifyAtHour;
    hsaSportsNotifyAtMinute = data.hsaSportsNotifyAtMinute;

    // Maui News
    mnBreakingSubscribe = data.mnBreakingSubscribe;
    mnBreakingNotifyBy = data.mnBreakingNotifyBy;
    mnBreakingNotifyAtHour = data.mnBreakingNotifyAtHour;
    mnBreakingNotifyAtMinute = data.mnBreakingNotifyAtMinute;

    mnBusinessSubscribe = data.mnBusinessSubscribe;
    mnBusinessNotifyBy = data.mnBusinessNotifyBy;
    mnBusinessNotifyAtHour = data.mnBusinessNotifyAtHour;
    mnBusinessNotifyAtMinute = data.mnBusinessNotifyAtMinute;

    mnHawaiiSubscribe = data.mnHawaiiSubscribe;
    mnHawaiiNotifyBy = data.mnHawaiiNotifyBy;
    mnHawaiiNotifyAtHour = data.mnHawaiiNotifyAtHour;
    mnHawaiiNotifyAtMinute = data.mnHawaiiNotifyAtMinute;

    mnLocalSubscribe = data.mnLocalSubscribe;
    mnLocalNotifyBy = data.mnLocalNotifyBy;
    mnLocalNotifyAtHour = data.mnLocalNotifyAtHour;
    mnLocalNotifyAtMinute = data.mnLocalNotifyAtMinute;

    // Civil Beat
    cbPopularSubscribe = data.cbPopularSubscribe;
    cbPopularNotifyBy = data.cbPopularNotifyBy;
    cbPopularNotifyAtHour = data.cbPopularNotifyAtHour;
    cbPopularNotifyAtMinute = data.cbPopularNotifyAtMinute;

    cbHonoluluSubscribe = data.cbHonoluluSubscribe;
    cbHonoluluNotifyBy = data.cbHonoluluNotifyBy;
    cbHonoluluNotifyAtHour = data.cbHonoluluNotifyAtHour;
    cbHonoluluNotifyAtMinute = data.cbHonoluluNotifyAtMinute;

    cbHawaiiSubscribe = data.cbHawaiiSubscribe;
    cbHawaiiNotifyBy = data.cbHawaiiNotifyBy;
    cbHawaiiNotifyAtHour = data.cbHawaiiNotifyAtHour;
    cbHawaiiNotifyAtMinute = data.cbHawaiiNotifyAtMinute;

    cbEducationSubscribe = data.cbEducationSubscribe;
    cbEducationNotifyBy = data.cbEducationNotifyBy;
    cbEducationNotifyAtHour = data.cbEducationNotifyAtHour;
    cbEducationNotifyAtMinute = data.cbEducationNotifyAtMinute;

    cbPoliticsSubscribe = data.cbPoliticsSubscribe;
    cbPoliticsNotifyBy = data.cbPoliticsNotifyBy;
    cbPoliticsNotifyAtHour = data.cbPoliticsNotifyAtHour;
    cbPoliticsNotifyAtMinute = data.cbPoliticsNotifyAtMinute;

    cbEnergyAndEnvironmentSubscribe = data.cbEnergyAndEnvironmentSubscribe;
    cbEnergyAndEnvironmentNotifyBy = data.cbEnergyAndEnvironmentNotifyBy;
    cbEnergyAndEnvironmentNotifyAtHour = data.cbEnergyAndEnvironmentNotifyAtHour;
    cbEnergyAndEnvironmentNotifyAtMinute = data.cbEnergyAndEnvironmentNotifyAtMinute;

    cbDevelopmentSubscribe = data.cbDevelopmentSubscribe;
    cbDevelopmentNotifyBy = data.cbDevelopmentNotifyBy;
    cbDevelopmentNotifyAtHour = data.cbDevelopmentNotifyAtHour;
    cbDevelopmentNotifyAtMinute = data.cbDevelopmentNotifyAtMinute;

  }

  /**
   * Gets hsaBreakingSubscribe value.
   * @return The value of hsaBreakingSubscribe.
   */
  public String getHsaBreakingSubscribe() {
    return hsaBreakingSubscribe;
  }

  /**
   * Gets hsaBreakingNotifyBy value.
   * @return The value of hsaBreakingNotifyBy.
   */
  public String getHsaBreakingNotifyBy() {
    return hsaBreakingNotifyBy;
  }

  /**
   * Gets hsaBreakingNotifyAtHour value.
   * @return The value of hsaBreakingNotifyAtHour.
   */
  public String getHsaBreakingNotifyAtHour() {
    return hsaBreakingNotifyAtHour;
  }

  /**
   * Gets hsaBreakingNotifyAtMinute value.
   * @return The value of hsaBreakingNotifyAtMinute.
   */
  public String getHsaBreakingNotifyAtMinute() {
    return hsaBreakingNotifyAtMinute;
  }

  /**
   * Gets hsaPopularSubscribe value.
   * @return The value of hsaPopularSubscribe.
   */
  public String getHsaPopularSubscribe() {
    return hsaPopularSubscribe;
  }

  /**
   * Gets hsaPopularNotifyBy value.
   * @return The value of hsaPopularNotifyBy.
   */
  public String getHsaPopularNotifyBy() {
    return hsaPopularNotifyBy;
  }

  /**
   * Gets hsaPopularNotifyAtHour value.
   * @return The value of hsaPopularNotifyAtHour.
   */
  public String getHsaPopularNotifyAtHour() {
    return hsaPopularNotifyAtHour;
  }

  /**
   * Gets hsaPopularNotifyAtMinute value.
   * @return The value of hsaPopularNotifyAtMinute.
   */
  public String getHsaPopularNotifyAtMinute() {
    return hsaPopularNotifyAtMinute;
  }

  /**
   * Gets hsaSportsSubscribe value.
   * @return The value of hsaSportsSubscribe.
   */
  public String getHsaSportsSubscribe() {
    return hsaSportsSubscribe;
  }

  /**
   * Gets hsaSportsNotifyBy value.
   * @return The value of hsaSportsNotifyBy.
   */
  public String getHsaSportsNotifyBy() {
    return hsaSportsNotifyBy;
  }

  /**
   * Gets hsaSportsNotifyAtHour value.
   * @return The value of hsaSportsNotifyAtHour.
   */
  public String getHsaSportsNotifyAtHour() {
    return hsaSportsNotifyAtHour;
  }

  /**
   * Gets hsaSportsNotifyAtMinute value.
   * @return The value of hsaSportsNotifyAtMinute.
   */
  public String getHsaSportsNotifyAtMinute() {
    return hsaSportsNotifyAtMinute;
  }

  /**
   * Gets mnBreakingSubscribe value.
   * @return The value of mnBreakingSubscribe.
   */
  public String getMnBreakingSubscribe() {
    return mnBreakingSubscribe;
  }

  /**
   * Gets mnBreakingNotifyBy value.
   * @return The value of mnBreakingNotifyBy.
   */
  public String getMnBreakingNotifyBy() {
    return mnBreakingNotifyBy;
  }

  /**
   * Gets mnBreakingNotifyAtHour value.
   * @return The value of mnBreakingNotifyAtHour.
   */
  public String getMnBreakingNotifyAtHour() {
    return mnBreakingNotifyAtHour;
  }

  /**
   * Gets mnBreakingNotifyAtMinute value.
   * @return The value of mnBreakingNotifyAtMinute.
   */
  public String getMnBreakingNotifyAtMinute() {
    return mnBreakingNotifyAtMinute;
  }

  /**
   * Gets mnBusinessSubscribe value.
   * @return The value of mnBusinessSubscribe.
   */
  public String getMnBusinessSubscribe() {
    return mnBusinessSubscribe;
  }

  /**
   * Gets mnBusinessNotifyBy value.
   * @return The value of mnBusinessNotifyBy.
   */
  public String getMnBusinessNotifyBy() {
    return mnBusinessNotifyBy;
  }

  /**
   * Gets mnBusinessNotifyAtHour value.
   * @return The value of mnBusinessNotifyAtHour.
   */
  public String getMnBusinessNotifyAtHour() {
    return mnBusinessNotifyAtHour;
  }

  /**
   * Gets mnBusinessNotifyAtMinute value.
   * @return The value of mnBusinessNotifyAtMinute.
   */
  public String getMnBusinessNotifyAtMinute() {
    return mnBusinessNotifyAtMinute;
  }

  /**
   * Gets mnHawaiiSubscribe value.
   * @return The value of mnHawaiiSubscribe.
   */
  public String getMnHawaiiSubscribe() {
    return mnHawaiiSubscribe;
  }

  /**
   * Gets mnHawaiiNotifyBy value.
   * @return The value of mnHawaiiNotifyBy.
   */
  public String getMnHawaiiNotifyBy() {
    return mnHawaiiNotifyBy;
  }

  /**
   * Gets mnHawaiiNotifyAtHour value.
   * @return The value of mnHawaiiNotifyAtHour.
   */
  public String getMnHawaiiNotifyAtHour() {
    return mnHawaiiNotifyAtHour;
  }

  /**
   * Gets mnHawaiiNotifyAtMinute value.
   * @return The value of mnHawaiiNotifyAtMinute.
   */
  public String getMnHawaiiNotifyAtMinute() {
    return mnHawaiiNotifyAtMinute;
  }

  /**
   * Gets value of mnLocalSubscribe.
   * @return The value of mnLocalSubscribe.
   */
  public String getMnLocalSubscribe() {
    return mnLocalSubscribe;
  }

  /**
   * Gets value of mnLocalNotifyBy.
   * @return The value of mnLocalNotifyBy.
   */
  public String getMnLocalNotifyBy() {
    return mnLocalNotifyBy;
  }

  /**
   * Gets value of getMnLocalNotifyAtHour.
   * @return The value of getMnLocalNotifyAtHour.
   */
  public String getMnLocalNotifyAtHour() {
    return mnLocalNotifyAtHour;
  }

  /**
   * Gets value of mnLocalNotifyAtMinute.
   * @return The value of mnLocalNotifyAtMinute.
   */
  public String getMnLocalNotifyAtMinute() {
    return mnLocalNotifyAtMinute;
  }

  /**
   * Gets value of cbPopularSubscribe.
   * @return The value of cbPopularSubscribe.
   */
  public String getCbPopularSubscribe() {
    return cbPopularSubscribe;
  }

  /**
   * Gets value of cbPopularNotifyBy.
   * @return The value of cbPopularNotifyBy.
   */
  public String getCbPopularNotifyBy() {
    return cbPopularNotifyBy;
  }

  /**
   * Gets value of cbPopularNotifyAtHour.
   * @return The value of cbPopularNotifyAtHour.
   */
  public String getCbPopularNotifyAtHour() {
    return cbPopularNotifyAtHour;
  }

  /**
   * Gets value of cbPopularNotifyAtMinute.
   * @return The value of cbPopularNotifyAtMinute.
   */
  public String getCbPopularNotifyAtMinute() {
    return cbPopularNotifyAtMinute;
  }

  /**
   * Gets value of cbHonoluluSubscribe.
   * @return The value of cbHonoluluSubscribe.
   */
  public String getCbHonoluluSubscribe() {
    return cbHonoluluSubscribe;
  }

  /**
   * Gets value of cbHonoluluNotifyBy.
   * @return The value of cbHonoluluNotifyBy.
   */
  public String getCbHonoluluNotifyBy() {
    return cbHonoluluNotifyBy;
  }

  /**
   * Gets value of cbHonoluluNotifyAtHour.
   * @return The value of cbHonoluluNotifyAtHour.
   */
  public String getCbHonoluluNotifyAtHour() {
    return cbHonoluluNotifyAtHour;
  }

  /**
   * Gets value of cbHonoluluNotifyAtMinute.
   * @return The value of cbHonoluluNotifyAtMinute.
   */
  public String getCbHonoluluNotifyAtMinute() {
    return cbHonoluluNotifyAtMinute;
  }

  /**
   * Gets value of cbHawaiiSubscribe.
   * @return The value of cbHawaiiSubscribe.
   */
  public String getCbHawaiiSubscribe() {
    return cbHawaiiSubscribe;
  }

  /**
   * Gets value of cbHawaiiNotifyBy.
   * @return The value of cbHawaiiNotifyBy.
   */
  public String getCbHawaiiNotifyBy() {
    return cbHawaiiNotifyBy;
  }

  /**
   * Gets value of getCbHawaiiNotifyAtHour.
   * @return The value of getCbHawaiiNotifyAtHour.
   */
  public String getCbHawaiiNotifyAtHour() {
    return cbHawaiiNotifyAtHour;
  }

  /**
   * Gets value of getCbHawaiiNotifyAtMinute.
   * @return The value of getCbHawaiiNotifyAtMinute.
   */
  public String getCbHawaiiNotifyAtMinute() {
    return cbHawaiiNotifyAtMinute;
  }

  /**
   * Gets value of cbEducationSubscribe.
   * @return The value of cbEducationSubscribe.
   */
  public String getCbEducationSubscribe() {
    return cbEducationSubscribe;
  }

  /**
   * Gets value of cbEducationNotifyBy.
   * @return The value of cbEducationNotifyBy.
   */
  public String getCbEducationNotifyBy() {
    return cbEducationNotifyBy;
  }

  /**
   * Gets value of cbEducationNotifyAtHour.
   * @return The value of cbEducationNotifyAtHour.
   */
  public String getCbEducationNotifyAtHour() {
    return cbEducationNotifyAtHour;
  }

  /**
   * Gets value of cbEducationNotifyAtMinute.
   * @return The value of cbEducationNotifyAtMinute.
   */
  public String getCbEducationNotifyAtMinute() {
    return cbEducationNotifyAtMinute;
  }

  /**
   * Gets value of cbPoliticsSubscribe.
   * @return The value of cbPoliticsSubscribe.
   */
  public String getCbPoliticsSubscribe() {
    return cbPoliticsSubscribe;
  }

  /**
   * Gets value of cbPoliticsNotifyBy.
   * @return The value of cbPoliticsNotifyBy.
   */
  public String getCbPoliticsNotifyBy() {
    return cbPoliticsNotifyBy;
  }

  /**
   * Gets value of cbPoliticsNotifyAtHour.
   * @return The value of cbPoliticsNotifyAtHour.
   */
  public String getCbPoliticsNotifyAtHour() {
    return cbPoliticsNotifyAtHour;
  }

  /**
   * Gets value of cbPoliticsNotifyAtMinute.
   * @return The value of cbPoliticsNotifyAtMinute.
   */
  public String getCbPoliticsNotifyAtMinute() {
    return cbPoliticsNotifyAtMinute;
  }

  /**
   * Gets value of cbEnergyAndEnvironmentSubscribe.
   * @return The value of cbEnergyAndEnvironmentSubscribe.
   */
  public String getCbEnergyAndEnvironmentSubscribe() {
    return cbEnergyAndEnvironmentSubscribe;
  }

  /**
   * Gets value of cbEnergyAndEnvironmentNotifyBy.
   * @return The value of cbEnergyAndEnvironmentNotifyBy.
   */
  public String getCbEnergyAndEnvironmentNotifyBy() {
    return cbEnergyAndEnvironmentNotifyBy;
  }

  /**
   * Gets value of cbEnergyAndEnvironmentNotifyAtHour.
   * @return The value of cbEnergyAndEnvironmentNotifyAtHour.
   */
  public String getCbEnergyAndEnvironmentNotifyAtHour() {
    return cbEnergyAndEnvironmentNotifyAtHour;
  }

  /**
   * Gets value of cbEnergyAndEnvironmentNotifyAtMinute.
   * @return The value of cbEnergyAndEnvironmentNotifyAtMinute.
   */
  public String getCbEnergyAndEnvironmentNotifyAtMinute() {
    return cbEnergyAndEnvironmentNotifyAtMinute;
  }

  /**
   * Gets value of cbDevelopmentSubscribe.
   * @return The value of cbDevelopmentSubscribe.
   */
  public String getCbDevelopmentSubscribe() {
    return cbDevelopmentSubscribe;
  }

  /**
   * Gets value of cbDevelopmentNotifyBy.
   * @return The value of cbDevelopmentNotifyBy.
   */
  public String getCbDevelopmentNotifyBy() {
    return cbDevelopmentNotifyBy;
  }

  /**
   * Gets value of cbDevelopmentNotifyAtHour.
   * @return The value of cbDevelopmentNotifyAtHour.
   */
  public String getCbDevelopmentNotifyAtHour() {
    return cbDevelopmentNotifyAtHour;
  }

  /**
   * Gets value of cbDevelopmentNotifyAtMinute.
   * @return The value of cbDevelopmentNotifyAtMinute.
   */
  public String getCbDevelopmentNotifyAtMinute() {
    return cbDevelopmentNotifyAtMinute;
  }

  /**
   * Gets a list of the articles to send via email.
   * @return A list of articles to send via email.
   */
  public ArrayList<String> getEmailSubscriptions() {
    return getSubscriptions("Email");
  }

  /**
   * Gets a list of the articles to send via text message.
   * @return A list of articles to send via text message.
   */
  public ArrayList<String> getTextSubscriptions() {
    return getSubscriptions("Text");
  }

  /**
   * Identifies subscriptions by notification type.
   * @param notifyBy The notification type.
   * @return A list of subscriptions by notification type.
   */
  private ArrayList<String> getSubscriptions(String notifyBy) {

    ArrayList<String> subscriptions = new ArrayList<>();

    if (this.hsaBreakingSubscribe.equals("Yes")) {
      if (this.hsaBreakingNotifyBy.equals(notifyBy)) {
        subscriptions.add("hsaBreaking");
      }
    }

    if (this.hsaPopularSubscribe.equals("Yes")) {
      if (this.hsaPopularNotifyBy.equals(notifyBy)) {
        subscriptions.add("hsaPopular");
      }
    }

    if (this.hsaSportsSubscribe.equals("Yes")) {
      if (this.hsaSportsNotifyBy.equals(notifyBy)) {
        subscriptions.add("hsaSports");
      }
    }

    // Maui News
    if (this.mnBreakingSubscribe.equals("Yes")) {
      if (this.mnBreakingNotifyBy.equals(notifyBy)) {
        subscriptions.add("mnBreaking");
      }
    }

    if (this.mnBusinessSubscribe.equals("Yes")) {
      if (this.mnBusinessNotifyBy.equals(notifyBy)) {
        subscriptions.add("mnBusiness");
      }
    }

    if (this.mnHawaiiSubscribe.equals("Yes")) {
      if (this.mnHawaiiNotifyBy.equals(notifyBy)) {
        subscriptions.add("mnHawaii");
      }
    }

    if (this.mnLocalSubscribe.equals("Yes")) {
      if (this.mnLocalNotifyBy.equals(notifyBy)) {
        subscriptions.add("mnLocal");
      }
    }

    // Civil Beat
    if (this.cbPopularSubscribe.equals("Yes")) {
      if (this.cbPopularNotifyBy.equals(notifyBy)) {
        subscriptions.add("cbPopular");
      }
    }

    if (this.cbHonoluluSubscribe.equals("Yes")) {
      if (this.cbHonoluluNotifyBy.equals(notifyBy)) {
        subscriptions.add("cbHonolulu");
      }
    }

    if (this.cbHawaiiSubscribe.equals("Yes")) {
      if (this.cbHawaiiNotifyBy.equals(notifyBy)) {
        subscriptions.add("cbHawaii");
      }
    }

    if (this.cbEducationSubscribe.equals("Yes")) {
      if (this.cbEducationNotifyBy.equals(notifyBy)) {
        subscriptions.add("cbEducation");
      }
    }

    if (this.cbPoliticsSubscribe.equals("Yes")) {
      if (this.cbPoliticsNotifyBy.equals(notifyBy)) {
        subscriptions.add("cbPolitics");
      }
    }

    if (this.cbEnergyAndEnvironmentSubscribe.equals("Yes")) {
      if (this.cbEnergyAndEnvironmentNotifyBy.equals(notifyBy)) {
        subscriptions.add("cbEnergyAndEnvironment");
      }
    }

    if (this.cbDevelopmentSubscribe.equals("Yes")) {
      if (this.cbDevelopmentNotifyBy.equals(notifyBy)) {
        subscriptions.add("cbDevelopment");
      }
    }

    return subscriptions;

  }

}
