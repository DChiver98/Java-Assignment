public class Player {

    int playerID;
    String firstName;
    String lastName;
    int servePower;
    int serveSkill;
    int spin;
    int forehandPower;
    int backhandPower;

    public Player(int playerID, String firstName, String lastName, int servePower, int serveSkill, int spin, int forehandPower, int backhandPower) {
        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.servePower = servePower;
        this.serveSkill = serveSkill;
        this.spin = spin;
        this.forehandPower = forehandPower;
        this.backhandPower = backhandPower;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getSpin() {
        return spin;
    }

    public void setSpin(int spin) {
        this.spin = spin;
    }

    public int getForehandPower() {
        return forehandPower;
    }

    public void setForehandPower(int forehandPower) {
        this.forehandPower = forehandPower;
    }

    public int getBackhandPower() {
        return backhandPower;
    }

    public void setBackhandPower(int backhandPower) {
        this.backhandPower = backhandPower;
    }
}


