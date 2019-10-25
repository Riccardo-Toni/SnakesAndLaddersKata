public class Game {

    private Die die;
    private Token[] players;
    private Board board;

    public Game(Die die, Token... players) {
        this.die = die;
        this.players = players;
    }

    public void start(Board board) {
//        this.board = board;
        for (Token token: players) {
            token.position(1);
        }
    }

    public void move() {
        throw new UnsupportedOperationException();


    }

    public int playerPosition(Token player1) {
        throw new UnsupportedOperationException();


    }

    public boolean hasWonTheGame(Token player1) {
        throw new UnsupportedOperationException();


    }
}
