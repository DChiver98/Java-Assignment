import Genral_Display.Graphics;
import Genral_Display.Messages;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {

        Graphics.tennisRacket();
        Messages.welcomeMessage();
        CreatePlayers.createTableTennisPlayers();
        TableTennisTournament tournament = new TableTennisTournament();
        ArrayList<TableTennisPlayer> players = tournament.getPlayers();
        Messages.playersMessage();
        for (TableTennisPlayer player : players) {
            System.out.println(player.getFirstName() + " " + player.getLastName());
        }

        int roundNum = 1;

        while(players.size() > 1) {
            System.out.println("\nROUND NUMBER : " + roundNum + "\n");
            for(TableTennisPlayer looser : tournament.playTournament(players)) {
                players.remove(looser);
            }
            roundNum++;
        }

        System.out.println("The winner is! : " + players.get(0).getFullName());
    }
}
