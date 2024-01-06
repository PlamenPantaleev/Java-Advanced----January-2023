package JavaAdvancedExercise.DefiningClasses.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 1; i <= numberOfInputs; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            String carName = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Double> getTires = getTires(input);
            Tires tires = new Tires(getTires);
            Car car = new Car(carName, engine, cargo, tires);

            cars.add(car);
        }
        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            for (Car currentCar : cars) {
                String cargoType = currentCar.getCargo().getType();

                if (cargoType.equals("fragile")) {
                    for (int i = 0; i < currentCar.getTires().getTires().size(); i+= 2) {
                        double pressure = currentCar.getTires().getTires().get(i);
                        if (pressure < 1) {
                            System.out.println(currentCar.getModel());
                            break;
                        }
                    }
                }
            }
        } else if (command.equals("flamable")) {
            for (Car currentCar : cars) {
                String cargoType = currentCar.getCargo().getType();

                if (cargoType.equals("flamable")) {
                    if (currentCar.getEngineData().getPower() > 250) {
                        System.out.println(currentCar.getModel());
                    }
                }
            }
        }
    }

    private static List<Double> getTires(String[] input) {
        List<Double> tires = new ArrayList<>();

        for (int i = 5; i <input.length; i++) {
            tires.add(Double.parseDouble(input[i]));
        }
        return tires;
    }
}
