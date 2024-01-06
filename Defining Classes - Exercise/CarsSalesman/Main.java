package JavaAdvancedExercise.DefiningClasses.CarsSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();

        for (int i = 1; i <= numberOfEngines; i++) {
            String [] engineData = scanner.nextLine().split("\\s+");
            //сигурни въведени данни
            String engineModel = engineData[0];
            int enginePower = Integer.parseInt(engineData[1]);
            //избирателни данни
            int displacement = 0;
            String efficiency = null;

            if (engineData.length == 4) {
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
            } else if (engineData.length == 3) {
                if (Character.isDigit(engineData[2].charAt(0))) {
                    displacement = Integer.parseInt(engineData[2]);
                } else {
                    efficiency = engineData[2];
                }
            }

            Engine engine = new Engine(engineModel, enginePower, displacement, efficiency);
            engines.add(engine);

        }
        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfCars; i++) {
            //"{Model} {Engine} {Weight} {Color}",
            String [] carData = scanner.nextLine().split("\\s+");
            String carModel = carData[0];
            String engine = carData[1];
            int carWeight = 0;
            String color = null;

            if (carData.length == 4) {
                carWeight = Integer.parseInt(carData[2]);
                color = carData[3];
            } else if (carData.length == 3) {
                if (Character.isDigit(carData[2].charAt(0))) {
                    carWeight = Integer.parseInt(carData[2]);
                } else {
                    color = carData[2];
                }
            }

            Engine carEngine = null;
            for (Engine currEngine : engines) {
                String currModel = currEngine.getModel();
                if (engine.equals(currModel)) {
                    carEngine = currEngine;
                    break;
                }
            }

            Car car = new Car(carModel, carEngine, carWeight, color);
            System.out.println(car);
        }
    }
}
