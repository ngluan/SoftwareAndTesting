import models.Car;
import models.CarAd;
import models.User;
import org.junit.jupiter.api.Test;
import tools.Methods;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Testing {

    @Test
    public void Test_true_or_false(){
        boolean isFalse = true;
        assertFalse(isFalse);
    }

    @Test
    public void Testing_If_RentCar_function_returns_1_When_car_is_rented () {
        User user = new User(12, "Arne", 52);
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4);
        CarAd carAd = new CarAd(nissanLeaf, null, null, 20);
        assertEquals(1, carAd.rentCar(user));
    }
/*
    @Test
    public void Testing_if_Car_object_returns_in_json_format () {
        ArrayList<Car> cars = new ArrayList<>();
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4);
        System.out.println(nissanLeaf);
        cars.add(nissanLeaf);
         // assertEquals("model.Car{make='Nissan', modelYear=2018, model='Leaf', kmDistance=200000, registrationnumber='RJ3292', gearType='Manual', fuelType='Gas', seats=5, doors=4}", Methods.registerCar(cars));
    }
*/