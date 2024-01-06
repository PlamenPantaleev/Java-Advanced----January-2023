package JavaAdvancedExercise.DefiningClasses.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, List<Pokemon>>  trainersData = new LinkedHashMap<>();

        while (!command.equals("Tournament")) {
            //"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"
            String [] data = command.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (!trainersData.containsKey(trainerName)) {
                trainersData.put(trainerName, new ArrayList<>());
                trainersData.get(trainerName).add(pokemon);
            } else {
                trainersData.get(trainerName).add(pokemon);
            }

            command = scanner.nextLine();
        }
        List<Trainer> trainers = new ArrayList<>();

       for (Map.Entry<String, List<Pokemon>> entry : trainersData.entrySet()) {
           List<Pokemon> pokemons = new ArrayList<>(entry.getValue());
           Trainer trainer = new Trainer(entry.getKey(),  0, pokemons);
           trainers.add(trainer);
       }
        command = scanner.nextLine();

       while (!command.equals("End")) {
           switch (command) {
               case "Fire":
               case "Electricity":
               case "Water":
                   for (Trainer trainer : trainers) {
                       trainer.isPresent(command);
                   }
           }
           command = scanner.nextLine();
       }

        trainers.stream()
                .sorted(Comparator.comparingInt(Trainer::getNumberOfBadges).reversed())
                .forEach(trainer -> System.out.println(trainer));
    }
}
