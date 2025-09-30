package com.tetris;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestTetris3 {
    @Test
    public void testBoard() {
        Board board = new Board();
        PieceStick piece = new PieceStick();
        PieceT piece2 = new PieceT();
        board.addPieceBoard(piece);
        board.addPieceBoard(piece2);
    }

    @Test
public void testPieceStick_baja_una_vez() {
    Board board = new Board();
    PieceStick piece = new PieceStick();
    piece.setX(0);
    piece.setY(0);

    piece.moveDown(); // simulamos que baja una vez

    assertEquals(1, piece.getY()); 
    assertTrue(board.LimitesVeri(piece));
}

    @Test
    public void testClock() {
        Board board = new Board();
        PieceStick pieceStick = new PieceStick();
        board.addPieceBoard(pieceStick);

        int initialY = pieceStick.getY();

        pieceStick.startTimer();

        try {
            // Espera 1 segundo para permitir solo un descenso
            Thread.sleep(500); // Ajusta el valor si es necesario
        } catch (InterruptedException e) {
            
        }

        pieceStick.stopTimer();

        // Verifica que la pieza solo haya descendido una o dos posiciones
        assertEquals(initialY + 2, pieceStick.getY()); // Ajusta según la lógica
    }

    @Test
    public void test_clock_pieceSquare(){
        Board board = new Board();
        PieceSquare pieceSquar = new PieceSquare();
        board.addPieceBoard(pieceSquar);

        assertEquals(0, pieceSquar.getY());


        pieceSquar.startTimer();
        try {
            // Espera 1 segundo para permitir solo un descenso
            Thread.sleep(100); // Ajusta el valor si es necesario
        } catch (InterruptedException e) {
            
        }

        pieceSquar.stopTimer();

        // Verifica que la pieza solo haya descendido una o dos posiciones
        assertEquals(2, pieceSquar.getY()); // Ajusta según la lógica
    }

    @Test
    public void test_clock_pieceT(){
        Board board = new Board();
        PieceT piecet = new PieceT();
        board.addPieceBoard(piecet);

        assertEquals(0, piecet.getY());


        piecet.startTimer();
        try {
            // Espera 1 segundo para permitir solo un descenso
            Thread.sleep(100); // Ajusta el valor si es necesario
        } catch (InterruptedException e) {
            
        }

        piecet.stopTimer();

        // Verifica que la pieza solo haya descendido una o dos posiciones
        assertEquals(2, piecet.getY()); // Ajusta según la lógica
    }

    @Test
    public void test_clock_pieceDog(){
        Board board = new Board();
        PieceDogLeft pieceDogL = new PieceDogLeft();
        board.addPieceBoard(pieceDogL);

        assertEquals(0, pieceDogL.getY());


        pieceDogL.startTimer();
        try {
            Thread.sleep(100); 
        } catch (InterruptedException e) {
            
        }

        pieceDogL.stopTimer();

        assertEquals(2, pieceDogL.getY()); 
    }

    @Test
    public void test_clock_pieceL(){
        Board board = new Board();
        PieceLLeft pieceL = new PieceLLeft();
        board.addPieceBoard(pieceL);

        assertEquals(0, pieceL.getY());


        pieceL.startTimer();
        try {
            // Espera 1 segundo para permitir solo un descenso
            Thread.sleep(100); // Ajusta el valor si es necesario
        } catch (InterruptedException e) {
            
        }

        pieceL.stopTimer();

        // Verifica que la pieza solo haya descendido una o dos posiciones
        assertEquals(2, pieceL.getY()); // Ajusta según la lógica
    }


 
    @Test
    public void testPieceDog_se_mueve_a_la_izquierda() { 
        Board board = new Board();
        PieceDogRight piece = new PieceDogRight();
        board.addPieceBoard(piece); 

        piece.moveLeft(); 

        assertEquals(-1, piece.getX()); 

        assertFalse(board.LimitesVeri(piece));
    }



    @Test
    public void testPieceDog_se_mueve_a_la_izquierda_en_0_0() { 
        Board board = new Board();
        PieceDogRight piece = new PieceDogRight();
        board.addPieceBoard(piece); 

        piece.setX(0);

        piece.moveLeft(); 

        assertEquals(-1, piece.getX()); 

        assertFalse(board.LimitesVeri(piece));
    }


}
