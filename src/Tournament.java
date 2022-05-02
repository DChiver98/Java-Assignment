/**
 * Interface for generic tournaments for all sports.
 */
public interface Tournament {

    /**
     * Sets up tournament.
     */
    void setUpTournament();

    /**
     * Plays tournament.
     * @throws InterruptedException
     */
    void playTournament() throws InterruptedException;

    /**
     * Displays tournament result.
     */
    void tournamentResults();

}
