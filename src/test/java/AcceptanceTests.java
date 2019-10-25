import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class AcceptanceTests {

    @Mock
    private Die die;

    private Board board;
    private Game game;
    private Token player1;
    private Token player2;

    @BeforeEach
    void setUp() {
        player1 = new Token("Mark");
        player2 = new Token("Phil");
        game = new Game(die, player1, player2);
        board = new Board();
    }

    @Test
    void token_should_move_on_board() {
        given(die.roll()).willReturn(5);
        game.start(board);
        game.move();
        game.move();
        game.move();
        int position = game.playerPosition(player1);
        assertTrue(position == 10);
    }

    @Test
    void player_win_the_game_if_gets_to_square_100() {
        given(die.roll()).willReturn(5);
        game.start(board);
        for (int i = 0; i < 39; i++) {
        game.move();
        }
        boolean isWinner = game.hasWonTheGame(player1);
        assertTrue(isWinner);
    }

    @Test
    void if_token_end_on_snake_head_go_down() {
        given(die.roll()).willReturn(6);
        game.start(board);
        game.move();
        game.move();
        game.move();
        int position = game.playerPosition(player1);
        assertTrue(position == 2);
    }

    @Test
    void if_token_end_on_ladder_go_up() {
        given(die.roll()).willReturn(6);
        game.start(board);
        game.move();
        game.move();
        game.move();
        game.move();
        game.move();
        int position = game.playerPosition(player1);
        assertTrue(position == 28);
    }
}
