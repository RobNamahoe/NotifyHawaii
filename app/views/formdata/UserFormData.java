package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.User;
import play.data.validation.ValidationError;

/**
 * A class that stores data for the users account page/form.
 * @author Rob Namahoe
 */
public class UserFormData {

  /** The users id. */
  public long id;

  /** The users first name. */
  public String firstName;

  /** The users last name. */
  public String lastName;

  /** The users email address. */
  public String email;

  /** The users mobile telephone number. */
  public String telephone;

  /** The users mobile telephone service provider. */
  public String carrier;

  /**
   * Default Constructor method.
   */
  public UserFormData() {
    // Default constructor.
  }

  /**
   * Creates a new instance of a user initialized with the given values.
   * @param firstName The users first name.
   * @param lastName The users last name.
   * @param email The users email address.
   * @param telephone The users telephone number.
   * @param carrier The users cell telephone carrier.
   */
  public UserFormData(String firstName, String lastName, String email, String telephone, String carrier) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.telephone = telephone;
    this.carrier = carrier;
  }

  /**
   * Creates an instance of a user initialized with information from the given User object.
   * @param user The current user.
   */
  public UserFormData(User user) {
    this.id = user.getId();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.email = user.getEmail();
    this.telephone = user.getTelephone();
    this.carrier = user.getCarrier();
  }

  /**
   * Checks that form fields are valid. Called by bindFormRequest().
   * @return null if valid, a list of ValidationErrors if problems are found.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    // If both email and telephone number are blank, issue an error.
    if (email.length() == 0 && telephone.length() == 0) {
      errors.add(new ValidationError("email", "Email or telephone number is required."));
      errors.add(new ValidationError("telephone", "Email or telephone number is required."));
    }

    // Validate telephone number format.
    if (telephone.length() > 0) {
      if (!(telephone.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}") || telephone.matches("\\d{10}"))) {
        errors.add(new ValidationError("telephone", "Invalid telephone number format. Use ###-###-####"));
      }
      if (carrier == null || carrier.length() == 0) {
        errors.add(new ValidationError("carrier", "Service provider cannot be left blank."));
      }
    }

    return errors.isEmpty() ? null : errors;
  }
}
