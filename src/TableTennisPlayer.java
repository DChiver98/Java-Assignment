/**
 * Class to create table tennis players
 * Please see {@link SportsPlayer} for superclass.
 **/
public class TableTennisPlayer extends SportsPlayer {

    private final int playerID;
    private final int servePower;
    private final int serveSkill;
    private final int forehandPower;
    private final int forehandSkill;
    private final int backhandPower;
    private final int backhandSkill;
    private int pointsWon;
    private int gamesWon;
    private int MatchesWon;

    /**
     * Constructor for player object
     * @param playerID the players unique ID.
     * @param firstName the players first name.
     * @param lastName the players last name.
     * @param age the players age.
     * @param gender the players gender.
     * @param servePower the players serving power out of 10.
     * @param serveSkill the players serving skill out of 10.
     * @param forehandPower the players forehand power out of 10.
     * @param forehandSkill the players forehand skill out of 10.
     * @param backhandPower the players backhand power out of 10.
     * @param backhandSkill the players backhand skill out of 10.
     * @param leftOrRightHanded is the player left-handed or right-handed.
     * */
    public TableTennisPlayer(int playerID, String firstName, String lastName, int age, String gender, int servePower, int serveSkill, int forehandPower, int forehandSkill, int backhandPower, int backhandSkill, String leftOrRightHanded) {
        super(firstName, lastName, age, gender, leftOrRightHanded);
        this.playerID = playerID;
        this.servePower = servePower;
        this.serveSkill = serveSkill;
        this.forehandPower = forehandPower;
        this.forehandSkill = forehandSkill;
        this.backhandPower = backhandPower;
        this.backhandSkill = backhandSkill;
    }

    /**
     * Get players unique ID.
     * @return players ID.
     */
    public int getPlayerID() {
        return playerID;
    }

    /**
     * Get percentage of how many times out of 100 the player has a successful serve.
     * @return Players serve Percentage.
     */
    public int getServePercentage() {
        return servePower * serveSkill;
    }

    /**
     * Get percentage of how many times out of 100 the player returns the ball with their forehand
     * @return Forehand percentage.
     */
    public int getForehandPercentage() {
        return forehandPower * forehandSkill;
    }

    /**
     * Get percentage of how many times out of 100 the player returns the ball with their backhand.
     * @return Backhand percentage.
     */
    public int getBackhandPercentage() {
        return backhandPower * backhandSkill;
    }

    /**
     * Get number of points the player has won in the tournament.
     * @return Points won in tournament.
     */
    public int getPointsWon() {
        return pointsWon;
    }

    /**
     * Set how many points the player has won in the tournament.
     * @param pointsWon Points won in tournament.
     */
    public void setPointsWon(int pointsWon) {
        this.pointsWon = pointsWon;
    }

    /**
     * Get number of games the player has won in the tournament.
     * @return Games won in the tournament.
     */
    public int getGamesWon() {
        return gamesWon;
    }

    /**
     * Set how many games the player has won in the tournament.
     * @param gamesWon Games won in tournament.
     */
    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    /**
     * Get number of matches the player has won in the tournament.
     * @return Matches won in tournament.
     */
    public int getMatchesWon() {
        return MatchesWon;
    }

    /**
     * Set how many matches the player has won in the tournament.
     * @param matchesWon Matches won in tournament.
     */
    public void setMatchesWon(int matchesWon) {
        MatchesWon = matchesWon;
    }

}