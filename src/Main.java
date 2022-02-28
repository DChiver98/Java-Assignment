import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {

//        Scanner obj = new Scanner(System.in);
//        System.out.println("How many players are there? : ");
//        int numberPlayers = obj.nextInt();
//        System.out.println(numberPlayers);

        ArrayList players = Player.createPlayers();
        Player player = players.get(1);
    }
}