package views.formdata;

import models.NewsServicesSubscription;

/**
 * Backing class for News Services form.
 */
public class NewsServicesFormData {

  /** Honolulu Star Advertiser Breaking News subscription. */
  public String hsaBreakingSubscribe = "No";
  /** Honolulu Star Advertiser Breaking News notification method. */
  public String hsaBreakingNotifyBy = "Email";
  /** Honolulu Star Advertiser Breaking News notification hour. */
  public String hsaBreakingNotifyAtHour = "0";
  /** Honolulu Star Advertiser Breaking News notification minute. */
  public String hsaBreakingNotifyAtMinute = "0";

  /** Honolulu Star Advertiser Popular News subscription. */
  public String hsaPopularSubscribe = "No";
  /** Honolulu Star Advertiser Popular News notification method. */
  public String hsaPopularNotifyBy = "Email";
  /** Honolulu Star Advertiser Popular News notification hour. */
  public String hsaPopularNotifyAtHour = "0";
  /** Honolulu Star Advertiser Popular News notification minute. */
  public String hsaPopularNotifyAtMinute = "0";

  /** Honolulu Star Advertiser Sports News subscription. */
  public String hsaSportsSubscribe = "No";
  /** Honolulu Star Advertiser Sports News notification method. */
  public String hsaSportsNotifyBy = "Email";
  /** Honolulu Star Advertiser Sports News notification hour. */
  public String hsaSportsNotifyAtHour = "0";
  /** Honolulu Star Advertiser Sports News notification minute. */
  public String hsaSportsNotifyAtMinute = "0";

  // Maui News
  /** Maui News Breaking News subscription. */
  public String mnBreakingSubscribe = "No";
  /** Maui News Breaking News notification method. */
  public String mnBreakingNotifyBy = "Email";
  /** Maui News Breaking News notification hour. */
  public String mnBreakingNotifyAtHour = "0";
  /** Maui News Breaking News notification minute. */
  public String mnBreakingNotifyAtMinute = "0";

  /** Maui News Sports Business subscription. */
  public String mnBusinessSubscribe = "No";
  /** Maui News Sports Business notification method. */
  public String mnBusinessNotifyBy = "Email";
  /** Maui News Sports Business notification hour. */
  public String mnBusinessNotifyAtHour = "0";
  /** Maui News Sports Business notification minute. */
  public String mnBusinessNotifyAtMinute = "0";


  /** Maui News Hawaii News subscription. */
  public String mnHawaiiSubscribe = "No";
  /** Maui News Hawaii News notification method. */
  public String mnHawaiiNotifyBy = "Email";
  /** Maui News Hawaii News notification hour. */
  public String mnHawaiiNotifyAtHour = "0";
  /** Maui News Hawaii News notification minute. */
  public String mnHawaiiNotifyAtMinute = "0";

  /** Maui News Local News subscription. */
  public String mnLocalSubscribe = "No";
  /** Maui News Local News notification method. */
  public String mnLocalNotifyBy = "Email";
  /** Maui News Local News notification hour. */
  public String mnLocalNotifyAtHour = "0";
  /** Maui News Local News notification minute. */
  public String mnLocalNotifyAtMinute = "0";

  // Civil Beat
  /** Civil Beat Popular News subscription. */
  public String cbPopularSubscribe = "No";
  /** Civil Beat Popular News notification method. */
  public String cbPopularNotifyBy = "Email";
  /** Civil Beat Popular News notification hour. */
  public String cbPopularNotifyAtHour = "0";
  /** Civil Beat Popular News notification minute. */
  public String cbPopularNotifyAtMinute = "0";

  /** Civil Beat Honolulu News subscription. */
  public String cbHonoluluSubscribe = "No";
  /** Civil Beat Honolulu News notification method. */
  public String cbHonoluluNotifyBy = "Email";
  /** Civil Beat Honolulu News notification hour. */
  public String cbHonoluluNotifyAtHour = "0";
  /** Civil Beat Honolulu News notification minute. */
  public String cbHonoluluNotifyAtMinute = "0";

  /** Civil Beat Hawaii News subscription. */
  public String cbHawaiiSubscribe = "No";
  /** Civil Beat Hawaii News notification method. */
  public String cbHawaiiNotifyBy = "Email";
  /** Civil Beat Hawaii News notification hour. */
  public String cbHawaiiNotifyAtHour = "0";
  /** Civil Beat Hawaii News notification minute. */
  public String cbHawaiiNotifyAtMinute = "0";

  /** Civil Beat Education News subscription. */
  public String cbEducationSubscribe = "No";
  /** Civil Beat Education News notification method. */
  public String cbEducationNotifyBy = "Email";
  /** Civil Beat Education News notification hour. */
  public String cbEducationNotifyAtHour = "0";
  /** Civil Beat Education News notification minute. */
  public String cbEducationNotifyAtMinute = "0";

  /** Civil Beat Politics News subscription. */
  public String cbPoliticsSubscribe = "No";
  /** Civil Beat Politics News notification method. */
  public String cbPoliticsNotifyBy = "Email";
  /** Civil Beat Politics News notification hour. */
  public String cbPoliticsNotifyAtHour = "0";
  /** Civil Beat Politics News notification minute. */
  public String cbPoliticsNotifyAtMinute = "0";

  /** Civil Beat Energy and Environment News subscription. */
  public String cbEnergyAndEnvironmentSubscribe = "No";
  /** Civil Beat Energy and Environment News notification method. */
  public String cbEnergyAndEnvironmentNotifyBy = "Email";
  /** Civil Beat Energy and Environment News notification hour. */
  public String cbEnergyAndEnvironmentNotifyAtHour = "0";
  /** Civil Beat Energy and Environment News notification minute. */
  public String cbEnergyAndEnvironmentNotifyAtMinute = "0";

  /** Civil Beat Development News subscription. */
  public String cbDevelopmentSubscribe = "No";
  /** Civil Beat Development News notification method. */
  public String cbDevelopmentNotifyBy = "Email";
  /** Civil Beat Development News notification hour. */
  public String cbDevelopmentNotifyAtHour = "0";
  /** Civil Beat Development News notification minute. */
  public String cbDevelopmentNotifyAtMinute = "0";

  /** Required for form instantiation. */
  public NewsServicesFormData() {
  }

  /**
   * Constructs a new NewsServicesFormData instance from the given NewsServicesSubscription object.
   * @param subscription The NewsServicesSubscription object.
   */
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
