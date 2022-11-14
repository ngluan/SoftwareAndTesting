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

    public static final File carsJSON = new File("cars.json");
    public static final File adsJSON = new File("ads.json");

    public static void login(int id) {
        userId = id;
    }

    public static void registerCar(String make, int year, String model, String regnum){
        Car newCar = new Car(make, year, model, 200000, regnum, "Manual", "Gas", 5, 4, userId);
        ArrayList<Car> cars = readCarsFromJSON(carsJSON);
        cars.add(newCar);
        writeCarsToJSON(carsJSON, cars);
    }
    public static void deleteCar(String regnum)
    {
        ArrayList<Car> cars = readCarsFromJSON(carsJSON);
        //find car with regnum and remove it from list
        writeCarsToJSON(carsJSON, cars);
    }

    public static void createCarAd(String carRegnum, Date startDate, Date endDate){
        CarAd newAd = new CarAd(carRegnum, startDate, endDate, 0);
        ArrayList<CarAd> carAds = readAdsFromJSON(adsJSON);
        carAds.add(newAd);
        writeAdsToJSON(adsJSON, carAds);
    }
    public static void showCarAds(){
        // Method for showing all car ads in UI
        // List<Car> cars = readCarsFromJson()
        // Might move this to only MainGUI if this only changes GUI
    }
    public static void deleteCarAd(){
        ArrayList<CarAd> carAds = readAdsFromJSON(adsJSON);
        //find ad with adId and remove it from list
        writeAdsToJSON(adsJSON, carAds);
    }

    // File Handling
    public static void writeCarsToJSON(File file, List<Car> cars) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Car> readCarsFromJSON(File fil) {
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

    public static void writeAdsToJSON(File file, List<CarAd> ads) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, ads);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<CarAd> readAdsFromJSON(File fil) {
        ArrayList<CarAd> returnList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CarAd[] adArray = objectMapper.readValue(fil, CarAd[].class);
            returnList.addAll(Arrays.asList(adArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnList;
    }
}
