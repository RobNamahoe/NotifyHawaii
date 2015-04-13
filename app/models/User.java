package models;

import views.formdata.UserFormData;

/**
 * Representation of users of the system.
 */
public class User {

  private long id;
  private String firstName;
  private String lastName;
  private String telephone;
  private String email;
  private String carrier;

  /**
   * Creates a new user instance.
   * @param id The users id.
   * @param firstName The users first name.
   * @param lastName The users last name.
   * @param telephone The users telephone number.
   * @param email The users email address.
   * @param carrier The users cell telephone carrier.
   */
  public User(long id, String firstName, String lastName, String telephone, String email, String carrier) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.email = email;
    this.carrier = carrier;
  }

  /**
   * Creates a new user instance from a UserFormData object.
   * @param data A UserFormData object.
   */
  public User(UserFormData data) {
    this.id = data.id;
    this.firstName = data.firstName;
    this.lastName = data.lastName;
    this.telephone = data.telephone;
    this.email = data.email;
    this.carrier = data.carrier;
  }


  /**
   * Gets the users id.
   * @return The users id.
   */
  public long getId() {
    return id;
  }

  /**
   * Gets the users first name.
   * @return The users first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets the users last name.
   * @return The users last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Gets the users telephone number.
   * @return The telephone number.
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * Gets the users email address.
   * @return The email address.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Gets the users cell telephone service provider.
   * @return The cell telephone carrier.
   */
  public String getCarrier() {
    return carrier;
  }

  /**
   * Sets the current users id value.
   * @param id The new id value.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Sets the users first name value.
   * @param firstName The users first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Sets the users last name value.
   * @param lastName The users last name.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Sets the users telephone number value.
   * @param telephone The users telephone number.
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  /**
   * Sets the users email address.
   * @param email The users email address.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Sets the users cell phone carrier.
   * @param carrier The users carrier.
   */
  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }
}
