package views.formdata;

import models.UserInfoDB;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Registration form.
 */
public class RegistrationFormData {

  /** The new users email. **/
  public String regEmail = "";

  /** The new users first name. **/
  public String regFirstName = "";

  /** The new users last name. **/
  public String regLastName = "";

  /** The new users mobile phone number. **/
  public String regPhone = "";

  /** The new users mobile phone service provider. **/
  public String regCarrier = "";

  /** The new users password. **/
  public String regPassword = "";

  /**
   * Default constructor method.
   */
  public RegistrationFormData() {
  }

  /**
   * Validates Form<RegistrationFormData>.
   * Checks to see that name, email, and password are sufficiently supplied.
   * @return Null if invalid form, List if good input
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();

    if (regFirstName == null || regFirstName.equals("")) {
      errors.add(new ValidationError("regFirstName", "First Name is required."));
    }

    if (regLastName == null || regLastName.equals("")) {
      errors.add(new ValidationError("regLastName", "Last Name is required."));
    }

    if (regEmail == null || regEmail.equals("")) {
      errors.add(new ValidationError("regEmail", "An email address is required."));
    }
    else if (UserInfoDB.isUser(regEmail)) {
      // email exists
      errors.add(new ValidationError("regEmail", "An account with that email already exists."));
    }

    if (regPhone == null || regPhone.equals("")) {
      errors.add(new ValidationError("regEmail", "An email address is required."));
    }

    if (regPassword == null || regPassword.equals("")) {
      errors.add(new ValidationError("regPassword", "A password is required."));
    }

    if (regPhone.length() > 0) {
      if (!(regPhone.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}") || regPhone.matches("\\d{10}"))) {
        errors.add(new ValidationError("regPhone", "Invalid phone number format. Use ###-###-####"));
      }
      if (regCarrier == null || regCarrier.length() == 0) {
        errors.add(new ValidationError("regCarrier", "Mobile carrier cannot be left blank."));
      }
    }

    return (errors.size() > 0) ? errors : null;
  }

}
