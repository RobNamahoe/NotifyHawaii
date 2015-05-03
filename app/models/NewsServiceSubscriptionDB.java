package models;


import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;
import views.formdata.NewsServicesFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A helper class to manage news services subscriptions.
 */
public class NewsServiceSubscriptionDB {

  /**
   * Gets the subscription object for the specified user.
   * @param id The id of the user.
   * @return The NewsServicesSubscription object for the specified user.
   */
  public static NewsServicesSubscription getSubscription(long id) {
    NewsServicesSubscription subscription = NewsServicesSubscription.find().byId(id);
    return subscription;
  }

  /**
   * Gets the list of news subscriptions for the current user.
   * @param userEmail The email of the user.
   * @return A list of the users subscriptions.
   */
  public static List<NewsServicesSubscription> getSubscriptions(String userEmail) {
    UserInfo user = UserInfoDB.getUser(userEmail);
    Query<NewsServicesSubscription> query = Ebean.createQuery(NewsServicesSubscription.class);
    query.where().eq("user", user);
    return query.findList();
  }


  /**
   * Gets a list of users that currently hold a subscription.
   * @return A list of users that currently hold a subscription.
   */
  public static List<UserInfo> getSubscriptionHolders() {
    List<NewsServicesSubscription> subscriptions = NewsServicesSubscription.find().all();
    Map<String, UserInfo> users = new HashMap<>();
    for (NewsServicesSubscription subscription : subscriptions) {
      UserInfo user = subscription.getUser();
      if (!users.containsKey(user.getEmail())) {
        users.put(user.getEmail(), user);
      }
    }
    return new ArrayList<>(users.values());
  }

  /**
   * Update the Subscription table with the current users new News subscriptions.
   * @param userEmail The user to update.
   * @param data The form data containing the new News Subscription data.
   */
  public static void updateUserSubscription(String userEmail, NewsServicesFormData data) {

    UserInfo user = UserInfoDB.getUser(userEmail);

    Query<NewsServicesSubscription> query = Ebean.createQuery(NewsServicesSubscription.class);
    query.where().eq("user", user);

    for (NewsServicesSubscription subscription : query.findList()) {
      subscription.delete();
    }

    String site = "Honolulu Star Advertiser";
    NewsServicesSubscription subscription;

    // Breaking
    if (data.hsaBreakingSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Breaking", data.hsaBreakingNotifyBy,
                          data.hsaBreakingNotifyAtHour, data.hsaBreakingNotifyAtPeriod);
      subscription.save();
    }

    // Popular
    if (data.hsaPopularSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Popular", data.hsaPopularNotifyBy,
                          data.hsaPopularNotifyAtHour, data.hsaPopularNotifyAtPeriod);
      subscription.save();
    }

    // Sports
    if (data.hsaSportsSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Sports", data.hsaSportsNotifyBy,
                          data.hsaSportsNotifyAtHour, data.hsaSportsNotifyAtPeriod);
      subscription.save();
    }

    site = "Maui News";

    if (data.mnBreakingSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Breaking", data.mnBreakingNotifyBy,
          data.mnBreakingNotifyAtHour, data.mnBreakingNotifyAtPeriod);
      subscription.save();
    }

    if (data.mnBusinessSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Business", data.mnBusinessNotifyBy,
          data.mnBusinessNotifyAtHour, data.mnBusinessNotifyAtPeriod);
      subscription.save();
    }

    if (data.mnHawaiiSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Hawaii", data.mnHawaiiNotifyBy,
          data.mnHawaiiNotifyAtHour, data.mnHawaiiNotifyAtPeriod);
      subscription.save();
    }

    if (data.mnLocalSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Local", data.mnLocalNotifyBy,
          data.mnLocalNotifyAtHour, data.mnLocalNotifyAtPeriod);
      subscription.save();
    }


    site = "Civil Beat";

    if (data.cbPopularSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Popular", data.cbPopularNotifyBy,
          data.cbPopularNotifyAtHour, data.cbPopularNotifyAtPeriod);
      subscription.save();
    }

    if (data.cbHonoluluSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Honolulu", data.cbHonoluluNotifyBy,
          data.cbHonoluluNotifyAtHour, data.cbHonoluluNotifyAtPeriod);
      subscription.save();
    }

    if (data.cbHawaiiSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Hawaii", data.cbHawaiiNotifyBy,
          data.cbHawaiiNotifyAtHour, data.cbHawaiiNotifyAtPeriod);
      subscription.save();
    }

    if (data.cbEducationSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Education", data.cbEducationNotifyBy,
          data.cbEducationNotifyAtHour, data.cbEducationNotifyAtPeriod);
      subscription.save();
    }

    if (data.cbPoliticsSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Politics", data.cbPoliticsNotifyBy,
          data.cbPoliticsNotifyAtHour, data.cbPoliticsNotifyAtPeriod);
      subscription.save();
    }

    if (data.cbEnergyAndEnvironmentSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Energy", data.cbEnergyAndEnvironmentNotifyBy,
          data.cbEnergyAndEnvironmentNotifyAtHour, data.cbEnergyAndEnvironmentNotifyAtPeriod);
      subscription.save();
    }

    if (data.cbDevelopmentSubscribe.equals("Yes")) {
      subscription = new NewsServicesSubscription(user, site, "Development", data.cbDevelopmentNotifyBy,
          data.cbDevelopmentNotifyAtHour, data.cbDevelopmentNotifyAtPeriod);
      subscription.save();
    }

  }


}
