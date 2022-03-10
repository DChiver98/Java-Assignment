import java.util.ArrayList;
import java.util.Scanner;

public class CreateTournament {

    private int numberPlayers;

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

        //If odd number of players add a dummy player.
        if(numberPlayers % 2 != 0) {
            Player dummy = new Player(0,"Dummy","Player",0,0,0,0,0,0,0, "left");
            players.add(dummy);
        }
        return players;
    }

    public void DrawPlayers() {

        ArrayList<Player> drawOne = new ArrayList<>();
        ArrayList<Player> drawTwo = new ArrayList<>();


    }
}

