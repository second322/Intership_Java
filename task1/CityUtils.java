package ru.sbrf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityUtils {
    public static List<City> parse() {
        String path = "Path_file";

        List<City> cities = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(path))){
            while(scanner.hasNextLine()){
                cities.add(parse(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void print(List<City> cities) {
        cities.forEach(System.out::println);
    }
    private static City parse(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;
        if(scanner.hasNext()){
            foundation = scanner.next();
        }
        scanner.close();
        return new City(name,region,district,population,foundation);
    }}
