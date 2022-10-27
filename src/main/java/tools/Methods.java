package tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Car;
import models.CarAd;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Methods {
    public static void registerCar(ArrayList<Car> cars){
        writeToJson("cars.json", cars);
    }

    public static void createCarAd(Car userCar, Date startDate, Date endDate){
        CarAd carad = new CarAd(userCar, startDate, endDate, 0);
    }
    public static void showCarAds(){

    }
    public static void login(int userid) {

    }

    public static void writeToJson(String filename, List<Car> cars) {
        try {
            File file = new File(filename);
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
