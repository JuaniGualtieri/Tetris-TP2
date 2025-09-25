package com.tetris;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;


public class TestTetris4 {
    @Test
    public void testPieceDogNoPuedeBajarMas() {
        Board board = new Board();          
        PieceDogLeft piece = new PieceDogLeft(); 

        board.addPieceBoard(piece);

        // Simula movimientos hacia abajo hasta que la pieza toque el suelo
        while (board.LimitesVeri(piece)) {
            piece.moveDown();
        }

        // Verifica que la pieza no pueda bajar más, es decir, que toque el suelo
        assertFalse(board.LimitesVeri(piece)); // La pieza no debería poder moverse más hacia abajo
        assertEquals(18, piece.getY()); // Verifica que la pieza esté en la posición más baja
    }

    @Test
    public void testPieceSquareNoPuedeBajarMas() {
        Board board = new Board();          
        PieceSquare piece = new PieceSquare(); 

        board.addPieceBoard(piece);

        while (board.LimitesVeri(piece)) {
            piece.moveDown();
        }


        assertFalse(board.LimitesVeri(piece)); 
        assertEquals(19, piece.getY()); 
    }

    @Test
    public void testPieceTNoPuedeBajarMas() {
        Board board = new Board();          
        PieceT piece = new PieceT(); 

        board.addPieceBoard(piece);


        while (board.LimitesVeri(piece)) {
            piece.moveDown();
        }

        assertFalse(board.LimitesVeri(piece)); 
        assertEquals(18, piece.getY()); 
    }

    @Test
    public void testPieceStickNoPuedeBajarMas() {
        Board board = new Board();          
        PieceStick piece = new PieceStick(); 

        board.addPieceBoard(piece);

        while (board.LimitesVeri(piece)) {
            piece.moveDown();
        }
        
        assertFalse(board.LimitesVeri(piece));
        assertEquals(17, piece.getY()); 
    }

    @Test
    public void testPieceLLeftNoPuedeBajarMas() {
        Board board = new Board();          
        PieceLLeft piece = new PieceLLeft(); 

        board.addPieceBoard(piece);

        while (board.LimitesVeri(piece)) {
            piece.moveDown();
        }
        

        assertFalse(board.LimitesVeri(piece)); 
        assertEquals(18, piece.getY()); 
    }
    @Test
    public void testPieceLRighttNoPuedeBajarMas() {
        Board board = new Board();          
        PieceLRight piece = new PieceLRight(); 

        board.addPieceBoard(piece);

        while (board.LimitesVeri(piece)) {
            piece.moveDown();
        }
        
        assertFalse(board.LimitesVeri(piece)); 
        assertEquals(18, piece.getY()); 
    }

    @Test
    public void testPieceDogLeftNoPuedeBajarMas() {
        Board board = new Board();          
        PieceDogLeft piece = new PieceDogLeft(); 

        board.addPieceBoard(piece);

        while (board.LimitesVeri(piece)) {
            piece.moveDown();
        }
        

        assertFalse(board.LimitesVeri(piece)); 
        assertEquals(18, piece.getY()); 
    }

    @Test
    public void testPieceDogRightNoPuedeBajarMas() {
        Board board = new Board();          
        PieceDogRight piece = new PieceDogRight(); 

        board.addPieceBoard(piece);

        while (board.LimitesVeri(piece)) {
            piece.moveDown();
        }
        

        assertFalse(board.LimitesVeri(piece)); 
        assertEquals(18, piece.getY()); 
    }

    @Test
    public void testFinalJuegoLose() {

        Board board = new Board();
        PieceDogRight piece = new PieceDogRight();
        boolean puedeSeguir = true;
        board.addPieceBoard(piece);
        
        while (puedeSeguir) {

            board.addPieceBoard(piece);

            if (!board.LimitesVeri(piece)) {
                puedeSeguir = false; //corto
            } else {
                while (board.LimitesVeri(piece)) {
                    piece.moveDown();
                }
            }
        }

        assertFalse(board.checkFinalDelJuego());

    }

}