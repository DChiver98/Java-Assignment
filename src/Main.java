import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {

        System.out.println("          *****           ");
        System.out.println("        *-|-|-|-*         ");
        System.out.println("       *-|-|-|-|-*        ");
        System.out.println("       *-|-|-|-|-*        ");
        System.out.println("        *-|-|-|-*         ");
        System.out.println("          *****           ");
        System.out.println("           | |            ");
        System.out.println("           | |            ");
        System.out.println("           |_|            ");
        System.out.println("Welcome to the table tennis tournament simulator.");

        CreateTournament tournament = new CreateTournament();
        ArrayList<Player> players = tournament.getPlayers();
        System.out.println("Players in the tournament are : \n");
        for (Player player : players) {
            System.out.println(player.getFirstName() + " " + player.getLastName());
        }
        for(Player player : players) {
            int player1 = 0;
            int player2 = 1;
            while(player2 < players.size()) {
                WinsMatch newMatch = new WinsMatch(players.get(player1), players.get(player2));
                newMatch.simMatch();
                player1 += 2;
                player2 += 2;
            }
        }
    }
}
