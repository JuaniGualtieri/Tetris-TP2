package com.tetris;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestTetris5 {


    @Test
    public void testLines() {
        
        Board board = new Board();
        PieceStick piece1 = new PieceStick();
        board.addPieceBoard(piece1);
        piece1.moveDown(); //???
    
        // deberia de incluir chequear el final del juego
        board.updateBoard();
    
    }

    @Test
    public void testLineCompleteTrue() {
        Board board = new Board();
        int[] fila = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; //primer fila completa
        assertTrue(board.isLineComplete(fila));
    }

    @Test
    public void testLineCompleteFalse() {
        Board board = new Board();
        int[] fila = {0, 1, 1, 1, 0, 0, 1, 1, 0, 1}; //fila inc
        assertFalse(board.isLineComplete(fila));
    }

    @Test
    public void testRemoveLine() {

        Board board = new Board();

        for (int i = 0; i < 10; i++) {
            board.grid[19][i] = 1;
        }
        board.removeLine(19); //completamos y removemos ult fila!

        for (int i = 0; i < 10; i++) {
            assertEquals(0, board.grid[19][i]); //verif
        }

    }

    @Test
    public void testClearLinea() {
        Board board = new Board();

        for (int i = 0; i < 10; i++) {
            board.grid[19][i] = 1; 
            board.grid[18][i] = 1;
        }

        int linesCleared = board.clearLinea();
        assertEquals(2, linesCleared);

        for (int i = 18; i <= 19; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(0, board.grid[i][j]);
            }
        }
    }

    @Test
    public void testFinalJuegoWin() {
        Board board = new Board();
        
        for (int i = 0; i < 10; i++) {
            board.grid[15][i] = 1;
            board.grid[16][i] = 1;
            board.grid[17][i] = 1;
            board.grid[18][i] = 1;
            board.grid[19][i] = 1;
        }

        assertTrue(board.checkFinalDelJuego()); // Se gana el juego retorna true

    }
}
