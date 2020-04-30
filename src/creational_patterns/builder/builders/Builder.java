package creational_patterns.builder.builders;

import creational_patterns.builder.cars.Type;
import creational_patterns.builder.components.Engine;
import creational_patterns.builder.components.GPSNavigator;
import creational_patterns.builder.components.Transmission;
import creational_patterns.builder.components.TripComputer;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setType(Type type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
