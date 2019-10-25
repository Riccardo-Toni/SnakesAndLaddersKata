import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GameShould {

    @Mock
    private Token player1;

    @Mock
    private Token player2;

    @Test
    void start_the_game_setting_allToken_on_square_one() {
        Board board = new Board();
        Die die = new Die();
        Game game = new Game(die, player1, player2);
        game.start(board);
        verify(player1).position(1);
        verify(player2).position(1);
    }
}
