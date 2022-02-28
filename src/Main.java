import java.util.ArrayList;

/**
 * Student work : Dan Chivers
 */
public class Main {

    static ArrayList<Player> thePlayer = new ArrayList<>();


    public static void main(String args[]) {

//        Scanner obj = new Scanner(System.in);
//        System.out.println("How many players are there? : ");
//        int numberPlayers = obj.nextInt();
//        System.out.println(numberPlayers);

//        ArrayList players = Player.createPlayers();
        thePlayer = Player.createPlayers();

//        System.out.println( "class " + thePlayer.get(1).getFirstName() + " " + thePlayer.get(1).getLastName());


        thePlayer.forEach((n) -> System.out.println(n.getFirstName() + " " + n.getLastName()   ));

    }
}

