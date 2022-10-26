package model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> biler = new ArrayList<>();
        Car nissanLeaf = new Car("Nissan", 2018, "Leaf", 200000, "RJ3292", "Manual", "Gas", 5, 4);
        System.out.println(nissanLeaf);
        biler.add(nissanLeaf);

        skrivTilJson("biler.json", biler);

    }

        public static void skrivTilJson(String filnavn, ArrayList<Car> biler) {
            try {
                File file = new File(filnavn);
                ObjectMapper objectMapper = new ObjectMapper();

                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, biler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

