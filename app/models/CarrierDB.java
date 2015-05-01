package models;

import java.util.List;

/**
 * A helper class for managing carriers.
 */
public class CarrierDB {

  /**
   * Adds a new carrier to the database.
   * @param name The name of the new carrier.
   * @param gateway The gateway value of the new carrier.
   */
  public static void addCarrier(String name, String gateway) {
    Carrier carrier = new Carrier(name, gateway);
    carrier.save();
  }

  /**
   * Adds the current carrier to the database.
   * @param carrier The carrier to add to the database.
   */
  public static void addCarrier(Carrier carrier) {
    carrier.save();
  }

  /**
   * Gets the carrier with the given id value.
   * @param id The id of the carrier to retrieve.
   * @return The carrier with the specified id.
   */
  public static Carrier getCarrier(long id) {
    Carrier carrier = Carrier.find().byId(id);
    if (carrier == null) {
      throw new RuntimeException("A carrier with that id does not exist in the database.");
    }
    return carrier;
  }

  /**
   * Gets the carrier with the specified name.
   * @param name The name of the carrier to retrieve.
   * @return The carrier.
   */
  public static Carrier getCarrier(String name) {
    Carrier carrier = Carrier.find().where().eq("name", name).findUnique();
    if (carrier == null) {
      throw new RuntimeException("A carrier with that name does not exist in the database.");
    }
    return carrier;
  }

  /**
   * Gets a list of all carriers in the database.
   * @return A list of all carriers in the database.
   */
  public static List<Carrier> getCarriers() {
    return Carrier.find().all();
  }

  /**
   * Deletes the carrier with the specified id from the database.
   * @param id The id of the carrier to delete from the database.
   */
  public static void deleteCarrier(long id) {
    Carrier carrier = Carrier.find().byId(id);
    if (carrier == null) {
      throw new RuntimeException("A carrier with that id does not exist in the database.");
    }
    carrier.delete();
  }

  /**
   * Checks if the carrier with the specified name exists in the database.
   * @param name The name of the carrier.
   * @return True if the carrier exists.
   */
  public static boolean carrierExists(String name) {
    Carrier carrier = Carrier.find().where().eq("name", name).findUnique();
    return (carrier != null);
  }

  /**
   * Counts the number of carriers in the database.
   * @return The number of carriers in the database.
   */
  public static int getCount() {
    return Carrier.find().all().size();
  }



}
