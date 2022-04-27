import java.util.Random;

/** Creates watchable Table Tennis Match **/
public class TableTennisMatch {

    /** Protected variables to allow access for SimulateTableTennisMatch **/
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

    /** Constructor for Table Tennis match **/
    public TableTennisMatch(TableTennisPlayer player1, TableTennisPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /** Plays individual match **/
    public TableTennisPlayer playMatch() throws InterruptedException {
        //Keep playing games until winner or 7 played.
        while (gameNumber <= Constants.MAX_GAMES_CAN_PLAY.gameConstants) {
            playGame();
            System.out.println();
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

    /** Plays individual game **/
    public void playGame() throws InterruptedException {

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
                        System.out.print(String.format("Game %o - %s advantage!", gameNumber, player2.getFullName()));
                        Thread.sleep(2500);
                        System.out.print("\r");
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
        //Reset points back to zero for next game.
        player1Points = 0;
        player2Points = 0;
        pointNumber = 0;
    }

    /** Plays individual point **/
    public void playPoint() throws InterruptedException {

        //Play point.
        whoServes();
        if(SuccessfulServe(this.currentHit)) {
            while (returnBall(this.currentHit)) {
                if(!returnBall(this.currentHit)) {
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

        //Print live game to terminal.
        System.out.print(String.format("Game %o - " + player1.getFullName() + " : " + player1Points + " " + player2.getFullName() + " : " + player2Points, gameNumber));
        Thread.sleep(250);
        System.out.print("\r");

    }

    /** Decides who is serving for each point **/
    public void whoServes() {

        int num;

        //If first serve randomly choose.
        if(pointNumber == 0) {
            Random rand = new Random();
            num = rand.nextInt(2);
        } else {
            //Switch server every 2 points.
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

        //Set server to play point.
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

    /** Decides if the players serve was successful or not **/
    public boolean SuccessfulServe(TableTennisPlayer player) {

        //Does the player successfully serve or fail the serve.
        Random rand = new Random();
        int number = rand.nextInt(100);

        if (number < player.getServePercentage()) {
            this.currentHit = this.lastHit;
            this.lastHit = player;
            return true;
        }
        return false;
    }

    /** Decides if the player successfully returned the ball or not **/
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

        //Does play return the ball.
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
