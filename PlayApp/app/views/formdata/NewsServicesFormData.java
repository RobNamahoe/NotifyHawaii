package views.formdata;

import models.NewsServicesSubscription;

/**
 * Backing class for News Services form.
 */
public class NewsServicesFormData {

  // Honolulu Star Advertiser
  public String hsaBreakingSubscribe = "No";
  public String hsaBreakingNotifyBy = "Email";
  public String hsaBreakingNotifyAtHour = "0";
  public String hsaBreakingNotifyAtMinute = "0";

  public String hsaPopularSubscribe = "No";
  public String hsaPopularNotifyBy = "Email";
  public String hsaPopularNotifyAtHour = "0";
  public String hsaPopularNotifyAtMinute = "0";

  public String hsaSportsSubscribe = "No";
  public String hsaSportsNotifyBy = "Email";
  public String hsaSportsNotifyAtHour = "0";
  public String hsaSportsNotifyAtMinute = "0";

  // Maui News
  public String mnBreakingSubscribe = "No";
  public String mnBreakingNotifyBy = "Email";
  public String mnBreakingNotifyAtHour = "0";
  public String mnBreakingNotifyAtMinute = "0";


  public String mnBusinessSubscribe = "No";
  public String mnBusinessNotifyBy = "Email";
  public String mnBusinessNotifyAtHour = "0";
  public String mnBusinessNotifyAtMinute = "0";

  public String mnHawaiiSubscribe = "No";
  public String mnHawaiiNotifyBy = "Email";
  public String mnHawaiiNotifyAtHour = "0";
  public String mnHawaiiNotifyAtMinute = "0";

  public String mnLocalSubscribe = "No";
  public String mnLocalNotifyBy = "Email";
  public String mnLocalNotifyAtHour = "0";
  public String mnLocalNotifyAtMinute = "0";

  // Civil Beat
  public String cbPopularSubscribe = "No";
  public String cbPopularNotifyBy = "Email";
  public String cbPopularNotifyAtHour = "0";
  public String cbPopularNotifyAtMinute = "0";

  public String cbHonoluluSubscribe = "No";
  public String cbHonoluluNotifyBy = "Email";
  public String cbHonoluluNotifyAtHour = "0";
  public String cbHonoluluNotifyAtMinute = "0";

  public String cbHawaiiSubscribe = "No";
  public String cbHawaiiNotifyBy = "Email";
  public String cbHawaiiNotifyAtHour = "0";
  public String cbHawaiiNotifyAtMinute = "0";

  public String cbEducationSubscribe = "No";
  public String cbEducationNotifyBy = "Email";
  public String cbEducationNotifyAtHour = "0";
  public String cbEducationNotifyAtMinute = "0";

  public String cbPoliticsSubscribe = "No";
  public String cbPoliticsNotifyBy = "Email";
  public String cbPoliticsNotifyAtHour = "0";
  public String cbPoliticsNotifyAtMinute = "0";

  public String cbEnergyAndEnvironmentSubscribe = "No";
  public String cbEnergyAndEnvironmentNotifyBy = "Email";
  public String cbEnergyAndEnvironmentNotifyAtHour = "0";
  public String cbEnergyAndEnvironmentNotifyAtMinute = "0";
  public String cbDevelopmentSubscribe = "No";
  public String cbDevelopmentNotifyBy = "Email";
  public String cbDevelopmentNotifyAtHour = "0";
  public String cbDevelopmentNotifyAtMinute = "0";

  /** Required for form instantiation. */
  public NewsServicesFormData() {
  }

  public NewsServicesFormData(NewsServicesSubscription subscription) {

    // Honolulu Star Advertiser
    hsaBreakingSubscribe = subscription.getHsaBreakingSubscribe();
    hsaBreakingNotifyBy = subscription.getHsaBreakingNotifyBy();
    hsaBreakingNotifyAtHour = subscription.getHsaBreakingNotifyAtHour();
    hsaBreakingNotifyAtMinute = subscription.getHsaBreakingNotifyAtMinute();

    hsaPopularSubscribe = subscription.getHsaPopularSubscribe();
    hsaPopularNotifyBy = subscription.getHsaPopularNotifyBy();
    hsaPopularNotifyAtHour = subscription.getHsaPopularNotifyAtHour();
    hsaPopularNotifyAtMinute = subscription.getHsaPopularNotifyAtMinute();

    hsaSportsSubscribe = subscription.getHsaSportsSubscribe();
    hsaSportsNotifyBy = subscription.getHsaSportsNotifyBy();
    hsaSportsNotifyAtHour = subscription.getHsaSportsNotifyAtHour();
    hsaSportsNotifyAtMinute = subscription.getHsaSportsNotifyAtMinute();

    // Maui News
    mnBreakingSubscribe = subscription.getMnBreakingSubscribe();
    mnBreakingNotifyBy = subscription.getMnBreakingNotifyBy();
    mnBreakingNotifyAtHour = subscription.getMnBreakingNotifyAtHour();
    mnBreakingNotifyAtMinute = subscription.getMnBreakingNotifyAtMinute();


    mnBusinessSubscribe = subscription.getMnBusinessSubscribe();
    mnBusinessNotifyBy = subscription.getMnBusinessNotifyBy();
    mnBusinessNotifyAtHour = subscription.getMnBusinessNotifyAtHour();
    mnBusinessNotifyAtMinute = subscription.getMnBusinessNotifyAtMinute();

    mnHawaiiSubscribe = subscription.getMnHawaiiSubscribe();
    mnHawaiiNotifyBy = subscription.getMnHawaiiNotifyBy();
    mnHawaiiNotifyAtHour = subscription.getMnHawaiiNotifyAtHour();
    mnHawaiiNotifyAtMinute = subscription.getMnHawaiiNotifyAtMinute();

    mnLocalSubscribe = subscription.getMnLocalSubscribe();
    mnLocalNotifyBy = subscription.getMnLocalNotifyBy();
    mnLocalNotifyAtHour = subscription.getMnLocalNotifyAtHour();
    mnLocalNotifyAtMinute = subscription.getMnLocalNotifyAtMinute();

    // Civil Beat
    cbPopularSubscribe = subscription.getCbPopularSubscribe();
    cbPopularNotifyBy = subscription.getCbPopularNotifyBy();
    cbPopularNotifyAtHour = subscription.getCbPopularNotifyAtHour();
    cbPopularNotifyAtMinute = subscription.getCbPopularNotifyAtMinute();

    cbHonoluluSubscribe = subscription.getCbHonoluluSubscribe();
    cbHonoluluNotifyBy = subscription.getCbHonoluluNotifyBy();
    cbHonoluluNotifyAtHour = subscription.getCbHonoluluNotifyAtHour();
    cbHonoluluNotifyAtMinute = subscription.getCbHonoluluNotifyAtMinute();

    cbHawaiiSubscribe = subscription.getCbHawaiiSubscribe();
    cbHawaiiNotifyBy = subscription.getCbHawaiiNotifyBy();
    cbHawaiiNotifyAtHour = subscription.getCbHawaiiNotifyAtHour();
    cbHawaiiNotifyAtMinute = subscription.getCbHawaiiNotifyAtMinute();

    cbEducationSubscribe = subscription.getCbEducationSubscribe();
    cbEducationNotifyBy = subscription.getCbEducationNotifyBy();
    cbEducationNotifyAtHour = subscription.getCbEducationNotifyAtHour();
    cbEducationNotifyAtMinute = subscription.getCbEducationNotifyAtMinute();

    cbPoliticsSubscribe = subscription.getCbPoliticsSubscribe();
    cbPoliticsNotifyBy = subscription.getCbPoliticsNotifyBy();
    cbPoliticsNotifyAtHour = subscription.getCbPoliticsNotifyAtHour();
    cbPoliticsNotifyAtMinute = subscription.getCbPoliticsNotifyAtMinute();

    cbEnergyAndEnvironmentSubscribe = subscription.getCbEnergyAndEnvironmentSubscribe();
    cbEnergyAndEnvironmentNotifyBy = subscription.getCbEnergyAndEnvironmentNotifyBy();
    cbEnergyAndEnvironmentNotifyAtHour = subscription.getCbEnergyAndEnvironmentNotifyAtHour();
    cbEnergyAndEnvironmentNotifyAtMinute = subscription.getCbEnergyAndEnvironmentNotifyAtMinute();

    cbDevelopmentSubscribe = subscription.getCbDevelopmentSubscribe();
    cbDevelopmentNotifyBy = subscription.getCbDevelopmentNotifyBy();
    cbDevelopmentNotifyAtHour = subscription.getCbDevelopmentNotifyAtHour();
    cbDevelopmentNotifyAtMinute = subscription.getCbDevelopmentNotifyAtMinute();

  }



}
