import java.util.ArrayList;
import java.util.Scanner;

public class CreateTournament {

    private int numberPlayers;

    public int getNumberPlayers() {
        return numberPlayers;
    }

    public ArrayList<Player> getPlayers() {

        //Ask user for the amount of players.
        Scanner obj = new Scanner(System.in);
        System.out.println("How many players are there? : ");
        this.numberPlayers = obj.nextInt();
        while(this.numberPlayers > Player.createPlayers().size()) {
            System.out.println("Too many players! Please choose a smaller number : ");
            this.numberPlayers = obj.nextInt();
        }

        //Retrieve number of players from player list.
        ArrayList<Player> playersArray = Player.createPlayers();
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < numberPlayers; i++) {
            Player player = playersArray.get(i);
            players.add(player);
        }
        return players;
    }

    public ArrayList<Player> playRound(ArrayList<Player> players) {

        ArrayList<Player> loosers = new ArrayList<>();

        int player1 = 0;
        int player2 = 1;
        for(int i = 0; i < players.size()/2; i++) {
            WinsGame newGame = new WinsGame(players.get(player1), players.get(player2));
            Player looser = newGame.simMatch();
            loosers.add(looser);
            player1+=2;
            player2+=2;
        }
        return loosers;
    }
}

