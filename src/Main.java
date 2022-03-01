import java.util.ArrayList;

/**
 * Student work : Dan Chivers
 */
public class Main {




    public static void main(String args[]) {

//        Scanner obj = new Scanner(System.in);
//        System.out.println("How many players are there? : ");
//        int numberPlayers = obj.nextInt();
//        System.out.println(numberPlayers);

        ArrayList<Player>players = Player.createPlayers();
        players = Player.createPlayers();


//        System.out.println( players.get(1).getFirstName() + " " + players.get(1).getLastName());
//
        players.forEach((n) -> System.out.println(n.getFirstName() + " " +  n.getLastName()));

    }
}

