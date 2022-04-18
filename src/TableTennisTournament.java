import java.util.ArrayList;
import java.util.Scanner;

public class TableTennisTournament extends ArrayList implements Tournament {

    private int numberOfPlayers;

    public ArrayList<TableTennisPlayer> getPlayers() {

        //Ask user for the amount of players.
        Scanner obj = new Scanner(System.in);
        System.out.println("How many players are there? : ");
        this.numberOfPlayers = obj.nextInt();
        while(this.numberOfPlayers > CreatePlayers.createTableTennisPlayers().size()) {
            System.out.println("Too many players! Please choose a smaller number : ");
            this.numberOfPlayers = obj.nextInt();
        }

        //Retrieve number of players from player list.
        ArrayList<TableTennisPlayer> playersArray = CreatePlayers.createTableTennisPlayers();
        ArrayList<TableTennisPlayer> players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            TableTennisPlayer player = playersArray.get(i);
            players.add(player);
        }
        return players;
    }

    public ArrayList<TableTennisPlayer> playTournament(ArrayList<TableTennisPlayer> players) {

        ArrayList<TableTennisPlayer> loosers = new ArrayList<>();

        int player1 = 0;
        int player2 = 1;
        for(int i = 0; i < players.size()/2; i++) {
            TableTennisGame newGame = new TableTennisGame(players.get(player1), players.get(player2));
            TableTennisPlayer looser = newGame.playMatch();
            loosers.add(looser);
            player1+=2;
            player2+=2;
        }
        return loosers;
    }
}

