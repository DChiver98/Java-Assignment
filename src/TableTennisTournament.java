import java.util.*;

/**
 * Table tennis tournament class to set up and run tournament.
 * Please see {@link Tournament} for implemented interface.
 */
public class TableTennisTournament implements Tournament {

    private int numberOfPlayers;
    private int numberOfRounds;
    private final ArrayList<TableTennisPlayer> players = new ArrayList<>();
    private final ArrayList<TableTennisPlayer> loosers = new ArrayList<>();
    private TableTennisPlayer winner;

    /**
     * Sets up table tennis tournament by retrieving number of players the user has entered.
     */
    public void setUpTournament() {

        //Gets user input for how many players are in the tournament.
        Scanner input = new Scanner(System.in);
        System.out.println("How many players are there? Please enter 4,8,16,32,64,128,256 or 512 (the default is 64)");

        //Error checking for if the user enters nothing(default to 64) or enters a non number character.
        while(numberOfPlayers == 0) {

            String num = input.nextLine();

            try {
                if(Objects.equals(num, "")) {
                    numberOfPlayers = 64;
                } else {
                    numberOfPlayers = Integer.parseInt(num);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Not a number! Please enter a valid number 4,8,16,32,64,128,256 or 512");
            }
        }

        //Check if input is a valid number from the list.
        while (Math.log(numberOfPlayers) / Math.log(2) % 1 != 0 || numberOfPlayers < 4 || numberOfPlayers > 512) {
            try {
                System.out.println("Please enter a valid number 4,8,16,32,64,128,256 or 512");
                numberOfPlayers = input.nextInt();
            } catch (InputMismatchException ex) {
                input.next();
                System.out.print("Not a Number! ");
            }
        }

        //Retrieve number of players from player list.
        ArrayList<TableTennisPlayer> playersArray = CreatePlayers.createTableTennisPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            assert playersArray != null;
            TableTennisPlayer player = playersArray.get(i);
            players.add(player);
        }

        numberOfRounds = (int)(Math.log(numberOfPlayers) / Math.log(2));
    }

    /**
     * Runs a table tennis tournament
     * @throws InterruptedException
     */
    public void playTournament() throws InterruptedException {

        //Create players for tournament.
        setUpTournament();

        //Print's names of all players in the tournament.
        System.out.print("\nPlayers in the tournament are : ");
        for(TableTennisPlayer players : players) {
            System.out.print(players.getFullName() + ", ");
        }
        System.out.println();

        //Play tournament
        while (players.size() > 1) {

            //Print next number.
            switch(numberOfRounds) {
                case 1 :
                    System.out.println("\nNext Round : Final");
                    break;
                case 2 :
                    System.out.println("\nNext Round : Semi-Final");
                    break;
                case 3 :
                    System.out.println("\nNext Round : Quarter-Final");
                    break;
                default :
                    System.out.println("\nNext Round : " + numberOfRounds);
            }

            //Input to simulate or watch
            Scanner input = new Scanner(System.in);
            System.out.println("\nPlease enter :  \n1 - watch round \n2 - simulate round \n(default is simulate)");
            int simOrWatch = 0;

            //If no number entered set default, if non-number characters entered ask user to try again.
            while(simOrWatch == 0) {

                String num = input.nextLine();

                try {
                    if(Objects.equals(num, "")) {
                        simOrWatch = 2;
                    } else {
                        simOrWatch = Integer.parseInt(num);
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Not a number! Please enter a valid number 1 to watch or 2 to simulate");
                }
            }

            //Error if the user enters something other than a 1 or 2.
            while (simOrWatch != 1 && simOrWatch != 2) {
                try {
                    System.out.println("Please enter a valid number 1 to watch or 2 to simulate");
                    simOrWatch = input.nextInt();
                } catch (InputMismatchException ex) {
                    input.next();
                    System.out.print("Not a Number! ");
                }
            }

            int player1 = 0;
            int player2 = 1;

            for (int i = 1; i <= players.size()/2; i++) {

                System.out.printf("\nMatch %d : %s VS %s\n%n", i,players.get(player1).getFullName(),players.get(player2).getFullName());

                //If user enters 1 watch.
                if (simOrWatch == 1) {
                    TableTennisMatch watchGame = new TableTennisMatch(players.get(player1), players.get(player2));
                    TableTennisPlayer looser = watchGame.playMatch();
                    loosers.add(looser);
                }
                //If user enters 2 simulate.
                if (simOrWatch == 2) {
                    SimulationTableTennisMatch simGame = new SimulationTableTennisMatch(players.get(player1), players.get(player2));
                    TableTennisPlayer looser = simGame.playMatch();
                    loosers.add(looser);
                }
                //Next match.
                player1 += 2;
                player2 += 2;
            }
            //Remove loosing players from active tournament.
            for(TableTennisPlayer looser : loosers) {
                players.remove(looser);
            }
            numberOfRounds --;
        }
        //Set the winner.
        this.winner = players.get(0);
    }

    /**
     * Calculates and displays table tennis tournament results.
     */
    public void tournamentResults() {

        //Calculates and displays results.
        System.out.println("\nTournament Results : ");
        System.out.printf("1st place - %s with %d matches won, %d games won, and %d points won!%n",winner.getFullName(),winner.getMatchesWon(),winner.getGamesWon(),winner.getPointsWon());
        loosers.sort(Comparator.comparing(TableTennisPlayer::getMatchesWon).reversed());
        loosers.sort(Comparator.comparing(TableTennisPlayer::getGamesWon).reversed());
        loosers.sort(Comparator.comparing(TableTennisPlayer::getPointsWon).reversed());
        System.out.printf("2nd place - %s with %d matches won, %d games won, and %d points won!%n",loosers.get(0).getFullName(),loosers.get(0).getMatchesWon(),loosers.get(0).getGamesWon(),loosers.get(0).getPointsWon());
        System.out.printf("3rd place - %s with %d matches won, %d games won, and %d points won!%n",loosers.get(1).getFullName(),loosers.get(1).getMatchesWon(),loosers.get(1).getGamesWon(),loosers.get(1).getPointsWon());
    }
}

