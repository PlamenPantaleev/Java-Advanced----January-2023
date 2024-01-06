package JavaAdvancedExercise.DefiningClasses.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double costForOneKM;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double costForOneKM) {
        //нов празен обект от класа Car;
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.costForOneKM = costForOneKM;
        this.distanceTraveled = 0;
    }

    public boolean drive(int Kms) {
        //1. нужното количество за да преминем KMs;
        double fuelNeeded = Kms * costForOneKM;

        if (fuelNeeded <= fuelAmount) {
            //може да изминем разстоянието
            this.fuelAmount = fuelAmount - fuelNeeded;
            this.distanceTraveled = distanceTraveled + Kms;
            return true;
        } else {
            //не можем да изминем разстоянието
            return false;
        }

    }
    @ Override
    public String toString() {
       return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
