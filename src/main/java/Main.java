import com.fasterxml.jackson.databind.ObjectMapper;
import models.Car;
import tools.Methods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4);
        System.out.println(nissanLeaf);
        cars.add(nissanLeaf);
        cars.add(nissanLeaf);

        File JSONFil = new File("cars.json");

        //writeToJSON("cars.json", cars);

        ArrayList<Car> carReadFromFile = lesFraJSONFil(JSONFil);

        Methods.registerCar(cars);
        for (Car car : carReadFromFile) {
            System.out.println(car);
        }
    }

    public static void writeToJSON(String filename, List<Car> cars) {
        try {
            File file = new File(filename);
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Car> lesFraJSONFil(File fil) {
        ArrayList<Car> returnList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Car[] bilArray = objectMapper.readValue(fil, Car[].class);
            returnList.addAll(Arrays.asList(bilArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnList;
    }



}

