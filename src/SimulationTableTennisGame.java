import java.util.Random;

public class SimulationTableTennisGame {

    private TableTennisPlayer player1;
    private TableTennisPlayer player2;
    private int player1Points;
    private int player2Points;
    private TableTennisPlayer currentHit;
    private TableTennisPlayer lastHit;
    private int player1Games;
    private int player2Games;

    public SimulationTableTennisGame(TableTennisPlayer player1, TableTennisPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public TableTennisPlayer playMatch() {
        System.out.println("\n" + player1.getFullName() + " VS " + player2.getFullName());
        int games = 0;
        while (games < 7) {
            playGame();
            if (player1Games == 4) {
                System.out.println(player1.getFullName() + " Wins the match.\n");
                return player2;
            } else if (player2Games == 4) {
                System.out.println(player2.getFullName() + " Wins the match.\n");
                return player1;
            } else {
                games++;
            }
        }
        if (player1Games > player2Games) {
            System.out.println(player1.getFullName() + " Wins the match.\n");
            return player2;
        } else {
            System.out.println(player2.getFullName() + " Wins the match.\n");
            return player1;
        }
    }

    public void playGame() {

        while (player2Points < 11 && player1Points < 11) {
            playPoint();
            if (player1Points == 11) {;
                player1Games += 1;
                break;
            } else if (player2Points == 11) {
                player2Games += 1;
                break;
            } else if (player1Points == 10 && player2Points == 10) {;
                playPoint();
                while (true) {
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
        } else {
            player2Points += 1;
        }
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

        //Return ball percentage
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
