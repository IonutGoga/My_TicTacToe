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

    public void makeMove(Move move, char symbol){
        game[move.line][move.col] = symbol;
    }


    public boolean isWinLine(int line, char symbol){
        boolean isWin = true;
        int i = 0;
        while(i < GAME_SIZE && isWin == true){
            if(game[line][i] != symbol){
                isWin = false;
            }
            i++;
        }
        return isWin;
    }

    public boolean isWinCol(int col, char symbol){
        boolean isWin = true;
        int i = 0;
        while(i < GAME_SIZE && isWin == true){
            if(game[i][col] != symbol){
                isWin = false;
            }
            i++;
        }
        return isWin;
    }

    public boolean isWinDiag1(char symbol){
        boolean isWin = true;
        int i = 0;
        while(i < GAME_SIZE && isWin == true){
            if(game[i][i] != symbol){
                isWin = false;
            }
            i++;
        }
        return isWin;
    }

    public boolean isWinDiag2(char symbol){
        boolean isWin = true;
        int i = 0;
        while(i < GAME_SIZE && isWin == true){
            if(game[i][GAME_SIZE - i -1] != symbol){
                isWin = false;
            }
            i++;
        }
        return isWin;
    }

    public boolean isWin(Move move, char symbol){
        boolean isWin = false;
        //testez linii
        isWin = isWinLine(move.line, symbol);

        //testez coloane
        if(isWin == false){
            isWin = isWinCol(move.col, symbol);
        }
        //testez diagonala 1
        if(isWin == false && move.line == move.col){
            isWin = isWinDiag1(symbol);
        }
        //testez diagonala 2
        if(isWin == false && move.line == GAME_SIZE - move.col - 1){
            isWin = isWinDiag2(symbol);
        }
        return isWin;
    }

    public void playGame(){
        initBoard();
        System.out.println("Incepe jocul");
        showGame();

        Player currentPlayer = player1;
        char currentSymbol = SYMBOL_X;

        int nrMoves = 0;
        boolean isWin = false;

        while(isWin == false || nrMoves < 9 ){

            //citesc mutare
            Move move = readMove();
            //validez mutare

            //efectuez mutare
            makeMove(move, currentSymbol);
            showGame();
            //numar mutare
            nrMoves++;

            if(nrMoves <= (2 * GAME_SIZE - 1)) {  //numarul maxim de mutari pana la win
                //testez daca avem stare de WIN
                isWin = isWin(move, currentSymbol);
            }
            // daca nu e WIN --- schimb jucatorul
            if(!isWin) {
                if (currentPlayer == player1) {
                    currentPlayer = player2;
                    currentSymbol = SYMBOL_0;
                } else {
                    currentPlayer = player1;
                    currentSymbol = SYMBOL_X;
                }
            }
        }
        if(isWin == false){
            System.out.println("Remiza");
        } else {
            System.out.println("Castigatorul este: " + currentPlayer);
        }
        //afisez mesaj corespunzator
    }

}
