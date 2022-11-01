
import models.Car;
import models.CarAd;
import models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Testing {

    @Test
    public void Test_true_or_false() {
        boolean isFalse = true;
        assertTrue(isFalse);
    }

    @Test
    public void Testing_If_RentCar_function_returns_1_When_car_is_rented() {
        User user = new User(12, "Arne", 52);
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user);
        CarAd carAd = new CarAd(nissanLeaf, null, null, 0);
        assertEquals(1, carAd.rentCar(user));
    }



    @Test
    public void Testing_If_car_is_avalaible_when_not_rented(){
        User user = new User(12, "Arne", 52);
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user);
        CarAd carAd = new CarAd(nissanLeaf, null, null, 0);
        assertEquals(0, carAd.getRenterId());
    }

    /*
    @Test
    public void Testing_if_Car_object_returns_in_json_format() {
        ArrayList<Car> cars = new ArrayList<>();
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4);
        cars.add(nissanLeaf);
        assertEquals("model.Car{make='Nissan', modelYear=2018, model='Leaf', kmDistance=200000, registrationnumber='RJ3292', gearType='Manual', fuelType='Gas', seats=5, doors=4}", Methods.registerCar(cars));
    }
    */

}
