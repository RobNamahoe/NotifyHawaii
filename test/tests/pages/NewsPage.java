package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;

/**
 * Provides testing support for the News services page.
 */
public class NewsPage extends FluentPage {

  private String url;

  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public NewsPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/news";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("News Services");
  }

  /**
   * Tests that subscriptions to News services can be edited.
   * @param subscribe The subscription value.
   * @param notifyBy The notification method.
   * @param notifyHour The notification hour.
   * @param notifyMinute the notification minute.
   */
  public void editContact(String subscribe, String notifyBy, String notifyHour, String notifyMinute) {

    // Honolulu Star Advertiser
    find("select", withId("hsaBreakingSubscribe")).find("option", withId(subscribe)).click();
    find("select", withId("hsaBreakingNotifyBy")).find("option", withId(notifyBy)).click();
    find("select", withId("hsaBreakingNotifyAtHour")).find("option", withId(notifyHour)).click();
    find("select", withId("hsaBreakingNotifyAtPeriod")).find("option", withId(notifyMinute)).click();

    // Maui News
    find("select", withId("mnBreakingSubscribe")).find("option", withId(subscribe)).click();
    find("select", withId("mnBreakingNotifyBy")).find("option", withId(notifyBy)).click();
    find("select", withId("mnBreakingNotifyAtHour")).find("option", withId(notifyHour)).click();
    find("select", withId("mnBreakingNotifyAtPeriod")).find("option", withId(notifyMinute)).click();

    // Civil Beat
    find("select", withId("cbPopularSubscribe")).find("option", withId(subscribe)).click();
    find("select", withId("cbPopularNotifyBy")).find("option", withId(notifyBy)).click();
    find("select", withId("cbPopularNotifyAtHour")).find("option", withId(notifyHour)).click();
    find("select", withId("cbPopularNotifyAtPeriod")).find("option", withId(notifyMinute)).click();

    //Submit the form whose id is "submit"
    submit("#submit");

  }

  /**
   * Ensures that subscription settings have been set.
   * @param subscribe The subscription value.
   * @param notifyBy The notification method.
   * @param notifyHour The notification hour.
   * @param notifyMinute The notification minute.
   */
  public void hasContent(String subscribe, String notifyBy, String notifyHour, String notifyMinute) {
    assertThat(pageSource().contains(subscribe));
    assertThat(pageSource().contains(notifyBy));
    assertThat(pageSource().contains(notifyHour));
    assertThat(pageSource().contains(notifyMinute));
  }



}
