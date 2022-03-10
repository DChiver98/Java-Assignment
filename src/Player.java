import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

public class Player {

    private int playerID;
    private String firstName;
    private String lastName;
    private int servePower;
    private int serveSkill;
    private int spin;
    private int forehandPower;
    private int forehandSkill;
    private int backhandPower;
    private int backhandSkill;
    private boolean status = true;
    private String leftOrRightHanded;
    private int matchesWon = 0;

    public Player(int playerID, String firstName, String lastName, int servePower, int serveSkill, int spin, int forehandPower, int forehandSkill, int backhandPower, int backhandSkill, String leftOrRightHanded) {
        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.servePower = servePower;
        this.serveSkill = serveSkill;
        this.spin = spin;
        this.forehandPower = forehandPower;
        this.forehandSkill = forehandSkill;
        this.backhandPower = backhandPower;
        this.backhandSkill = backhandSkill;
        this.leftOrRightHanded = leftOrRightHanded;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public int getServePower() {
        return servePower;
    }

    public int getServeSkill() {
        return serveSkill;
    }

    public int getSpin() {
        return spin;
    }

    public int getForehandPower() {
        return forehandPower;
    }

    public int getBackhandPower() {
        return backhandPower;
    }

    public boolean getStatus() {
        return status;
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

    public String getLeftOrRightHanded() {
        return this.leftOrRightHanded;
    }

    public int getmatchesWon() {
        return this.matchesWon;
    }

    public static ArrayList<Player> createPlayers() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("src/Players.json")) {
            Type listType = new TypeToken<ArrayList<Player>>() {}.getType();
            ArrayList<Player> playersArray = gson.fromJson(reader, listType);
            Collections.shuffle(playersArray);
            return playersArray;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}


