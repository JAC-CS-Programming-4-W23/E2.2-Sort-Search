import java.util.Arrays;

/**
 * A creature from the hit show/game, Pokémon!
 */
public class Pokemon implements Comparable<Pokemon> {

    public enum Type {
        GRASS, WATER, FIRE, NONE
    }

    private final String name;
    private final int level;
    private final Type type;

    public Pokemon(String name, int level, Type type) {
        this.name = name;
        this.level = level;
        this.type = type;
    }

    public Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
        this.type = Type.NONE;
    }

    /**
     * Compares two Pokémon, first alphabetically, then by level.
     * @param rhs The Pokémon to be compared.
     * @return Negative if less than, zero if equal to, positive if greater than.
     */
    @Override
    public int compareTo(Pokemon rhs) {
        int comparison = this.name.compareTo(rhs.name);

        if (comparison == 0) {
            comparison = this.level - rhs.level;
        }

        return comparison;
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
        int positionInCollection = Pokemon.binarySearch(collection, name, level);

        if (positionInCollection < 0) {
            throw new PokemonNotFoundException(String.format("Level %d %s not found in collection.", level, name));
        }

        team[positionInTeam] = collection[positionInCollection];
    }

    /**
     * An implementation of binary search with comparable Pokémon objects.
     * @param collection All the Pokémon you own.
     * @param name The name of the Pokémon to find in the collection.
     * @param level The level of the Pokémon to find in the collection.
     * @return The index of where the Pokémon resides in the collection.
     */
    public static int binarySearch(Pokemon[] collection, String name, int level) {
        int low = 0;
        int high = collection.length - 1;
        int mid = (low + high) / 2;
        int result = -1;
        Pokemon pokemon = new Pokemon(name, level);

        while (low <= high) {
            if (collection[mid].compareTo(pokemon) < 0) { // The Pokémon is on the right side.
                low = mid + 1;
            }
            else if (collection[mid].compareTo(pokemon) == 0) { // The Pokémon was found!
                result = mid;
                break;
            }
            else { // The Pokémon is on the left side.
                high = mid - 1;
            }

            mid = (low + high) / 2;
        }

        if (low > high) {
            return -1;
        }

        return result;
    }

    public static int binarySearch(int[] array, int x) {
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) / 2;
        int result = -1;

        while (low <= high) {
            if (array[mid] < x) { // x is on the right side.
                low = mid + 1;
            }
            else if (array[mid] == x) {
                result = mid;
                break;
            }
            else { // x is on the left side.
                high = mid - 1;
            }

            mid = (low + high) / 2;
        }

        if (low > high) {
            return -1;
        }

        return result;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Type getType() {
        return type;
    }

}
