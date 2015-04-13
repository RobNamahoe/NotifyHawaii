package models;

import views.formdata.NewsServicesFormData;

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

  public String getHsaBreakingSubscribe() {
    return hsaBreakingSubscribe;
  }

  public String getHsaBreakingNotifyBy() {
    return hsaBreakingNotifyBy;
  }

  public String getHsaBreakingNotifyAtHour() {
    return hsaBreakingNotifyAtHour;
  }

  public String getHsaBreakingNotifyAtMinute() {
    return hsaBreakingNotifyAtMinute;
  }

  public String getHsaPopularSubscribe() {
    return hsaPopularSubscribe;
  }

  public String getHsaPopularNotifyBy() {
    return hsaPopularNotifyBy;
  }

  public String getHsaPopularNotifyAtHour() {
    return hsaPopularNotifyAtHour;
  }

  public String getHsaPopularNotifyAtMinute() {
    return hsaPopularNotifyAtMinute;
  }

  public String getHsaSportsSubscribe() {
    return hsaSportsSubscribe;
  }

  public String getHsaSportsNotifyBy() {
    return hsaSportsNotifyBy;
  }

  public String getHsaSportsNotifyAtHour() {
    return hsaSportsNotifyAtHour;
  }

  public String getHsaSportsNotifyAtMinute() {
    return hsaSportsNotifyAtMinute;
  }

  public String getMnBreakingSubscribe() {
    return mnBreakingSubscribe;
  }

  public String getMnBreakingNotifyBy() {
    return mnBreakingNotifyBy;
  }

  public String getMnBreakingNotifyAtHour() {
    return mnBreakingNotifyAtHour;
  }

  public String getMnBreakingNotifyAtMinute() {
    return mnBreakingNotifyAtMinute;
  }

  public String getMnBusinessSubscribe() {
    return mnBusinessSubscribe;
  }

  public String getMnBusinessNotifyBy() {
    return mnBusinessNotifyBy;
  }

  public String getMnBusinessNotifyAtHour() {
    return mnBusinessNotifyAtHour;
  }

  public String getMnBusinessNotifyAtMinute() {
    return mnBusinessNotifyAtMinute;
  }

  public String getMnHawaiiSubscribe() {
    return mnHawaiiSubscribe;
  }

  public String getMnHawaiiNotifyBy() {
    return mnHawaiiNotifyBy;
  }

  public String getMnHawaiiNotifyAtHour() {
    return mnHawaiiNotifyAtHour;
  }

  public String getMnHawaiiNotifyAtMinute() {
    return mnHawaiiNotifyAtMinute;
  }

  public String getMnLocalSubscribe() {
    return mnLocalSubscribe;
  }

  public String getMnLocalNotifyBy() {
    return mnLocalNotifyBy;
  }

  public String getMnLocalNotifyAtHour() {
    return mnLocalNotifyAtHour;
  }

  public String getMnLocalNotifyAtMinute() {
    return mnLocalNotifyAtMinute;
  }

  public String getCbPopularSubscribe() {
    return cbPopularSubscribe;
  }

  public String getCbPopularNotifyBy() {
    return cbPopularNotifyBy;
  }

  public String getCbPopularNotifyAtHour() {
    return cbPopularNotifyAtHour;
  }

  public String getCbPopularNotifyAtMinute() {
    return cbPopularNotifyAtMinute;
  }

  public String getCbHonoluluSubscribe() {
    return cbHonoluluSubscribe;
  }

  public String getCbHonoluluNotifyBy() {
    return cbHonoluluNotifyBy;
  }

  public String getCbHonoluluNotifyAtHour() {
    return cbHonoluluNotifyAtHour;
  }

  public String getCbHonoluluNotifyAtMinute() {
    return cbHonoluluNotifyAtMinute;
  }

  public String getCbHawaiiSubscribe() {
    return cbHawaiiSubscribe;
  }

  public String getCbHawaiiNotifyBy() {
    return cbHawaiiNotifyBy;
  }

  public String getCbHawaiiNotifyAtHour() {
    return cbHawaiiNotifyAtHour;
  }

  public String getCbHawaiiNotifyAtMinute() {
    return cbHawaiiNotifyAtMinute;
  }

  public String getCbEducationSubscribe() {
    return cbEducationSubscribe;
  }

  public String getCbEducationNotifyBy() {
    return cbEducationNotifyBy;
  }

  public String getCbEducationNotifyAtHour() {
    return cbEducationNotifyAtHour;
  }

  public String getCbEducationNotifyAtMinute() {
    return cbEducationNotifyAtMinute;
  }

  public String getCbPoliticsSubscribe() {
    return cbPoliticsSubscribe;
  }

  public String getCbPoliticsNotifyBy() {
    return cbPoliticsNotifyBy;
  }

  public String getCbPoliticsNotifyAtHour() {
    return cbPoliticsNotifyAtHour;
  }

  public String getCbPoliticsNotifyAtMinute() {
    return cbPoliticsNotifyAtMinute;
  }

  public String getCbEnergyAndEnvironmentSubscribe() {
    return cbEnergyAndEnvironmentSubscribe;
  }

  public String getCbEnergyAndEnvironmentNotifyBy() {
    return cbEnergyAndEnvironmentNotifyBy;
  }

  public String getCbEnergyAndEnvironmentNotifyAtHour() {
    return cbEnergyAndEnvironmentNotifyAtHour;
  }

  public String getCbEnergyAndEnvironmentNotifyAtMinute() {
    return cbEnergyAndEnvironmentNotifyAtMinute;
  }

  public String getCbDevelopmentSubscribe() {
    return cbDevelopmentSubscribe;
  }

  public String getCbDevelopmentNotifyBy() {
    return cbDevelopmentNotifyBy;
  }

  public String getCbDevelopmentNotifyAtHour() {
    return cbDevelopmentNotifyAtHour;
  }

  public String getCbDevelopmentNotifyAtMinute() {
    return cbDevelopmentNotifyAtMinute;
  }
}
