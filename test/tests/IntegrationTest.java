package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;

import tests.pages.AccountPage;
import tests.pages.NewsPage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Runs a server with a fake in-memory database to test the system.
 */
public class IntegrationTest {

  /** The port to be used for testing. */
  private final int port = 3333;

  /**
   * Check to see that both the index and page1 tests.pages can be retrieved.
   */
  @Test
  public void test() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333");
        assertThat(browser.pageSource()).contains("Notify Hawaii");

        browser.goTo("http://localhost:3333/account");
        assertThat(browser.pageSource()).contains("Account");

        browser.goTo("http://localhost:3333/services");
        assertThat(browser.pageSource()).contains("Services");

        browser.goTo("http://localhost:3333/blogs");
        assertThat(browser.pageSource()).contains("Blog Services");

        browser.goTo("http://localhost:3333/commute");
        assertThat(browser.pageSource()).contains("Commute Services");

        browser.goTo("http://localhost:3333/news");
        assertThat(browser.pageSource()).contains("News Services");

      }
    });
  }


  /**
   * Checks that Contact information on the Account page can be updated successfully.
   */
  @Test
  public void testEditContactInformation() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {

        AccountPage accountPage = new AccountPage(browser.getDriver(), port);

        browser.goTo(accountPage);
        accountPage.isAt();

        String firstName = "Robert";
        String lastName = "Namahoe";
        String telephone = "808-111-2222";
        String email = "";
        String carrier = "Verizon";

        accountPage.editContact(firstName, lastName, email, telephone, carrier);

        browser.goTo(accountPage);
        accountPage.isAt();
        accountPage.hasContent(firstName, lastName, email, telephone, carrier);

      }
    });
  }

  /**
   * Checks that Contact information on the Account page can be updated successfully.
   */
  @Test
  public void testEditNewsSubscriptions() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {

        NewsPage newsPage = new NewsPage(browser.getDriver(), port);

        browser.goTo(newsPage);
        newsPage.isAt();

        String subscription = "Yes";
        String notifyBy = "Text";
        String notifyHour = "22";
        String notifyMinute = "45";

        newsPage.editContact(subscription, notifyBy, notifyHour, notifyMinute);

        browser.goTo(newsPage);
        newsPage.isAt();

        newsPage.hasContent(subscription, notifyBy, notifyHour, notifyMinute);

      }
    });
  }

}
