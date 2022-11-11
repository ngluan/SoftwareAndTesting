package tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Car;
import models.CarAd;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Methods {
    public static int userId;

    public static void registerCar(String make, int year, String model, String regnum){
        //create car object from parameters
        //read list of cars from JSON, add car to the list, write list to JSON
        //alternatively just add the element to the end of the JSON file
        Car newCar = new Car(make, year, model, 200000, regnum, "Manual", "Gas", 5, 4, userId);

        //List<Car> cars = readCarsFromJson();
        //cars.add(newCar);
        //writeCarsToJson("cars.json", cars);
    }

    public static void createCarAd(Car userCar, Date startDate, Date endDate){
        CarAd carad = new CarAd(userCar, startDate, endDate, 0);
    }
    public static void showCarAds(){
        // Method for showing all car ads in UI
        // List<Car> cars = readCarsFromJson()
        // Might move this to only MainGUI if this only changes GUI
    }
    public static void login(int userid) {

    }

    public static void deleteCarAd(){
        // method for deleting a car ad
    }

    public static void writeCarToJSON(String filename, List<Car> cars) {
        try {
            File file = new File(filename);
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Car> readCarsfromJSON(File fil) {
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
