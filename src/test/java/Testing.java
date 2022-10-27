import models.Car;
import models.CarAd;
import models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Testing {

    @Test
    public void Test_true_or_false(){
        boolean isFalse = false;
        assertFalse(isFalse);
    }

    @Test
    public void Testing_If_RentCar_function_returns_1_When_car_is_rented () {
        User user = new User(12, "Arne", 52);
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4);
        CarAd carAd = new CarAd(nissanLeaf, null, null, 20);
        assertEquals(1, carAd.rentCar(user));
    }
}
