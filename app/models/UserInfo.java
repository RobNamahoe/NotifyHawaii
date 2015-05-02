package models;

import play.db.ebean.Model;
import views.formdata.UserFormData;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Representation of users of the system.
 */
@Entity
public class UserInfo extends Model {

  @Id
  private long id;

  private String firstName;
  private String lastName;
  private String telephone;
  private String email;
  private String password;

  // Many of me (UserInfo) maps to one of the following (Carrier)
  @ManyToOne(cascade = CascadeType.PERSIST)
  private Carrier carrier;

  // Many of me (UserInfo) maps to many of the following (Subscription)
  @ManyToMany(cascade = CascadeType.PERSIST)
  private List<Subscription> subscriptions;


  /**
   * Creates a new user instance.
   * @param firstName The users first name.
   * @param lastName The users last name.
   * @param telephone The users telephone number.
   * @param email The users email address.
   * @param carrier The users cell telephone carrier.
   * @param password The users password.
   */
  public UserInfo(String firstName, String lastName, String telephone, String email, Carrier carrier, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.email = email;
    this.carrier = carrier;
    this.password = password;
  }

  /**
   * Creates a new user instance from a UserFormData object.
   * @param data A UserFormData object.
   */
  public UserInfo(UserFormData data) {
    this.firstName = data.firstName;
    this.lastName = data.lastName;
    this.telephone = data.telephone;
    this.email = data.email;
    this.carrier = Carrier.find().where().eq("name", data.carrier).findUnique();
    this.password = data.password;
  }


  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, UserInfo> find() {
    return new Finder<Long, UserInfo>(Long.class, UserInfo.class);
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
  public Carrier getCarrier() {
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
  public void setCarrier(Carrier carrier) {
    this.carrier = carrier;
  }

  /**
   * Gets the users password.
   * @return The password.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the users password.
   * @param password The password.
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Gets a list of the users current subscriptions.
   * @return A list of subscriptions.
   */
  public List<Subscription> getSubscriptions() {
    return subscriptions;
  }

  /**
   * Sets the list of the users current subscriptions.
   * @param subscriptions A list of the current subscriptions.
   */
  public void setSubscriptions(List<Subscription> subscriptions) {
    this.subscriptions = subscriptions;
  }

}
