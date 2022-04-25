public class SimulationTableTennisMatch extends TableTennisMatch {

    public SimulationTableTennisMatch(TableTennisPlayer player1, TableTennisPlayer player2) {
        super(player1, player2);
    }

    public TableTennisPlayer playMatch() {
        System.out.println("\n" + player1.getFullName() + " VS " + player2.getFullName());
        gameNumber = 1;
        while (gameNumber <= 7) {
            playGame();
            if (player1Games == 4) {
                System.out.println(player1.getFullName() + " Wins the match.");
                player1.setMatchesWon(player1.getMatchesWon() + 1);
                return player2;
            } else if (player2Games == 4) {
                System.out.println(player2.getFullName() + " Wins the match.");
                player2.setMatchesWon(player2.getMatchesWon() + 1);
                return player1;
            } else {
                gameNumber++;
            }
        }
        return null;
    }

    public void playGame() {

        while (player2Points < 11 && player1Points < 11) {
            playPoint();
            //If player 1 gets to 11 points.
            if (player1Points == 11) {
                player1Games += 1;
                player1.setGamesWon(player1.getGamesWon() + 1);
                break;
            }
            //If player 2 gets to 11 points.
            else if (player2Points == 11) {
                player2Games += 1;
                player2.setGamesWon(player2.getGamesWon() + 1);
                break;
            }
            //If deuce(draw at 10 points)
            else if (player1Points == 10 && player2Points == 10) {
                playPoint();
                while (true) {
                    //If player 1 has advantage.
                    if (player1Points == player2Points + 1) {
                        playPoint();
                        if (player1Points == player2Points + 2) {
                            player1Games += 1;
                            player1.setGamesWon(player1.getGamesWon() + 1);
                            break;
                        } else {
                            if (player1Points == 15) {
                                player1Games += 1;
                                player1.setGamesWon(player1.getGamesWon() + 1);
                                break;
                            } else {
                                playPoint();
                                continue;
                            }
                        }
                    }
                    //If player 2 has advantage.
                    if (player2Points == player1Points + 1) {
                        playPoint();
                        if (player2Points == player1Points + 2) {
                            player2Games += 1;
                            player2.setGamesWon(player2.getGamesWon() + 1);
                            break;
                        } else {
                            if (player2Points == 15) {
                                player2Games += 1;
                                player2.setGamesWon(player2.getGamesWon() + 1);
                                break;
                            } else {
                                playPoint();
                            }
                        }
                    }
                }
            }
        }
        player1Points = 0;
        player2Points = 0;
    }

    public void playPoint() {

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
        if (lastHit.getPlayerID() == player1.getPlayerID()) {
            player1Points += 1;
            player1.setPointsWon(player1.getPointsWon() + 1);
        } else {
            player2Points += 1;
            player2.setPointsWon(player2.getPointsWon() + 1);
        }
    }
}