import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws Exception {

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
