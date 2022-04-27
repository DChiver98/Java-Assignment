import java.util.Random;

public class TableTennisMatch {

    protected TableTennisPlayer player1;
    protected TableTennisPlayer player2;
    protected int player1Points;
    protected int player2Points;
    protected TableTennisPlayer currentHit;
    protected TableTennisPlayer lastHit;
    protected TableTennisPlayer currentServer;
    protected int pointNumber;
    protected int player1Games;
    protected int player2Games;
    protected int gameNumber = 1;

    public TableTennisMatch(TableTennisPlayer player1, TableTennisPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public TableTennisPlayer playMatch() throws InterruptedException {
        while (gameNumber <= Constants.MAX_GAMES_CAN_PLAY.gameConstants) {
            playGame();
            System.out.println();
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

    public void playGame() throws InterruptedException {

        while (player2Points < Constants.POINTS_TO_WIN.gameConstants && player1Points < Constants.POINTS_TO_WIN.gameConstants) {
            playPoint();
            //If player 1 gets to 11 points.
            if (player1Points == Constants.POINTS_TO_WIN.gameConstants) {
                player1Games += 1;
                player1.setGamesWon(player1.getGamesWon() + 1);
                break;
            }
            //If player 2 gets to 11 points.
            else if (player2Points == Constants.POINTS_TO_WIN.gameConstants) {
                player2Games += 1;
                player2.setGamesWon(player2.getGamesWon() + 1);
                break;
            }
            //If deuce(draw at 10 points)
            else if (player1Points == Constants.DEUCE.gameConstants && player2Points == Constants.DEUCE.gameConstants) {
                System.out.print(String.format("Game %o - Deuce!", gameNumber));
                Thread.sleep(2500);
                System.out.print("\r");
                playPoint();
                while (true) {
                    //If player 1 has advantage.
                    if (player1Points == player2Points + 1) {
                        System.out.print(String.format("Game %o - %s advantage!", gameNumber, player1.getFullName()));
                        Thread.sleep(2500);
                        System.out.print("\r");
                        playPoint();
                        if (player1Points == player2Points + 2) {
                            player1Games += 1;
                            player1.setGamesWon(player1.getGamesWon() + 1);
                            break;
                        } else {
                            if (player1Points == Constants.MAX_POINTS_CAN_PLAY.gameConstants) {
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
                        System.out.print(String.format("Game %o - %s advantage!", gameNumber, player2.getFullName()));
                        Thread.sleep(2500);
                        System.out.print("\r");
                        playPoint();
                        if (player2Points == player1Points + 2) {
                            player2Games += 1;
                            player2.setGamesWon(player2.getGamesWon() + 1);
                            break;
                        } else {
                            if (player2Points == Constants.MAX_POINTS_CAN_PLAY.gameConstants) {
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
        pointNumber = 0;
    }

    public void playPoint() throws InterruptedException {

        whoServes();
        if(SuccessfulServe(this.currentHit)) {
            while (returnBall(this.currentHit)) {
                if(!returnBall(this.currentHit)) {
                    break;
                }
            }
        }

        pointNumber++;

        if (lastHit.getPlayerID() == player1.getPlayerID()) {
            player1Points += 1;
            player1.setPointsWon(player1.getPointsWon() + 1);
        } else {
            player2Points += 1;
            player2.setPointsWon(player2.getPointsWon() + 1);
        }

        System.out.print(String.format("Game %o - " + player1.getFullName() + " : " + player1Points + " " + player2.getFullName() + " : " + player2Points, gameNumber));
        Thread.sleep(250);
        System.out.print("\r");

    }

    public void whoServes() {

        int num;

        if(pointNumber == 0) {
            Random rand = new Random();
            num = rand.nextInt(2);
        } else {
            if (pointNumber % 2 == 0) {
                if (currentServer == player1) {
                    num = 2;
                } else {
                    num = 1;
                }
            } else {
                if(currentServer == player1) {
                    num = 1;
                } else {
                    num = 2;
                }
            }
        }

        if (num == 1) {
            //Player 1 serves first
            this.currentHit = player1;
            this.currentServer = player1;
            this.lastHit = player2;
        } else {
            //Player 2 serves first
            this.currentHit = player2;
            this.currentServer = player2;
            this.lastHit = player1;
        }
    }

    public boolean SuccessfulServe(TableTennisPlayer player) {

        Random rand = new Random();
        int number = rand.nextInt(100);

        if (number < player.getServePercentage()) {
            this.currentHit = this.lastHit;
            this.lastHit = player;
            return true;
        }
        return false;
    }

    public boolean returnBall(TableTennisPlayer player) {

        Random rand = new Random();

        //Is ball on left or right side of court?
        int side = rand.nextInt(2);
        String sideOfTable;
        if (side == 1) {
            sideOfTable = "left";
        } else {
            sideOfTable = "right";
        }

        //Does player return the ball.
        int hit = rand.nextInt(100);

        if (player.getLeftOrRightHanded().equals("left") && sideOfTable.equals("left")) {
            if (hit <= player.getForehandPercentage()) {
                this.currentHit = this.lastHit;
                this.lastHit = player;
                return true;
            }
        }

        if (player.getLeftOrRightHanded().equals("left") && sideOfTable.equals("right")) {
            if (hit <= player.getBackhandPercentage()) {
                this.currentHit = this.lastHit;
                this.lastHit = player;
                return true;
            }
        }

        if (player.getLeftOrRightHanded().equals("right") && sideOfTable.equals("left")) {
            if (hit <= player.getBackhandPercentage()) {
                this.currentHit = this.lastHit;
                this.lastHit = player;
                return true;
            }
        }

        if (player.getLeftOrRightHanded().equals("right") && sideOfTable.equals("right")) {
            if (hit <= player.getForehandPercentage()) {
                this.currentHit = this.lastHit;
                this.lastHit = player;
                return true;
            }
        }
        return false;
    }
}
