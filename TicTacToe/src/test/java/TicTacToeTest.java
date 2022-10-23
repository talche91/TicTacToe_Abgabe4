import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void testTicTacToePlayerXWon() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {1,0,2, 0,1,2, 2,0,1};
        int pos = ticTacToe.checkTicTacToePosition(board);
        assertThat(pos).isEqualTo(1);
    }

    @Test
    public void testTicTacToePlayerOWon() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {1,0,2, 0,1,2, 1,0,2};
        int pos = ticTacToe.checkTicTacToePosition(board);
        assertThat(pos).isEqualTo(2);
    }

    @Test
    public void testTicTacToePlayerXWonDiagonal() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {0,2,1, 0,1,2, 1,2,0};
        int pos = ticTacToe.checkTicTacToePosition(board);
        assertThat(pos).isEqualTo(1);
    }

    @Test
    public void testTicTacToePlayerOWonDiagonal() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {0,1,2, 0,2,1, 2,1,0};
        int pos = ticTacToe.checkTicTacToePosition(board);
        assertThat(pos).isEqualTo(2);
    }

    @Test
    public void testTicTacToePlayerXWonRowAndColumn() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {2,2,2, 0,0,1, 0,0,1};
        int pos = ticTacToe.checkTicTacToePosition(board);
        assertThat(pos).isEqualTo(2);
    }

    @Test
    public void testTicTacToeNeitherPlayerWon() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {1,0,2, 1,0,2, 2,0,1};
        int pos = ticTacToe.checkTicTacToePosition(board);
        assertThat(pos).isEqualTo(0);
    }

    @Test
    public void testTicTacToeTooManyMoves() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {1,0,2, 0,1,1, 2,0,1};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            int pos = ticTacToe.checkTicTacToePosition(board);
        }).withMessageMatching("One player has made too many moves");
    }

    @Test
    public void testTicTacToeInvalidPlayer() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {1,0,2, 0,1,3, 2,0,1};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            int pos = ticTacToe.checkTicTacToePosition(board);
        }).withMessageMatching("Invalid player");
    }

    @Test
    public void testTicTacToeInvalidBoard() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {1,0,2, 0,1,3};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            int pos = ticTacToe.checkTicTacToePosition(board);
        }).withMessageMatching("Incorrect size of board");
    }
}
