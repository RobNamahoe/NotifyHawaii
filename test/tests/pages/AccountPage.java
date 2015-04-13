package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;

/**
 * Provides testing support for the Account page.
 */
public class AccountPage extends FluentPage {

  private String url;

  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public AccountPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/account";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Account");
  }

  /**
   * Edit the current users contact information.
   * @param firstName The users first name.
   * @param lastName The users last name.
   * @param email The users email.
   * @param telephone The users telephone number.
   * @param carrier The users cellphone service provider.
   */
  public void editContact(String firstName, String lastName, String email, String telephone, String carrier) {

    // Fill the input field with id "firstName" with the passed firstName string.
    fill("#firstName").with(firstName);

    // Fill the input field with id "lastName" with the passed lastName string.
    fill("#lastName").with(lastName);

    // Fill the input field with id "email" with the passed email string.
    fill("#email").with(email);

    // Fill the input field with id "telephone" with the passed telephone string.
    fill("#telephone").with(telephone);

    // Fill the input field with id "carrier" with the passed carrier string.
    find("select", withId("carrier")).find("option", withId(carrier)).click();

    //Submit the form whose id is "submit"
    submit("#submit");

  }

  /**
   * Checks that the contact information has been updated.
   * @param firstName The users first name.
   * @param lastName The users last name.
   * @param email The users email address.
   * @param telephone The users telephone number.
   * @param carrier The users cell phone service provider.
   */
  public void hasContent(String firstName, String lastName, String email, String telephone, String carrier) {
    assertThat(pageSource().contains(firstName));
    assertThat(pageSource().contains(lastName));
    assertThat(pageSource().contains(telephone));
    assertThat(pageSource().contains(email));
    assertThat(pageSource().contains(carrier));
  }
}
