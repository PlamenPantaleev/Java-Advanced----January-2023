package JavaAdvancedExercise.DefiningClasses.Google;

public class Parents {
    private String name;
    private String birthday;

    public Parents(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }
    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthday);
    }
}
