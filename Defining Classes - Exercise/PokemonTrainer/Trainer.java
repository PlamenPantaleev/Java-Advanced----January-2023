package JavaAdvancedExercise.DefiningClasses.PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> listOfPokemon;

    public Trainer(String name, int numberOfBadges, List<Pokemon> listOfPokemon) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.listOfPokemon = listOfPokemon;
    }

    public boolean isPresent(String currentElement) {

        int counter = 0;
        for (int i = 0; i < listOfPokemon.size(); i++) {
            String element = listOfPokemon.get(i).getElement();
            if (element.equals(currentElement)) {
                counter++;
                numberOfBadges++;
                break;
            }
        }
        if (counter != 0) {
            return true;
        } else {
            for (int i = 0; i < listOfPokemon.size(); i++) {
                int newHealth = listOfPokemon.get(i).getHealth() - 10;
                listOfPokemon.get(i).setHealth(newHealth);
                if (listOfPokemon.get(i).getHealth() <= 0) {
                    listOfPokemon.remove(listOfPokemon.get(i));
                }
            }
            return false;
        }
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.listOfPokemon.size());
    }
}
