package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to manage cell phone carrier data.
 */
@Entity
public class Carrier extends Model {

  @Id
  private long id;

  private String name = "";
  private String gateway = "";

  // One of me (carrier) maps to many of the following (UserInfo)
  @OneToMany(mappedBy = "carrier")
  private List<UserInfo> users = new ArrayList<>();

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, Carrier> find() {
    return new Finder<Long, Carrier>(Long.class, Carrier.class);
  }

  /**
   * Creates a new Carrier instance with the given name and gateway values.
   * @param name The carriers name.
   * @param gateway The carriers gateway value.
   */
  public Carrier(String name, String gateway) {
    this.name = name;
    this.gateway = gateway;
  }

  /**
   * Gets the id.
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id.
   * @param id The id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the name.
   * @return The name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   * @param name The name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the gateway.
   * @return The gateway.
   */
  public String getGateway() {
    return gateway;
  }

  /**
   * Sets the gateway.
   * @param gateway The gateway.
   */
  public void setGateway(String gateway) {
    this.gateway = gateway;
  }

  /**
   * Gets a list of users with this carrier.
   * @return A list of users.
   */
  public List<UserInfo> getUsers() {
    return users;
  }

  /**
   * Sets the list of users with this carrier.
   * @param users The list of users.
   */
  public void setUsers(List<UserInfo> users) {
    this.users = users;
  }

  /**
   * Adds a user to the list of users.
   * @param user The user to add.
   */
  public void addUser(UserInfo user) {
    this.users.add(user);
  }

}
