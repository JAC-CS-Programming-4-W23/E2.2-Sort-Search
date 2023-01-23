/**
 * The unfortunate problem of missing Pokémon!
 */
public class PokemonNotFoundException extends Exception {
    public PokemonNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
