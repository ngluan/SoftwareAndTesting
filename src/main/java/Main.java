import models.Car;
import tools.Methods;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4);
        System.out.println(nissanLeaf);
        cars.add(nissanLeaf);

        Methods.registerCar(cars);
    }





}

