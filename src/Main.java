/** Main class to run program **/
public class Main {
    public static void main(String[] args) throws InterruptedException {

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
        System.out.println();
        System.out.println("                   How to use");
        System.out.println("-----------------------------------------------------");
        System.out.println("¦ 1. Enter the number of players.                   ¦");
        System.out.println("¦ 2. Choose to sim or watch each round.             ¦");
        System.out.println("¦ 3. After the final round the podium will display. ¦");
        System.out.println("¦                                                   ¦");
        System.out.println("¦    ('next round' also shows round's remaining)    ¦");
        System.out.println("-----------------------------------------------------");
        System.out.println();

        //Create new Table Tennis Tournament
        TableTennisTournament tournament = new TableTennisTournament();
        //Play tournament.
        tournament.playTournament();
        //Print results.
        tournament.tournamentResults();
    }
}
