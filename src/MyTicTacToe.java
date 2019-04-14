import java.util.Scanner;
public class MyTicTacToe {

    public static final char SYMBOL_X = 'X';
    public static final char SYMBOL_0 = '0';

    public static final  int GAME_SIZE = 3;

    char[][] game = new char[GAME_SIZE][GAME_SIZE];

    Player player1;
    Player player2;

    public MyTicTacToe (Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void showGame(){
        for (int i = 0; i < GAME_SIZE; i++){
            for (int j = 0; j < GAME_SIZE; j++){
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void initBoard(){
        for (int i = 0; i < GAME_SIZE; i++){
            for (int j = 0; j < GAME_SIZE; j++){
                game[i][j] = '.';
            }
        }
    }

    public Move readMove(){
        Scanner s = new Scanner(System.in);
        System.out.println("Make move: ");
        String myMove = s.nextLine();

        String[] splt = myMove.split("-");
        int myLine = Integer.valueOf(splt[0]);
        int myCol = Integer.valueOf(splt[1]);

        Move m = new Move(myLine, myCol);

        return m;
    }



    public boolean isWin(){
        //testez linii
        //testez coloane
        //testez diagonala 1
        //testez diagonala 2
        return false;
    }

    public void playGame(){
        initBoard();
        System.out.println("Incepe jocul");
        showGame();

        Player currentPlayer = player1;
        int nrMoves = 0;
        boolean isWin = false;

        while(isWin == false || nrMoves < 9 ){

            //citesc mutare
            Move move = readMove();
            System.out.println(move.line);
            System.out.println(move.col);
            //validez mutare
            //efectuez mutare
            //numar mutare
            //testez daca avem stare de WIN
            // daca nu e WIN --- schimb jucatorul

        }

        //afisez mesaj corespunzator
    }

}
