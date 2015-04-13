package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * A helper class to supply cell phone service providers.
 */
public class ServiceProviders {

  private static String[] carriers = {"AT&T Wireless",
                                      "Alltel Wireless",
                                      "AT&T Mobility (formerly Cingular)",
                                      "Boost Mobile",
                                      "Cricket",
                                      "Metro PCS",
                                      "Sprint (PCS)",
                                      "Sprint (Nextel)",
                                      "Straight Talk",
                                      "T-Mobile",
                                      "U.S. Cellular",
                                      "Verizon",
                                      "Virgin Mobile",
  };

  /**
   * Gets a map of the cell phone carriers initialized to false.
   * @return A map of service providers.
   */
  public static Map<String, Boolean> getCarriers() {
    Map<String, Boolean> carrierMap = new HashMap<String, Boolean>();
    for (String s : carriers) {
      carrierMap.put(s, false);
    }
    return carrierMap;
  }

  /**
   * Gets a map of the cell phone service carriers with the specified provider set to true.
   * @param carrier The provider to set to true.
   * @return A map of service providers.
   */
  public static Map<String, Boolean> getCarriers(String carrier) {
    Map<String, Boolean> carrierMap = getCarriers();
    if (isCarrier(carrier)) {
      carrierMap.put(carrier, true);
    }
    return carrierMap;
  }

  /**
   * Tests if the given provider is a valid cell phone service provider.
   * @param carrier The carrier to test.
   * @return True if valid.
   */
  public static boolean isCarrier(String carrier) {
    Map<String, Boolean> providerMap = getCarriers();
    return providerMap.containsKey(carrier);
  }


}
