package JavaAdvancedExercise.DefiningClasses.RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engineData;
    private Cargo cargoData;
    private Tires tiresData;

    Car (String model, Engine engine, Cargo cargo, Tires tires) {
        this.model = model;
        this.engineData = engine;
        this.cargoData = cargo;
        this.tiresData = tires;
    }

    public Cargo getCargo() {
        return cargoData;
    }
    public Engine getEngineData() {
        return engineData;
    }
    public String getModel() {
        return model;
    }
    public Tires getTires() {
        return tiresData;
    }
}
