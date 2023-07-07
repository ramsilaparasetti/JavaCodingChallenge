//
//Create a Car class that contains company, model and year of manufacturing.
//        Create a getTotalCarsByCompany() method that takes list as a parameter.
//        The method should return Map<String,Integer> whereby the key is the company and the value is the total number of cars per company

import java.util.*;

public class Cars {
    String company;
    String carModel;
    int year;

    public Cars(String company, String carModel, int year) {
        this.company = company;
        this.carModel = carModel;
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getManufacturingYear() {
        return year;
    }

    public static Map<String, Integer> getTotalCarsByCompany(List<Cars> cars) {
        Map<String, Integer> totalCars = new HashMap<>();
        for(Cars car: cars){
            if(totalCars.containsKey(car.getCompany())){
                totalCars.put(car.getCompany(), totalCars.get(car.getCompany())+1);
            }
            else {
                totalCars.put(car.getCompany(), 1);
            }
        }
        return totalCars;
    }

    public static void main(String[] args) {
        List<Cars> inputCarInfo = new ArrayList<>();
        inputCarInfo.add(new Cars("Toyota", "Camry", 2018));
        inputCarInfo.add(new Cars("Toyota", "Corolla", 2020));
        inputCarInfo.add(new Cars("Toyota", "Civic", 2019));
        inputCarInfo.add(new Cars("Honda", "Accord", 2021));
        inputCarInfo.add(new Cars("Toyota", "Mustang", 2017));
        inputCarInfo.add(new Cars("Ford", "Explorer", 2019));


        Map<String, Integer> resultCars = getTotalCarsByCompany(inputCarInfo);
        for (Map.Entry<String, Integer> entry : resultCars.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}


