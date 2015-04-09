package models;

import views.formdata.UserFormData;

import java.util.HashMap;
import java.util.Map;

/**
 * An in-memory repository for storing registered application users.
 */
public class UserDB {

  private static long currentId = 1;
  private static Map<Long, User> users = new HashMap<>();

  /**
   * Adds a new user to the database from a UserFormData object.
   * @param data The form data of the new user.
   */
  public static void addUser(UserFormData data) {
    long id = (data.id == 0) ? currentId++ : data.id;
    users.put(id, new User(data));
  }

  /**
   * Adds a new user to the database from a User object.
   * @param user The user to add.
   */
  public static void addUser(User user) {
    users.put(user.getId(), user);
  }



  /**
   * Gets the user with the specified id.
   * @param id The id of the user to retrieve.
   * @return The user.
   */
  public static User getUser(long id) {
    User user = users.get(id);
    if (user == null) {
      throw new RuntimeException("A user with that id cannot be found.");
    }
    return user;
  }

  /**
   * Deletes the user with the specified id.
   * @param id The ID of the users to remove from the database.
   */
  public static void deleteUser(long id) {
    users.remove(id);
  }

  /**
   * Updates user information.
   * @param data The users new information.
   */
  public static void updateUser(UserFormData data) {
    User user = getUser(data.id);
    user.setFirstName(data.firstName);
    user.setLastName(data.lastName);
    user.setEmail(data.email);
    user.setTelephone(data.telephone);
    user.setCarrier(data.carrier);
  }


}
