/**
 * Player class creates player objects.
 */

public class Player implements SportsPlayer{
//    RH - this could extend a GeneralSportsPlayer class (which could be abstract)

// add properties specific to a TT pplayer?

    private int playerID;
    private String firstName;
    private String lastName;
    private int servePower;
    private int serveSkill;
    private int forehandPower;
    private int forehandSkill;
    private int backhandPower;
    private int backhandSkill;
    private boolean status = true;
    private String leftOrRightHanded;
    private int matchesWon = 0;

    public Player(int playerID, String firstName, String lastName, int servePower, int serveSkill, int forehandPower, int forehandSkill, int backhandPower, int backhandSkill, String leftOrRightHanded) {
        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.servePower = servePower;
        this.serveSkill = serveSkill;
        this.forehandPower = forehandPower;
        this.forehandSkill = forehandSkill;
        this.backhandPower = backhandPower;
        this.backhandSkill = backhandSkill;
        this.leftOrRightHanded = leftOrRightHanded.toLowerCase();
    }

    public int getPlayerID() {
        return this.playerID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public boolean getStatus() {
        return this.status;
    }

    public int getServePercentage() {
        return this.servePower * this.serveSkill;
    }

    public int getForehandPercentage() {
        return this.forehandPower * this.forehandSkill;
    }

    public int getBackhandPercentage() {
        return this.backhandPower * this.backhandSkill;
    }

    public String getLeftOrRightHanded() {
        return this.leftOrRightHanded;
    }

    public int getmatchesWon() {
        return this.matchesWon;
    }

    /**
     * Reads players from JSON and puts them into a Array List.
     * @return
     */

    @Override
    public void showPlayerName() {
        System.out.println("Player is called " + getFullName());
    }
}


