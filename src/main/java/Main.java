import forms.MainGUI;

import models.Car;
import tools.Methods;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MainGUI mainGUI = new MainGUI("CarX");
        mainGUI.setVisible(true);
        mainGUI.setExtendedState(mainGUI.MAXIMIZED_BOTH);
        ArrayList<Car> cars = new ArrayList<>();
        int user = 1;
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4, user);
        System.out.println(nissanLeaf);
        cars.add(nissanLeaf);
        cars.add(nissanLeaf);

        File JSONFil = new File("cars.json");

        Methods.writeCarToJSON("cars.json", cars);

        ArrayList<Car> carReadFromFile = Methods.readCarsfromJSON(JSONFil);

        //Methods.registerCar(cars);
        for (Car car : carReadFromFile) {
            System.out.println(car);
        }
    }


}

