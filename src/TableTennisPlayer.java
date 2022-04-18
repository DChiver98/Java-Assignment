public class TableTennisPlayer extends SportsPlayer {

    private int playerID;
    private int servePower;
    private int serveSkill;
    private int forehandPower;
    private int forehandSkill;
    private int backhandPower;
    private int backhandSkill;

    public TableTennisPlayer(int playerID, String firstName, String lastName, int age, String gender, int servePower, int serveSkill, int forehandPower, int forehandSkill, int backhandPower, int backhandSkill, String leftOrRightHanded, String leftOrRightFooted) {
        super(firstName, lastName, age, gender, leftOrRightHanded, leftOrRightFooted);
        this.playerID = playerID;
        this.servePower = servePower;
        this.serveSkill = serveSkill;
        this.forehandPower = forehandPower;
        this.forehandSkill = forehandSkill;
        this.backhandPower = backhandPower;
        this.backhandSkill = backhandSkill;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getServePower() {
        return servePower;
    }

    public void setServePower(int servePower) {
        this.servePower = servePower;
    }

    public int getServeSkill() {
        return serveSkill;
    }

    public void setServeSkill(int serveSkill) {
        this.serveSkill = serveSkill;
    }

    public int getForehandPower() {
        return forehandPower;
    }

    public void setForehandPower(int forehandPower) {
        this.forehandPower = forehandPower;
    }

    public int getForehandSkill() {
        return forehandSkill;
    }

    public void setForehandSkill(int forehandSkill) {
        this.forehandSkill = forehandSkill;
    }

    public int getBackhandPower() {
        return backhandPower;
    }

    public void setBackhandPower(int backhandPower) {
        this.backhandPower = backhandPower;
    }

    public int getBackhandSkill() {
        return backhandSkill;
    }

    public void setBackhandSkill(int backhandSkill) {
        this.backhandSkill = backhandSkill;
    }

    public int getServePercentage() {
        return servePower * serveSkill;
    }

    public int getForehandPercentage() {
        return forehandPower * forehandSkill;
    }

    public int getBackhandPercentage() {
        return backhandPower * backhandSkill;
    }
}