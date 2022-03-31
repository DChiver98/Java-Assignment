//public class WinsMatch extends WinsGame{
//
//    public WinsMatch(Player player1, Player player2) {
//        super(player1, player2);
//    }
//
//    public Player simMatch() {
//        int games = 0;
//        while(games < 7) {
//            simGame();
//            if(getPlayer1Games() == getPlayer2Games() + 4) {
//                System.out.println(getPlayer1().getFullName() + " Wins the match.\n");
//                return getPlayer2();
//            } else if(getPlayer2Games() == getPlayer1Games() + 4) {
//                System.out.println(getPlayer2().getFullName() + " Wins the match.\n");
//                return getPlayer1();
//            } else {
//                games++;
//            }
//        }
//        if(getPlayer1Games() > getPlayer2Games()) {
//            System.out.println(getPlayer1().getFullName() + " Wins the match.\n");
//            return getPlayer2();
//        } else {
//            System.out.println(getPlayer2().getFullName() + " Wins the match.\n");
//            return getPlayer1();
//        }
//    }
//}
