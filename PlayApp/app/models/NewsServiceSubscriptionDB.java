package models;

import java.util.HashMap;
import java.util.Map;

/**
 * An in-memory repository for news services subscriptions.
 */
public class NewsServiceSubscriptionDB {

  private static Map<Long, NewsServicesSubscription> subscriptions = new HashMap<>();

  /**
   * Adds the subscription to the database.
   * @param id The user id.
   * @param subscription The subscription object.
   */
  public static void addSubscription(long id, NewsServicesSubscription subscription) {
    subscriptions.put(id, subscription);
  }


  /**
   * Gets the subscription object for the specified user.
   * @param id The id of the user.
   * @return The NewsServicesSubscription object for the specified user.
   */
  public static NewsServicesSubscription getSubscription(long id) {
    return subscriptions.get(id);
  }
}
