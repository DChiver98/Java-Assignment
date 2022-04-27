/** Main class to run program **/
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

        //Create new Table Tennis Tournament
        TableTennisTournament tournament = new TableTennisTournament();
        //Play tournament.
        tournament.playTournament();
        //Print results.
        tournament.tournamentResults();
    }
}
