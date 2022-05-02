import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

/** Class to create table tennis players from the JSON file. **/
public class CreatePlayers {

    /**
     * Pulls data from JSON file and creates player objects.
     * @return ArrayList of table tennis players.
     */
    public static ArrayList<TableTennisPlayer> createTableTennisPlayers() {
        Gson gson = new Gson();
        try (Reader file = new FileReader("src/players.json")) {
            Type listType = new TypeToken<ArrayList<TableTennisPlayer>>() {}.getType();
            ArrayList<TableTennisPlayer> tableTennisPlayersArray = gson.fromJson(file, listType);
            Collections.shuffle(tableTennisPlayersArray);
            return tableTennisPlayersArray;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
