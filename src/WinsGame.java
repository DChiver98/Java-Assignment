import java.util.Random;

public class WinsGame {

    private final Player player1;
    private final Player player2;
    private int player1Points;
    private int player2Points;
    private int currentServer;
    private Player currentHit;
    private Player lastHit;
    private int player1Games;
    private int player2Games;

    public WinsGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player simMatch() {
        int games = 0;
        while(games < 7) {
            simGame();
            if(player1Games == 4) {
                System.out.println(player1.getFullName() + " Wins the match.\n");
                return player2;
            } else if(player2Games == 4) {
                System.out.println(player2.getFullName() + " Wins the match.\n");
                return player1;
            } else {
                games++;
            }
        }
        if(player1Games > player2Games) {
            System.out.println(player1.getFullName() + " Wins the match.\n");
            return player2;
        } else {
            System.out.println(player2.getFullName() + " Wins the match.\n");
            return player1;
        }
    }

    public void simGame() {
//        int shotNumber = 1;
//        System.out.println("\n" + getPlayer1().getFullName() + " VS " + getPlayer2().getFullName() + "\n");
        while(player2Points < 11 && player1Points < 11) {
            simPoint();
//            String shot = String.format("Shot %s", shotNumber);
//            System.out.println(shot);
//            shotNumber += 1;
            if (player1Points == 11) {

//                System.out.println(getPlayer1().getFullName() + " wins");
                System.out.println(player1.getFullName() + " : " + player1Points + " " + player2.getFullName() + " : " + player2Points);
                player1Games += 1;
                break;

            } else if (player2Points == 11) {

//                System.out.println(getPlayer2().getFullName() + " wins");
                System.out.println(player1.getFullName() + " : " + player1Points + " " + player2.getFullName() + " : " + player2Points);
                player2Games += 1;
                break;

            } else if (player1Points == 10 && player2Points == 10) {

                System.out.println("Deuce");
                System.out.println(player1.getFullName() + " : " + player1Points + " " + player2.getFullName() + " : " + player2Points );
                simPoint();

                while(true) {

                    if (player1Points == player2Points + 1) {
                        System.out.println("Advantage " + player1.getFullName());
                        System.out.println(player1.getFullName() + " : " + player1Points + " " + player2.getFullName() + " : " + player2Points);
                        simPoint();

                        if (player1Points == player2Points + 2) {
                            System.out.println(player1.getFullName() + " : " + player1Points + " " + player2.getFullName() + " : " + player2Points);
                            System.out.println(player1.getFullName() + " Wins");
                            player1Games += 1;
                            break;

                        } else {

                            if(player1Points == 15) {
                                System.out.println(player1.getFullName() + " : " + player1Points + " " + player2 .getFullName() + " : " + player2Points);
                                System.out.println(player1.getFullName() + " Wins");
                                player1Games += 1;
                                break;
                            } else {
                                System.out.println("Deuce");
                                System.out.println(player1.getFullName() + " : " + player1Points + " " + player2.getFullName() + " : " + player2Points);
                                simPoint();
                                continue;
                            }
                        }
                    }

                    if (player2Points == player1Points + 1) {

                        System.out.println("Advantage " + player2.getFullName());
                        System.out.println(player1.getFullName() + " : " + player1Points + " " + player2.getFullName() + " : " + player2Points);
                        simPoint();

                        if (player2Points  == player1Points + 2) {

                            System.out.println(player1.getFullName() + " : " + player1Points + " " + player2.getFullName () + " : " + player2Points);
                            System.out.println(player2.getFullName() + " Wins");
                            player2Games += 1;
                            break;

                        } else {
                            if(player2Points == 15) {
                                System.out.println(player1.getFullName() + " : " + player1Points + " " + player2.getFullName() + " : " + player2Points);
                                System.out.println(player1.getFullName() + " Wins");
                                player1Games += 1;
                                break;
                            } else {
                                System.out.println("Deuce");
                                System.out.println(player1.getFullName() + " : " + player1Points + " " + player2.getFullName() + " : " + player2Points);
                                simPoint();
                                continue;
                            }
                        }
                    }
                }
            }
        }
        player1Points = 0;
        player2Points = 0;
    }

    public void simPoint() {

        whoServes();
        if(SuccessfulServe(this.currentHit)) {
            while(true) {
                if(returnBall(this.currentHit)) {
                    returnBall(this.currentHit);
                } else {
//                    System.out.println(currentHit.getFullName() + " fails to return the ball.");
                    break;
                }
            }
        }
        if(lastHit.getPlayerID() == player1.getPlayerID()) {
            player1Points += 1;
        } else {
            player2Points += 1;
        }
    }

    public void whoServes() {

        Random rand = new Random();
        this.currentServer = rand.nextInt(2);

        if (this.currentServer == 1) {
            //Player 1 serves first
            this.currentHit = player1;
            this.lastHit = player2;
        } else {
            //Player 2 serves first
            this.currentHit = player2;
            this.lastHit = player1;
        }
    }

    public boolean SuccessfulServe(Player player) {

//        System.out.println(player.getFullName() + " Will serve.");

        Random rand = new Random();
        int number = rand.nextInt(50);
        if(number <= player.getServePercentage()) {
            this.currentHit = this.lastHit;
            this.lastHit = player;
            return true;
        }
//        System.out.println(player.getFullName() + " fails the serve.");
        return false;
    }

    public boolean returnBall(Player player) {

        Random rand = new Random();

        //Is ball on left or right side of court?
        int side = rand.nextInt(2);
        String sideOfTable;
        if(side == 1) {
            sideOfTable = "left";
        } else {
            sideOfTable = "right";
        }

        //Return ball percentage
        int hit = rand.nextInt(100);

        if(player.getLeftOrRightHanded().equals("left") && sideOfTable.equals("left")) {
            if (hit <= player.getForehandPercentage()) {
//                System.out.println(player.getFullName() + " returns the ball.");
                this.currentHit = this.lastHit;
                this.lastHit = player;
                return true;
            }
        }

        if(player.getLeftOrRightHanded().equals("left") && sideOfTable.equals("right")) {
            if(hit <= player.getBackhandPercentage()) {
//                System.out.println(player.getFullName() + " returns the ball.");
                this.currentHit = this.lastHit;
                this.lastHit = player;
                return true;
            }
        }

        if(player.getLeftOrRightHanded().equals("right") && sideOfTable.equals("left")) {
            if(hit <= player.getBackhandPercentage()) {
//                System.out.println(player.getFullName() + " returns the ball.");
                this.currentHit = this.lastHit;
                this.lastHit = player;
                return true;
            }
        }

        if(player.getLeftOrRightHanded().equals("right") && sideOfTable.equals("right")) {
            if(hit <= player.getForehandPercentage()) {
//                System.out.println(player.getFullName() + " returns the ball.");
                this.currentHit = this.lastHit;
                this.lastHit = player;
                return true;
            }
        }
        return false;
    }
}
