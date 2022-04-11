import java.util.ArrayList;

public class Main extends Messages {
    public static void main(String args[]) {

        Graphics.tennisRacket();
        welcomeMessage();
        CreatePLayers.createPlayers();
        CreateTournament tournament = new CreateTournament();
        ArrayList<Player> players = tournament.getPlayers();
        playersMessage();
        for (Player player : players) {
            System.out.println(player.getFirstName() + " " + player.getLastName());
        }

        int roundNum = 1;

        while(players.size() > 1) {
            System.out.println("\nROUND NUMBER : " + roundNum + "\n");
            for(Player looser : tournament.playRound(players)) {
                players.remove(looser);
            }
            roundNum++;
        }

        System.out.println("The winner is! : " + players.get(0).getFullName());
    }
}
