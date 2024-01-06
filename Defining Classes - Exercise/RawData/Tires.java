package JavaAdvancedExercise.DefiningClasses.RawData;

import java.util.List;

public class Tires {
    private List<Double> tires;

    public List<Double> getTires() {
        return tires;
    }

    public void setTires(List<Double> tires) {
        this.tires = tires;
    }

    public Tires(List<Double> tires) {
        this.tires = tires;
    }
}
