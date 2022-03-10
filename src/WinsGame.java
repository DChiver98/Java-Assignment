public class WinsGame extends WinsPoint{

    private int player1Games;
    private int player2Games;

    public WinsGame(Player player1, Player player2) {
        super(player1, player2);
    }

    public int getPlayer1Games() {
        return player1Games;
    }

    public int getPlayer2Games() {
        return player2Games;
    }

    public void simGame() {
//        int shotNumber = 1;
//        System.out.println("\n" + getPlayer1().getFullName() + " VS " + getPlayer2().getFullName() + "\n");
        while(getPlayer2Points() < 11 && getPlayer1Points() < 11) {
            simPoint();
//            String shot = String.format("Shot %s", shotNumber);
//            System.out.println(shot);
//            shotNumber += 1;
            if (getPlayer1Points() == 11) {

//                System.out.println(getPlayer1().getFullName() + " wins");
                System.out.println(getPlayer1().getFullName() + " : " + getPlayer1Points() + " " + getPlayer2().getFullName() + " : " + getPlayer2Points());
                player1Games += 1;
                break;

            } else if (getPlayer2Points() == 11) {

//                System.out.println(getPlayer2().getFullName() + " wins");
                System.out.println(getPlayer1().getFullName() + " : " + getPlayer1Points() + " " + getPlayer2().getFullName() + " : " + getPlayer2Points());
                player2Games += 1;
                break;

            } else if (getPlayer1Points() == 10 && getPlayer2Points() == 10) {

                System.out.println("Deuce");
                System.out.println(getPlayer1().getFullName() + " : " + getPlayer1Points() + " " + getPlayer2().getFullName() + " : " + getPlayer2Points());
                simPoint();

                while(true) {

                    if (getPlayer1Points() == getPlayer2Points() + 1) {
                        System.out.println("Advantage " + getPlayer1().getFullName());
                        System.out.println(getPlayer1().getFullName() + " : " + getPlayer1Points() + " " + getPlayer2().getFullName() + " : " + getPlayer2Points());
                        simPoint();

                        if (getPlayer1Points() == getPlayer2Points() + 2) {
                            System.out.println(getPlayer1().getFullName() + " : " + getPlayer1Points() + " " + getPlayer2().getFullName() + " : " + getPlayer2Points());
                            System.out.println(getPlayer1().getFullName() + " Wins");
                            player1Games += 1;
                            break;

                        } else {

                            if(getPlayer1Points() == 15) {
                                System.out.println(getPlayer1().getFullName() + " : " + getPlayer1Points() + " " + getPlayer2().getFullName() + " : " + getPlayer2Points());
                                System.out.println(getPlayer1().getFullName() + " Wins");
                                player1Games += 1;
                                break;
                            } else {
                                System.out.println("Deuce");
                                System.out.println(getPlayer1().getFullName() + " : " + getPlayer1Points() + " " + getPlayer2().getFullName() + " : " + getPlayer2Points());
                                simPoint();
                                continue;
                            }
                        }
                    }

                    if (getPlayer2Points() == getPlayer1Points() + 1) {

                        System.out.println("Advantage " + getPlayer2().getFullName());
                        System.out.println(getPlayer1().getFullName() + " : " + getPlayer1Points() + " " + getPlayer2().getFullName() + " : " + getPlayer2Points());
                        simPoint();

                        if (getPlayer2Points() == getPlayer1Points() + 2) {

                            System.out.println(getPlayer1().getFullName() + " : " + getPlayer1Points() + " " + getPlayer2().getFullName() + " : " + getPlayer2Points());
                            System.out.println(getPlayer2().getFullName() + " Wins");
                            player2Games += 1;
                            break;

                        } else {
                            if(getPlayer2Points() == 15) {
                                System.out.println(getPlayer1().getFullName() + " : " + getPlayer1Points() + " " + getPlayer2().getFullName() + " : " + getPlayer2Points());
                                System.out.println(getPlayer1().getFullName() + " Wins");
                                player1Games += 1;
                                break;
                            } else {
                                System.out.println("Deuce");
                                System.out.println(getPlayer1().getFullName() + " : " + getPlayer1Points() + " " + getPlayer2().getFullName() + " : " + getPlayer2Points());
                                simPoint();
                                continue;
                            }
                        }
                    }
                }
            }
        }
        setPlayer1Points(0);
        setPlayer2Points(0);
//        shotNumber = 0;
    }
}
