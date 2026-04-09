package models.solver;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import sudoku.model.exceptions.FillingBoardSudokuException;
import sudoku.model.models.SudokuBoard;
import sudoku.model.solver.BacktrackingSudokuSolver;
import sudoku.model.solver.SudokuSolver;

public class SolverTest {

    @Test
    public void testSolveImpossibleBoardThrowsException() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(solver);

        // Create an impossible situation: two '5's in the same row
        board.setField(0, 0, 5);
        board.setField(1, 0, 5);

        assertThrows(FillingBoardSudokuException.class, () -> {
            solver.solve(board);
        });
    }
}