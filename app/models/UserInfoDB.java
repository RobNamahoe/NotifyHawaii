package models;

import views.formdata.UserFormData;


/**
 * A helper class for managing registered users.
 */
public class UserInfoDB {

  /**
   * Adds a new user to the database from a UserFormData object.
   * @param data The form data of the new user.
   */
  public static void addUser(UserFormData data) {
    Carrier carrier = Carrier.find().where().eq("name", data.carrier).findUnique();
    UserInfo user = new UserInfo(data.firstName, data.lastName, data.telephone, data.email, carrier, data.password);

    // Make relationships bi-directional
    carrier.addUser(user);
    user.save();
  }

  /**
   * Adds a new user to the database from a User object.
   * @param user The user to add.
   */
  public static void addUser(UserInfo user) {
    user.save();
  }

  /**
   * Gets the user with the specified id.
   * @param id The id of the user to retrieve.
   * @return The user.
   */
  public static UserInfo getUser(long id) {

    UserInfo user = UserInfo.find().byId(id);
    if (user == null) {
      throw new RuntimeException("A user with that id does not exist in the database.");
    }
    return user;
  }

  /**
   * Gets the user with the specified email.
   * @param email The email of the user to get.
   * @return The user.
   */
  public static UserInfo getUser(String email) {
    UserInfo user = UserInfo.find().where().eq("email", email).findUnique();
    if (user == null) {
      //throw new RuntimeException("A user with that email does not exist in the database.");
    }
    return user;
  }

  /**
   * Deletes the user with the specified id.
   * @param id The ID of the users to remove from the database.
   */
  public static void deleteUser(long id) {
    UserInfo.find().byId(id).delete();
  }

  /**
   * Updates user information.
   * @param data The users new information.
   */
  public static void updateUser(UserFormData data) {
    UserInfo user = getUser(data.id);
    user.setFirstName(data.firstName);
    user.setLastName(data.lastName);
    user.setEmail(data.email);
    user.setTelephone(data.telephone);
    Carrier carrier = Carrier.find().where().eq("name", data.carrier).findUnique();
    user.setCarrier(carrier);

    // Make relationships bi-directional
    carrier.addUser(user);
    user.save();
  }

  /**
   * Checks if a user with the given email address exists in the system.
   * @param email The email.
   * @return True if the user with the given email exists.
   */
  public static Boolean isUser(String email) {
    UserInfo user = UserInfo.find().where().eq("email", email).findUnique();
    return (user != null);
  }

  /**
   * Returns true if email and password are valid credentials.
   * @param email The email.
   * @param password The password.
   * @return True if email is a valid user email and password is valid for that email.
   */
  public static boolean isValid(String email, String password) {
    return ((email != null)
        &&
        (password != null)
        &&
        isUser(email)
        &&
        getUser(email).getPassword().equals(password));
  }

}
