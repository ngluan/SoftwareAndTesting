import models.Car;
import models.CarAd;
import models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Testing {

    @Test
    public void Test_true_or_false() {
        boolean isFalse = true;
        assertTrue(isFalse);
    }

    @Test
    public void Car_can_not_get_rented_if_unavaible() {
        User user = new User(12, "Arne", 52);
        User user2 = new User(9, "Ronny", 25);
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user.getId());
        CarAd carAd = new CarAd(nissanLeaf, null, null, 0);
        carAd.rentCar(user.getId());
        assertEquals(false, carAd.rentCar(user2.getId()));
    }

    @Test
    public void Car_can_get_rented_if_avalaible() {
        User user = new User(12, "Arne", 52);
        User user2 = new User(9, "Ronny", 25);
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user.getId());
        CarAd carAd = new CarAd(nissanLeaf, null, null, 0);
        assertEquals(true, carAd.rentCar(user2.getId()));
    }

    @Test
    public void if_car_is_available() {
        User user = new User(12, "Arne", 52);
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user.getId());
        CarAd carAd = new CarAd(nissanLeaf, null, null, 0);
        carAd.rentCar(user.getId());
        assertEquals(12, carAd.getRenterId());
    }


    @Test
    public void Testing_if_Car_object_returns_in_json_format() {
        ArrayList<Car> cars = new ArrayList<>();
        User user = new User(12, "Arne", 52);
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user.getId());
        cars.add(nissanLeaf);
        assertEquals("model.Car{make='Nissan', modelYear=2018, model='Leaf', kmDistance=200000, registrationnumber='RJ3292', gearType='Manual', fuelType='Gas', seats=5, doors=4}", nissanLeaf.toString());
    }


}
