import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

public class CreatePlayers {

    public static ArrayList<TableTennisPlayer> createTableTennisPlayers() {
        Gson gson = new Gson();
        try (Reader file = new FileReader("src/Players.json")) {
            Type listType = new TypeToken<ArrayList<TableTennisPlayer>>() {}.getType();
            ArrayList<TableTennisPlayer> tableTennisPlayersArray = gson.fromJson(file, listType);
            Collections.shuffle(tableTennisPlayersArray);
            return tableTennisPlayersArray;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static ArrayList<TennisPlayer> createTennisPlayers() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("src/Players.json")) {
            Type listType = new TypeToken<ArrayList<TennisPlayer>>() {}.getType();
            ArrayList<TennisPlayer> footballPlayersArray = gson.fromJson(reader, listType);
            Collections.shuffle(footballPlayersArray);
            return footballPlayersArray;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
