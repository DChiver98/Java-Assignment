import java.util.Random;

public class TableTennisGame {

    private TableTennisPlayer player1;
    private TableTennisPlayer player2;
    private int player1Points;
    private int player2Points;
    private TableTennisPlayer currentHit;
    private TableTennisPlayer lastHit;
    private int player1Games;
    private int player2Games;
    private int gameNumber;

    public TableTennisGame(TableTennisPlayer player1, TableTennisPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public TableTennisPlayer playMatch() throws InterruptedException {
        System.out.println("\n" + player1.getFullName() + " VS " + player2.getFullName());
        gameNumber = 1;
        while (gameNumber <= 7) {
            playGame();
            System.out.println();
            if (player1Games == 4) {
                System.out.println(player1.getFullName() + " Wins the match.\n");
                return player2;
            } else if (player2Games == 4) {
                System.out.println(player2.getFullName() + " Wins the match.\n");
                return player1;
            } else {
                gameNumber++;
            }
        }
        return null;
    }

    public void playGame() throws InterruptedException {

        while (player2Points < 11 && player1Points < 11) {
            playPoint();
            //If player 1 gets to 11 points.
            if (player1Points == 11) {
                player1Games += 1;
                break;
            }
            //If player 2 gets to 11 points.
            else if (player2Points == 11) {
                player2Games += 1;
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
                            break;
                        } else {
                            if (player1Points == 15) {
                                player1Games += 1;
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
                            break;
                        } else {
                            if (player2Points == 15) {
                                player1Games += 1;
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

    public void playPoint() throws InterruptedException {

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
        } else {
            player2Points += 1;
        }

        System.out.print(String.format("Game %o " + player1.getFullName() + " : " + player1Points + " " + player2.getFullName() + " : " + player2Points, gameNumber));
        Thread.sleep(500);
        System.out.print("\r");

    }

    public void whoServes() {

        Random rand = new Random();
        int num = rand.nextInt(2);

        if (num == 1) {
            //Player 1 serves first
            this.currentHit = player1;
            this.lastHit = player2;
        } else {
            //Player 2 serves first
            this.currentHit = player2;
            this.lastHit = player1;
        }
    }

    public boolean SuccessfulServe(TableTennisPlayer player) {

        Random rand = new Random();
        int number = rand.nextInt(50);
        if (number <= player.getServePercentage()) {
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
