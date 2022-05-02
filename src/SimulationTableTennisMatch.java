/**
 * Creates simulated table tennis match.
 * Inherits from {@link TableTennisMatch}.
 */
public class SimulationTableTennisMatch extends TableTennisMatch {

    /**
     * Constructor for SimulatedTableTennisMatch calls super from table tennis match.
     * @param player1 first player for the match.
     * @param player2 second player for the match.
     */
    public SimulationTableTennisMatch(TableTennisPlayer player1, TableTennisPlayer player2) {
        super(player1, player2);
    }

    /**
     * Plays a simulated table tennis match.
     * Overrides {@link TableTennisMatch#playMatch()} **/
    @Override
    public TableTennisPlayer playMatch() {
        //Keep playing games until winner or 7 played.
        while (gameNumber <= Constants.MAX_GAMES_CAN_PLAY.gameConstants) {
            playGame();
            //If either player reaches 4 points. (not enough games left for other player to catch up.)
            if (player1Games == Constants.GAMES_TO_WIN.gameConstants) {
                System.out.println(player1.getFullName() + " Wins the match.");
                player1.setMatchesWon(player1.getMatchesWon() + 1);
                return player2;
            } else if (player2Games == Constants.GAMES_TO_WIN.gameConstants) {
                System.out.println(player2.getFullName() + " Wins the match.");
                player2.setMatchesWon(player2.getMatchesWon() + 1);
                return player1;
            } else {
                gameNumber++;
            }
        }
        return null;
    }

    /**
     * Plays a simulated table tennis game
     * Overrides {@link TableTennisMatch#playGame()}**/
    @Override
    public void playGame() {

        while (player2Points < Constants.POINTS_TO_WIN.gameConstants && player1Points < Constants.POINTS_TO_WIN.gameConstants) {
            playPoint();
            //If player 1 gets to 11 points and therefore 2 points ahead.(Otherwise would be deuce)
            if (player1Points == Constants.POINTS_TO_WIN.gameConstants) {
                player1Games += 1;
                player1.setGamesWon(player1.getGamesWon() + 1);
                break;
            }
            //If player 2 gets to 11 points and therefore 2 points ahead.(Otherwise would be deuce)
            else if (player2Points == Constants.POINTS_TO_WIN.gameConstants) {
                player2Games += 1;
                player2.setGamesWon(player2.getGamesWon() + 1);
                break;
            }
            //If deuce(draw at 10 points)
            else if (player1Points == Constants.DEUCE.gameConstants && player2Points == Constants.DEUCE.gameConstants) {
                playPoint();
                while (true) {
                    //If player 1 has advantage.
                    if (player1Points == player2Points + 1) {
                        playPoint();
                        //Player 1 is 2 points ahead so wins.
                        if (player1Points == player2Points + 2) {
                            player1Games += 1;
                            player1.setGamesWon(player1.getGamesWon() + 1);
                            break;
                        } else {
                            //IF 15 points reached then player 1 wins. (Stop infinite loop)
                            if (player1Points == Constants.MAX_POINTS_CAN_PLAY.gameConstants) {
                                player1Games += 1;
                                player1.setGamesWon(player1.getGamesWon() + 1);
                                break;
                            } else {
                                //Player 2 wins next point.
                                playPoint();
                                continue;
                            }
                        }
                    }
                    //If player 2 has advantage.
                    if (player2Points == player1Points + 1) {
                        playPoint();
                        //Player 2 is 2 points ahead so wins.
                        if (player2Points == player1Points + 2) {
                            player2Games += 1;
                            player2.setGamesWon(player2.getGamesWon() + 1);
                            break;
                        } else {
                            //IF 15 points reached then player 2 wins. (Stop infinite loop)
                            if (player2Points == Constants.MAX_POINTS_CAN_PLAY.gameConstants) {
                                player2Games += 1;
                                player2.setGamesWon(player2.getGamesWon() + 1);
                                break;
                            } else {
                                //Player 1 wins next point.
                                playPoint();
                            }
                        }
                    }
                }
            }
        }
        player1Points = 0;
        player2Points = 0;
        pointNumber = 0;
    }

    /**
     * Plays a simulated point.
     * Overrides {@link TableTennisMatch#playPoint()}
     */
    @Override
    public void playPoint() {
        //Play point.
        whoServes();
        if (SuccessfulServe(this.currentHit)) {
            while (true) {
                if (returnBall(this.currentHit)) {
                    returnBall(this.currentHit);
                } else {
                    break;
                }
            }
        }

        pointNumber++;

        //Add point to winner.
        if (lastHit.getPlayerID() == player1.getPlayerID()) {
            player1Points += 1;
            player1.setPointsWon(player1.getPointsWon() + 1);
        } else {
            player2Points += 1;
            player2.setPointsWon(player2.getPointsWon() + 1);
        }
    }
}