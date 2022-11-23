import models.Car;
import models.CarAd;
import models.User;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tools.Methods;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Testing {

    @Test
    public void Test_true_or_false() {
        boolean isFalse = true;
        assertTrue(isFalse);
    }

    @Nested
    class CarTest {

        @Nested
        class CarRenting {

            @Test
            public void Car_can_not_get_rented_if_unavaible() {
                User user = new User(12, "Arne", 52);
                User user2 = new User(9, "Ronny", 25);
                Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user.getId());
                CarAd carAd = new CarAd(nissanLeaf.getRegistrationnumber(), null, null, 0);
                carAd.rentCar(user.getId());
                assertEquals(false, carAd.rentCar(user2.getId()));
            }

            @Test
            public void Car_can_get_rented_if_avalaible() {
                User user = new User(12, "Arne", 52);
                User user2 = new User(9, "Ronny", 25);
                Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user.getId());
                CarAd carAd = new CarAd(nissanLeaf.getRegistrationnumber(), null, null, 0);
                assertEquals(true, carAd.rentCar(user2.getId()));
            }

            @Test
            public void Car_cant_get_rented_twice() {
                User user = new User(12, "Arne", 52);
                User user2 = new User(9, "Ronny", 25);
                Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user.getId());
                CarAd carAd = new CarAd(nissanLeaf.getRegistrationnumber(), null, null, 0);
                carAd.rentCar(user2.getId());
                assertEquals(false, carAd.rentCar(user2.getId()));
            }

        }

        @Test
        public void if_car_is_available() {
            User user = new User(12, "Arne", 52);
            Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user.getId());
            CarAd carAd = new CarAd(nissanLeaf.getRegistrationnumber(), null, null, 0);
            carAd.rentCar(user.getId());
            assertEquals(12, carAd.getRenterId());
        }

        @Test
        public void Car_can_get_registered() {
            File carsJSON = new File("carsTesting.json");
            ArrayList<Car> emptyList = new ArrayList<>();
            Methods.writeCarsToJSON(emptyList, carsJSON); // Overwrite JSON test file
            User user = new User(0, "Arne", 52);
            Methods.registerCar("bmw", 2018, "sykt", "AB02938", carsJSON);
            assertEquals("[model.Car{make='bmw', modelYear=2018, model='sykt', kmDistance=200000, registrationnumber='AB02938', gearType='Manual', fuelType='Gas', seats=5, doors=4, user=1}]", Methods.readCarsFromJSON(carsJSON).toString());
        }
    }


    @Nested
    class JSON_File_Handling_With_Car_Object{

        @Test
        public void Car_Object_Returns_In_JSON_Format() {
            ArrayList<Car> cars = new ArrayList<>();
            User user = new User(12, "Arne", 52);
            Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user.getId());
            cars.add(nissanLeaf);
            assertEquals("model.Car{make='Nissan', modelYear=2018, model='Leaf', kmDistance=200000, registrationnumber='RJ3292', gearType='Manual', fuelType='Gas', seats=5, doors=4, user=12}", nissanLeaf.toString());
        }

        @Test
        public void Car_Gets_deleted_From_JSON_File() {
            ArrayList<Car> cars = new ArrayList<>();
            User user = new User(12, "Arne", 52);
            Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user.getId());
            cars.add(nissanLeaf);
            File carsJSON = new File("carsTesting.json");
            Methods.writeCarsToJSON(cars, carsJSON);
            Methods.deleteCar("RJ3292", carsJSON);
            ArrayList<Car> emptyList = new ArrayList<Car>();
            assertEquals(emptyList, Methods.readCarsFromJSON(carsJSON));
        }

        @Test
        public void Car_Gets_added_to_JSON() {
            File carsJSON = new File("carsTesting.json");
            ArrayList<Car> cars = new ArrayList<>();
            Methods.writeCarsToJSON(cars); // Overwrite JSON test file
            User user = new User(12, "Arne", 52);
            Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user.getId());
            cars.add(nissanLeaf);
            Methods.writeCarsToJSON(cars, carsJSON);
            assertEquals(cars.toString(), Methods.readCarsFromJSON(carsJSON).toString());
        }


        @Test
        public void CarAd_Gets_Deleted_From_JSON_File() {
            File carAdJSON = new File("carAdTesting.json");
            ArrayList<Car> cars = new ArrayList<>();
            Methods.writeCarsToJSON(cars, carAdJSON); // Overwrite JSON test file
            User user = new User(0, "Arne", 52);
            Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user.getId());
            cars.add(nissanLeaf);
            CarAd carAd = Methods.createCarAd(nissanLeaf.getRegistrationnumber(), null, null, carAdJSON);
            Methods.deleteCarAd(carAd.getAdId(), carAdJSON);
            ArrayList<CarAd> emptyList = new ArrayList<>();
            assertEquals(emptyList, Methods.readAdsFromJSON(carAdJSON));
        }

        @Test
        public void Write_To_JSON_File_Returns_Error_if_Wrong_file () {
            File carsJSON = new File("carsTesting.json");
            ArrayList<Car> cars = new ArrayList<>();
            Methods.writeCarsToJSON(cars, carsJSON); // Overwrite JSON test file


        }

        @Test
        public void Read_from_JSON_returns_IOException_when_input_wrong() {
            File carsJSON = new File("carsTesting12.json");
            ArrayList<Car> cars = new ArrayList<>();
            try  {
                Methods.readCarsFromJSON(carsJSON);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void User_login() {
        int sessionId = 1;
        Methods.login(sessionId);
        assertEquals(sessionId, Methods.userId);
    }


    // Make test for exeptions in Methods


}
