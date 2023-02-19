import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class PokemonTest {

    @Test
    void testPokemonWasCreatedSuccessfully() {
        String name = "Bulbasaur";
        int level = 10;
        Pokemon.Type type = Pokemon.Type.GRASS;
        Pokemon pokemon = new Pokemon(name, level, type);

        assertEquals(name, pokemon.getName());
        assertEquals(level, pokemon.getLevel());
        assertEquals(type, pokemon.getType());
    }

    @Test
    void testPokemonCanBeComparedTo() {
        Pokemon pokemon1 = new Pokemon("Bulbasaur", 10, Pokemon.Type.GRASS);
        Pokemon pokemon2 = new Pokemon("Bulbasaur", 10, Pokemon.Type.GRASS);
        Pokemon pokemon3 = new Pokemon("Bulbasaur", 11, Pokemon.Type.GRASS);
        Pokemon pokemon4 = new Pokemon("Charmander", 9, Pokemon.Type.FIRE);
        Pokemon pokemon5 = new Pokemon("Squirtle", 10, Pokemon.Type.WATER);

        assertTrue(pokemon1.compareTo(pokemon2) == 0);
        assertTrue(pokemon1.compareTo(pokemon3) < 0);
        assertTrue(pokemon3.compareTo(pokemon2) > 0);
        assertTrue(pokemon1.compareTo(pokemon4) < 0);
        assertTrue(pokemon5.compareTo(pokemon4) > 0);
    }

    @Test
    void testPokemonCanBeAddedToTeamFromCollection() throws PokemonNotFoundException {
        Pokemon[] collection = new Pokemon[3];
        Pokemon[] team = new Pokemon[6];

        collection[0] = new Pokemon("Bulbasaur", 11, Pokemon.Type.GRASS);
        collection[1] = new Pokemon("Charmander", 9, Pokemon.Type.FIRE);
        collection[2] = new Pokemon("Squirtle", 10, Pokemon.Type.WATER);

        Pokemon.addToTeam(collection, team, 0, "Charmander", 9);
        Pokemon.addToTeam(collection, team, 1, "Squirtle", 10);
        Pokemon.addToTeam(collection, team, 2, "Bulbasaur", 11);

        assertEquals(team[0], collection[1], "The first team member should be Charmander.");
        assertEquals(team[1], collection[2], "The second team member should be Squirtle.");
        assertEquals(team[2], collection[0], "The third team member should be Bulbasaur.");
    }

    @Test
    void testAddingNonExistentPokemonByNameThrowsException() {
        Pokemon[] collection = new Pokemon[1];
        Pokemon[] team = new Pokemon[6];

        collection[0] = new Pokemon("Bulbasaur", 10, Pokemon.Type.GRASS);

        Exception exception = assertThrows(PokemonNotFoundException.class, () -> Pokemon.addToTeam(collection, team, 0, "Foo", 10));

        assertEquals("Level 10 Foo not found in collection.", exception.getMessage());
    }

    @Test
    void testAddingNonExistentPokemonByLevelThrowsException() {
        Pokemon[] collection = new Pokemon[1];
        Pokemon[] team = new Pokemon[6];

        collection[0] = new Pokemon("Bulbasaur", 10, Pokemon.Type.GRASS);

        Exception exception = assertThrows(PokemonNotFoundException.class, () -> Pokemon.addToTeam(collection, team, 0, "Bulbasaur", 11));

        assertEquals("Level 11 Bulbasaur not found in collection.", exception.getMessage());
    }

    @Test
    void testNumberBinarySearch() {
        int[] numbers = new int[] { 1, 2, 3, 4, 5 };
        int position0 = Pokemon.binarySearch(numbers, 1);
        int position1 = Pokemon.binarySearch(numbers, 2);
        int position2 = Pokemon.binarySearch(numbers, 3);
        int position3 = Pokemon.binarySearch(numbers, 4);
        int position4 = Pokemon.binarySearch(numbers, 5);
        int position5 = Pokemon.binarySearch(numbers, 6);

        assertEquals(0, position0);
        assertEquals(1, position1);
        assertEquals(2, position2);
        assertEquals(3, position3);
        assertEquals(4, position4);
        assertEquals(-1, position5);
    }

    @Test
    void testPokemonCanBeBinarySearched() {
        Pokemon[] collection = new Pokemon[5];

        collection[0] = new Pokemon("Bulbasaur", 10, Pokemon.Type.GRASS);
        collection[1] = new Pokemon("Squirtle", 10, Pokemon.Type.WATER);
        collection[2] = new Pokemon("Bulbasaur", 11, Pokemon.Type.GRASS);
        collection[3] = new Pokemon("Charmander", 9, Pokemon.Type.FIRE);
        collection[4] = new Pokemon("Bulbasaur", 10, Pokemon.Type.GRASS);

        Arrays.sort(collection);

        int position0 = Pokemon.binarySearch(collection, "Bulbasaur", 10);
        int position1 = Pokemon.binarySearch(collection, "Bulbasaur", 10);
        int position2 = Pokemon.binarySearch(collection, "Bulbasaur", 11);
        int position3 = Pokemon.binarySearch(collection, "Charmander", 9);
        int position4 = Pokemon.binarySearch(collection, "Squirtle", 10);
        int position5 = Pokemon.binarySearch(collection, "Pikachu", 10);

        assertEquals(0, position0);
        assertEquals(0, position1);
        assertEquals(2, position2);
        assertEquals(3, position3);
        assertEquals(4, position4);
        assertEquals(-1, position5);
    }
}