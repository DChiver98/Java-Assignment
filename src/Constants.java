/***
 * Enums for static game variables.
 */
public enum Constants {

    POINTS_TO_WIN(11),
    MAX_GAMES_CAN_PLAY(7),
    GAMES_TO_WIN(4),
    DEUCE(10),
    MAX_POINTS_CAN_PLAY(15);

    final int gameConstants;

    Constants(int gameconstants) {
        this.gameConstants = gameconstants;
    }

}
