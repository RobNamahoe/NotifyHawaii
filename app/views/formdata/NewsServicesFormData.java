package views.formdata;

import models.NewsServicesSubscription;

import java.util.List;

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
  /** Honolulu Star Advertiser Breaking News notification period. */
  public String hsaBreakingNotifyAtPeriod = "AM";

  /** Honolulu Star Advertiser Popular News subscription. */
  public String hsaPopularSubscribe = "No";
  /** Honolulu Star Advertiser Popular News notification method. */
  public String hsaPopularNotifyBy = "Email";
  /** Honolulu Star Advertiser Popular News notification hour. */
  public String hsaPopularNotifyAtHour = "0";
  /** Honolulu Star Advertiser Popular News notification period. */
  public String hsaPopularNotifyAtPeriod = "AM";

  /** Honolulu Star Advertiser Sports News subscription. */
  public String hsaSportsSubscribe = "No";
  /** Honolulu Star Advertiser Sports News notification method. */
  public String hsaSportsNotifyBy = "Email";
  /** Honolulu Star Advertiser Sports News notification hour. */
  public String hsaSportsNotifyAtHour = "0";
  /** Honolulu Star Advertiser Sports News notification period. */
  public String hsaSportsNotifyAtPeriod = "AM";

  // Maui News
  /** Maui News Breaking News subscription. */
  public String mnBreakingSubscribe = "No";
  /** Maui News Breaking News notification method. */
  public String mnBreakingNotifyBy = "Email";
  /** Maui News Breaking News notification hour. */
  public String mnBreakingNotifyAtHour = "0";
  /** Maui News Breaking News notification period. */
  public String mnBreakingNotifyAtPeriod = "AM";

  /** Maui News Sports Business subscription. */
  public String mnBusinessSubscribe = "No";
  /** Maui News Sports Business notification method. */
  public String mnBusinessNotifyBy = "Email";
  /** Maui News Sports Business notification hour. */
  public String mnBusinessNotifyAtHour = "0";
  /** Maui News Sports Business notification period. */
  public String mnBusinessNotifyAtPeriod = "AM";


  /** Maui News Hawaii News subscription. */
  public String mnHawaiiSubscribe = "No";
  /** Maui News Hawaii News notification method. */
  public String mnHawaiiNotifyBy = "Email";
  /** Maui News Hawaii News notification hour. */
  public String mnHawaiiNotifyAtHour = "0";
  /** Maui News Hawaii News notification period. */
  public String mnHawaiiNotifyAtPeriod = "AM";

  /** Maui News Local News subscription. */
  public String mnLocalSubscribe = "No";
  /** Maui News Local News notification method. */
  public String mnLocalNotifyBy = "Email";
  /** Maui News Local News notification hour. */
  public String mnLocalNotifyAtHour = "0";
  /** Maui News Local News notification period. */
  public String mnLocalNotifyAtPeriod = "AM";

  // Civil Beat
  /** Civil Beat Popular News subscription. */
  public String cbPopularSubscribe = "No";
  /** Civil Beat Popular News notification method. */
  public String cbPopularNotifyBy = "Email";
  /** Civil Beat Popular News notification hour. */
  public String cbPopularNotifyAtHour = "0";
  /** Civil Beat Popular News notification period. */
  public String cbPopularNotifyAtPeriod = "AM";

  /** Civil Beat Honolulu News subscription. */
  public String cbHonoluluSubscribe = "No";
  /** Civil Beat Honolulu News notification method. */
  public String cbHonoluluNotifyBy = "Email";
  /** Civil Beat Honolulu News notification hour. */
  public String cbHonoluluNotifyAtHour = "0";
  /** Civil Beat Honolulu News notification period. */
  public String cbHonoluluNotifyAtPeriod = "AM";

  /** Civil Beat Hawaii News subscription. */
  public String cbHawaiiSubscribe = "No";
  /** Civil Beat Hawaii News notification method. */
  public String cbHawaiiNotifyBy = "Email";
  /** Civil Beat Hawaii News notification hour. */
  public String cbHawaiiNotifyAtHour = "0";
  /** Civil Beat Hawaii News notification period. */
  public String cbHawaiiNotifyAtPeriod = "AM";

  /** Civil Beat Education News subscription. */
  public String cbEducationSubscribe = "No";
  /** Civil Beat Education News notification method. */
  public String cbEducationNotifyBy = "Email";
  /** Civil Beat Education News notification hour. */
  public String cbEducationNotifyAtHour = "0";
  /** Civil Beat Education News notification period. */
  public String cbEducationNotifyAtPeriod = "AM";

  /** Civil Beat Politics News subscription. */
  public String cbPoliticsSubscribe = "No";
  /** Civil Beat Politics News notification method. */
  public String cbPoliticsNotifyBy = "Email";
  /** Civil Beat Politics News notification hour. */
  public String cbPoliticsNotifyAtHour = "0";
  /** Civil Beat Politics News notification period. */
  public String cbPoliticsNotifyAtPeriod = "AM";

  /** Civil Beat Energy and Environment News subscription. */
  public String cbEnergyAndEnvironmentSubscribe = "No";
  /** Civil Beat Energy and Environment News notification method. */
  public String cbEnergyAndEnvironmentNotifyBy = "Email";
  /** Civil Beat Energy and Environment News notification hour. */
  public String cbEnergyAndEnvironmentNotifyAtHour = "0";
  /** Civil Beat Energy and Environment News notification period. */
  public String cbEnergyAndEnvironmentNotifyAtPeriod = "AM";

  /** Civil Beat Development News subscription. */
  public String cbDevelopmentSubscribe = "No";
  /** Civil Beat Development News notification method. */
  public String cbDevelopmentNotifyBy = "Email";
  /** Civil Beat Development News notification hour. */
  public String cbDevelopmentNotifyAtHour = "0";
  /** Civil Beat Development News notification period. */
  public String cbDevelopmentNotifyAtPeriod = "AM";

  /** Required for form instantiation. */
  public NewsServicesFormData() {
  }


  /**
   * Constructs a new NewsServicesFormData instance from the given NewsServicesSubscription object.
   * @param subscriptions A list NewsServicesSubscription objects.
   */
  public NewsServicesFormData(List<NewsServicesSubscription> subscriptions) {

    // Honolulu Star Advertiser
    for (NewsServicesSubscription subscription : subscriptions) {

      System.out.println(subscription.getSite() + ", " + subscription.getTopic());

      String site = subscription.getSite();
      String topic = subscription.getTopic();

      if (site.equalsIgnoreCase("Honolulu Star Advertiser")) {
        if (topic.equalsIgnoreCase("Breaking")) {
          hsaBreakingSubscribe = "Yes";
          hsaBreakingNotifyBy = subscription.getMethod();
          hsaBreakingNotifyAtHour = subscription.getHour();
          hsaBreakingNotifyAtPeriod = subscription.getPeriod();
        }
        else if (topic.equalsIgnoreCase("Popular")) {
          hsaPopularSubscribe = "Yes";
          hsaPopularNotifyBy = subscription.getMethod();
          hsaPopularNotifyAtHour = subscription.getHour();
          hsaPopularNotifyAtPeriod = subscription.getPeriod();
        }
        else if (topic.equalsIgnoreCase("Sports")) {
          hsaSportsSubscribe = "Yes";
          hsaSportsNotifyBy = subscription.getMethod();
          hsaSportsNotifyAtHour = subscription.getHour();
          hsaSportsNotifyAtPeriod = subscription.getPeriod();
        }
      }
      else if (site.equals("Maui News")) {

        if (topic.equalsIgnoreCase("Breaking")) {
          mnBreakingSubscribe = "Yes";
          mnBreakingNotifyBy = subscription.getMethod();
          mnBreakingNotifyAtHour = subscription.getHour();
          mnBreakingNotifyAtPeriod = subscription.getPeriod();
        }
        else if (topic.equalsIgnoreCase("Business")) {
          mnBusinessSubscribe = "Yes";
          mnBusinessNotifyBy = subscription.getMethod();
          mnBusinessNotifyAtHour = subscription.getHour();
          mnBusinessNotifyAtPeriod = subscription.getPeriod();
        }
        else if (topic.equalsIgnoreCase("Hawaii")) {
          mnHawaiiSubscribe = "Yes";
          mnHawaiiNotifyBy = subscription.getMethod();
          mnHawaiiNotifyAtHour = subscription.getHour();
          mnHawaiiNotifyAtPeriod = subscription.getPeriod();
        }
        else if (topic.equalsIgnoreCase("Local")) {
          mnLocalSubscribe = "Yes";
          mnLocalNotifyBy = subscription.getMethod();
          mnLocalNotifyAtHour = subscription.getHour();
          mnLocalNotifyAtPeriod = subscription.getPeriod();
        }

      }
      else if (site.equals("Civil Beat")) {

        if (topic.equalsIgnoreCase("Popular")) {
          cbPopularSubscribe = "Yes";
          cbPopularNotifyBy = subscription.getMethod();
          cbPopularNotifyAtHour = subscription.getHour();
          cbPopularNotifyAtPeriod = subscription.getPeriod();
        }
        else if (topic.equalsIgnoreCase("Honolulu")) {
          cbHonoluluSubscribe = "Yes";
          cbHonoluluNotifyBy = subscription.getMethod();
          cbHonoluluNotifyAtHour = subscription.getHour();
          cbHonoluluNotifyAtPeriod = subscription.getPeriod();
        }
        else if (topic.equalsIgnoreCase("Hawaii")) {
          cbHawaiiSubscribe = "Yes";
          cbHawaiiNotifyBy = subscription.getMethod();
          cbHawaiiNotifyAtHour = subscription.getHour();
          cbHawaiiNotifyAtPeriod = subscription.getPeriod();
        }
        else if (topic.equalsIgnoreCase("Education")) {
          cbEducationSubscribe = "Yes";
          cbEducationNotifyBy = subscription.getMethod();
          cbEducationNotifyAtHour = subscription.getHour();
          cbEducationNotifyAtPeriod = subscription.getPeriod();
        }
        else if (topic.equalsIgnoreCase("Politics")) {
          cbPoliticsSubscribe = "Yes";
          cbPoliticsNotifyBy = subscription.getMethod();
          cbPoliticsNotifyAtHour = subscription.getHour();
          cbPoliticsNotifyAtPeriod = subscription.getPeriod();
        }
        else if (topic.equalsIgnoreCase("Energy")) {
          cbEnergyAndEnvironmentSubscribe = "Yes";
          cbEnergyAndEnvironmentNotifyBy = subscription.getMethod();
          cbEnergyAndEnvironmentNotifyAtHour = subscription.getHour();
          cbEnergyAndEnvironmentNotifyAtPeriod = subscription.getPeriod();
        }
        else if (topic.equalsIgnoreCase("Development")) {
          cbDevelopmentSubscribe = "Yes";
          cbDevelopmentNotifyBy = subscription.getMethod();
          cbDevelopmentNotifyAtHour = subscription.getHour();
          cbDevelopmentNotifyAtPeriod = subscription.getPeriod();
        }
      }
    }
  }

}
