import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Pokemon bulbasaur1 = new Pokemon("Bulbasaur", 10, Pokemon.Type.GRASS);
        Pokemon bulbasaur2 = new Pokemon("Bulbasaur", 15, Pokemon.Type.GRASS);
        Pokemon charmander = new Pokemon("Charmander", 98, Pokemon.Type.FIRE);
        Pokemon squirtle = new Pokemon("Squirtle", 95, Pokemon.Type.WATER);

        Pokemon[] collection = new Pokemon[4];

        collection[0] = bulbasaur1;
        collection[1] = bulbasaur2;
        collection[2] = charmander;
        collection[3] = squirtle;

        Arrays.sort(collection);

        Pokemon[] team = new Pokemon[6];

        try {
            Pokemon.addToTeam(collection, team, 0, "Bulbasaur", 10);
            Pokemon.addToTeam(collection, team, 1, "Bulbasaur", 10);
            Pokemon.addToTeam(collection, team, 2, "Bulbasaur", 15);
            Pokemon.addToTeam(collection, team, 3, "Charmander", 1000);
            Pokemon.addToTeam(collection, team, 4, "Foo", 10);
        }
        catch (PokemonNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(Arrays.toString(team));
    }

}
