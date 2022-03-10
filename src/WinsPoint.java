import java.util.Random;

public class WinsPoint {

    private final Player player1;
    private final Player player2;
    private int player1Points;
    private int player2Points;
    private Player currentHit;
    private Player lastHit;
    private int shotNumber;
    private int thisServe;

    public WinsPoint(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public int getPlayer1Points() {
        return player1Points;
    }

    public int getPlayer2Points() {
        return player2Points;
    }

    public void setPlayer1Points(int player1Points) {
        this.player1Points = player1Points;
    }

    public void setPlayer2Points(int player2Points) {
        this.player2Points = player2Points;
    }

    public void simPoint() {

        if(SuccessfullServe(currentHit)) {
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
        int number = rand.nextInt(2);

        if (number == 1) {
            //Player 1 serves first
            this.currentHit = player1;
            this.lastHit = player2;
            thisServe = 1;
        } else {
            //Player 2 serves first
            this.currentHit = player2;
            this.lastHit = player1;
            thisServe = 2;
        }
    }

    public boolean SuccessfullServe(Player player) {

        System.out.println(player.getFullName() + " Will serve.");

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
