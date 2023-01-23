import java.util.Arrays;

/**
 * A creature from the hit show/game, Pokémon!
 */
public class Pokemon implements Comparable<Pokemon> {

    // Copy your implementation from E2.1 here and continue by implementing the methods below.

    /**
     * An implementation of binary search with comparable Pokémon objects.
     * @param collection All the Pokémon you own.
     * @param name The name of the Pokémon to find in the collection.
     * @param level The level of the Pokémon to find in the collection.
     * @return The index of where the Pokémon resides in the collection.
     */
    public static int binarySearch(Pokemon[] collection, String name, int level) {
        return -1;
    }

    /**
     * Specifies a Pokémon to be taken from the collection and added to the team.
     * @param collection All the Pokémon you own.
     * @param team The (max) 6 Pokémon directly on you at any given time.
     * @param positionInTeam The place in the team this Pokémon will occupy.
     * @param name The name of the Pokémon to find in the collection.
     * @param level The level of the Pokémon to find in the collection.
     * @throws PokemonNotFoundException If the Pokémon cannot be found in the collection.
     */
    public static void addToTeam(Pokemon[] collection, Pokemon[] team, int positionInTeam, String name, int level) throws PokemonNotFoundException {
        // Before you can add to the team, you'll have to find the Pokémon in the collection first.
    }

}
