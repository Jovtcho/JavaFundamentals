package pokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        getTrainersAndPokemons(br, trainers);

        while (true) {
            String command = br.readLine().toLowerCase();
            if ("End".equalsIgnoreCase(command)) {
                break;
            }

            switch (command) {
                case "fire":
                    // for (String trainer : trainers.keySet()) {
                    //     List<Pokemon> currentTrainerPokemons = trainers.get(trainer).getPokemons();
                    //     boolean isPokemonHasElement = currentTrainerPokemons.stream()
                    //             .anyMatch(pokemon -> pokemon.getElement().equalsIgnoreCase(command));
                    //     if (isPokemonHasElement) {
                    //         int badgeCount = trainers.get(trainer).getBadgesCount();
                    //         trainers.get(trainer).setBadgesCount(++badgeCount);
                    //     }
                    // }

                    processTrainersAndPokemons(trainers, command);
                    break;
                case "water":
                    processTrainersAndPokemons(trainers, command);
                    break;
                case "electricity":
                    processTrainersAndPokemons(trainers, command);
                    break;
                default:
                    System.out.println("No such element.");
                    break;
            }
        }

        trainers.values().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getBadgesCount(),
                                                    t1.getBadgesCount()))
                .forEach(System.out::println);
    }

    private static void processTrainersAndPokemons(Map<String, Trainer> trainers, String command) {
        getBadge(trainers, command);
        reducePokemonHealth(trainers, command);
        removeDeathPokemons(trainers);
    }

    private static void removeDeathPokemons(Map<String, Trainer> trainers) {
        trainers.keySet()
                .forEach(t -> trainers.get(t).getPokemons().removeIf(p -> p.getHealth() <= 0));
    }

    private static void reducePokemonHealth(Map<String, Trainer> trainers, String command) {
        trainers.keySet().stream()
                .filter(key -> trainers.get(key).getPokemons().stream()
                        .noneMatch(p -> p.getElement().equalsIgnoreCase(command)))
                .forEach(t -> {
                    //List<Pokemon> pokemons =
                    trainers.get(t).getPokemons().forEach(Pokemon::reduceHealth);
                });
    }

    private static void getBadge(Map<String, Trainer> trainers, String command) {
        trainers.keySet().stream()
                .filter(key -> trainers.get(key).getPokemons().stream()
                        .anyMatch(p -> p.getElement().equalsIgnoreCase(command)))
                .forEach(t -> {
                    int badgeCount = trainers.get(t).getBadgesCount();
                    trainers.get(t).setBadgesCount(++badgeCount);
                });
    }

    private static void getTrainersAndPokemons(BufferedReader br, Map<String, Trainer> trainers) throws IOException {
        while (true) {
            String line = br.readLine();
            if ("Tournament".equalsIgnoreCase(line)) {
                break;
            }

            //Pesho Charizard Fire 100
            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.valueOf(tokens[3]);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.get(trainerName).getPokemons().add(pokemon);
        }
    }
}
