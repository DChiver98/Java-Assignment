import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws InterruptedException {

        //Welcome Message.
        System.out.println("          *****           ");
        System.out.println("        *-|-|-|-*         ");
        System.out.println("       *-|-|-|-|-*        ");
        System.out.println("       *-|-|-|-|-*        ");
        System.out.println("        *-|-|-|-*         ");
        System.out.println("          *****           ");
        System.out.println("           | |            ");
        System.out.println("           | |            ");
        System.out.println("           |_|            ");
        System.out.println("                          ");
        System.out.println("Welcome to the table tennis tournament simulator.");

        //Create Table Tennis players from JSON.
        CreatePlayers.createTableTennisPlayers();

        //Create new Table Tennis Tournament
        TableTennisTournament tournament = new TableTennisTournament();
        //Get players for tournament.
        ArrayList<TableTennisPlayer> players = tournament.getPlayers();
        //Display players in tournament.
        System.out.println("\nPlayers in the tournament are : \n");
        for (TableTennisPlayer player : players) {
            System.out.println(player.getFullName());
        }

        //Play tournament.
        int roundNum = 1;
        while(players.size() > 1) {
            System.out.println("\nROUND NUMBER : " + roundNum + "\n");
            for(TableTennisPlayer looser : tournament.playTournament(players)) {
                players.remove(looser);
            }
            roundNum++;
        }

        //Result of tournament.
        System.out.println("The winner is : " + players.get(0).getFullName());
    }
}
