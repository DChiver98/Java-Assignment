import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

public class CreatePLayers {

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
