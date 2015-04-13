package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;

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

  /**
   * Check to see that both the index and page1 pages can be retrieved.
   */
  @Test
  public void test() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
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

}
