import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TableTennisTournament extends ArrayList {

    public ArrayList<TableTennisPlayer> getPlayers() {

        //Ask user for the amount of players.
        Scanner num = new Scanner(System.in);
        System.out.println("How many players are there? Please choose 2,4,8,16,32,64,128,256 or 512 : ");

        //Check if input is a not an integer.
        while(!num.hasNextInt()) {
            try {
                System.out.println("Not a Number! Please enter 2,4,8,16,32,64,128,256 or 512 : ");
                num.next();
            } catch (InputMismatchException ex) {
                num.next();
            }
        }

        int numberOfPlayers = num.nextInt();

        //Check if input is a valid number from the list.
        while(Math.log(numberOfPlayers) / Math.log(2) % 1 != 0 || numberOfPlayers <= 1 || numberOfPlayers > 512) {
            try {
                System.out.println("Please enter a valid number 2,4,8,16,32,64,128,256 or 512 : ");
                numberOfPlayers = num.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Not a Number! Please enter 2,4,8,16,32,64,128,256 or 512 : ");
                num.next();
            }
        }

        num.close();

        //Retrieve number of players from player list.
        ArrayList<TableTennisPlayer> playersArray = CreatePlayers.createTableTennisPlayers();
        ArrayList<TableTennisPlayer> players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            TableTennisPlayer player = playersArray.get(i);
            players.add(player);
        }
        return players;
    }

    public ArrayList<TableTennisPlayer> playTournament(ArrayList<TableTennisPlayer> players) throws InterruptedException {

        int player1 = 0;
        int player2 = 1;

        ArrayList<TableTennisPlayer> loosers = new ArrayList<>();

        //Input to simulate or watch
        Scanner num = new Scanner(System.in);
        System.out.println("Please enter :  \n1 - watch round \n2 - simulate round");

        //If user enters something other than an in Integer.
        while(!num.hasNextInt()) {
            try {
                System.out.println("Not a Number! Please enter 1 to watch or 2 to simulate : ");
                num.next();
            } catch (InputMismatchException ex) {
                num.next();
            }
        }

        int simOrWatch = num.nextInt();

        //If the user enters something other than a 1 or 2.
        while(simOrWatch != 1 && simOrWatch != 2) {
            try {
                System.out.println("Invalid number. Please enter 1 to watch or 2 to simulate : ");
                simOrWatch = num.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Not a Number! Please enter 1 to watch or 2 to simulate : ");
                num.next();
            }
        }

        num.close();

        //Play tournament
        for(int i = 0; i < players.size()/2; i++) {

            //If user enters 1 watch.
            if(simOrWatch == 1) {
                TableTennisGame watchGame = new TableTennisGame(players.get(player1), players.get(player2));
                TableTennisPlayer looser = watchGame.playMatch();
                loosers.add(looser);
            }
            //If user enters 2 simulate.
            if(simOrWatch == 2) {
                SimulationTableTennisGame simGame = new SimulationTableTennisGame(players.get(player1), players.get(player2));
                TableTennisPlayer looser = simGame.playMatch();
                loosers.add(looser);
            }
            //Next match.
            player1 += 2;
            player2 += 2;
        }
        return loosers;
    }
}

