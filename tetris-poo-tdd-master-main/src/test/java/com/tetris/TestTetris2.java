package com.tetris;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

//import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestTetris2 {
    @Test
    public void girar_palo_izq() {
        PieceStick pieceStick = new PieceStick();

        pieceStick.rotateIzq();

        int[][] formaEsperada = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 1, 1, 1}
        };

        int[][] formaActual = pieceStick.getShape();

        assertArrayEquals(formaEsperada, formaActual);

    }

    @Test
    public void girar_palo_Der() {
        PieceStick pieceStick = new PieceStick();

        pieceStick.rotateDer();

        int[][] formaEsperada = {
            {1, 1, 1, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        int[][] formaActual = pieceStick.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    } 

    @Test
    public void girar_palo_Der_dos_veces() {
        PieceStick pieceStick = new PieceStick();

        pieceStick.rotateDer();
        pieceStick.rotateDer();

        int[][] formaEsperada = {
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1}
        };

        int[][] formaActual = pieceStick.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    } 

    @Test
    public void girar_cubo_prueba() {
        PieceSquare pieceSquare = new PieceSquare();

        pieceSquare.rotateDer();

        int[][] formaEsperada = {
            {1, 1},
            {1, 1}
        };

        int[][] formaActual = pieceSquare.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    } 

    @Test
    public void girar_DogRight_derecha(){
        PieceDogRight pieceDogRight = new PieceDogRight();

        pieceDogRight.rotateDer();

        int[][] formaEsperada = {
            {1, 0, 0},
            {1, 1, 0},
            {0, 1, 0}
        };

        int[][] formaActual = pieceDogRight.getShape();

        assertArrayEquals(formaActual, formaEsperada);
    }

    @Test
    public void girar_DogRight_izquierda(){
        PieceDogRight pieceDogRight = new PieceDogRight();

        pieceDogRight.rotateIzq();

        int[][] formaEsperada = {
            {0, 1, 0},
            {0, 1, 1},
            {0, 0, 1}
        };

        int[][] formaActual = pieceDogRight.getShape();

        assertArrayEquals(formaActual, formaEsperada);
    }

    @Test
    public void girar_DogLeft_derecha(){
        PieceDogLeft pieceDogLeft = new PieceDogLeft();

        pieceDogLeft.rotateDer();

        int[][] formaEsperada = {
            {0, 1, 0},
            {1, 1, 0},
            {1, 0, 0}
        };

        int[][] formaActual = pieceDogLeft.getShape();

        assertArrayEquals(formaActual, formaEsperada);
    }

    @Test
    public void girar_DogLeft_izquierda(){
        PieceDogLeft pieceDogLeft = new PieceDogLeft();

        pieceDogLeft.rotateIzq();

        int[][] formaEsperada = {
            {0, 0, 1},
            {0, 1, 1},
            {0, 1, 0}
        };

        int[][] formaActual = pieceDogLeft.getShape();

        assertArrayEquals(formaActual, formaEsperada);
    }

    @Test
    public void girar_piezaT_derecha(){
        PieceT pieceT = new PieceT();

        pieceT.rotateDer();

        int[][] formaEsperada = {
            {1, 0, 0},
            {1, 1, 0},
            {1, 0, 0}
        };

        int [][] formaActual = pieceT.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    }

    @Test
    public void girar_piezaT_izquierda(){
        PieceT pieceT = new PieceT();

        pieceT.rotateIzq();

        int[][] formaEsperada = {
            {0, 0, 1},
            {0, 1, 1},
            {0, 0, 1}
        };

        int [][] formaActual = pieceT.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    }

    @Test
    public void girar_piezalLeft_derecha(){
        PieceLLeft piecelLeft = new PieceLLeft();

        piecelLeft.rotateDer();

        int[][] formaEsperada = {
            {1, 0, 0},
            {1, 1, 1},
            {0, 0, 0}
        };

        int [][] formaActual = piecelLeft.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    }

    @Test
    public void girar_piezalLeft_izquierda(){
        PieceLLeft piecelLeft = new PieceLLeft();

        piecelLeft.rotateIzq();

        int[][] formaEsperada = {
            {0, 0, 0},
            {1, 1, 1},
            {0, 0, 1}
        };

        int [][] formaActual = piecelLeft.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    }

    @Test
    public void girar_piezalDer_derecha(){
        PieceLRight pieceLRight = new PieceLRight();

        pieceLRight.rotateDer();

        int[][] formaEsperada = {
            {0, 0, 0},
            {1, 1, 1},
            {1, 0, 0}
        };

        int [][] formaActual = pieceLRight.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    }

    @Test
    public void girar_piezalDer_izq(){
        PieceLRight pieceLRight = new PieceLRight();

        pieceLRight.rotateIzq();

        int[][] formaEsperada = {
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };

        int [][] formaActual = pieceLRight.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    }

    @Test
    public void girar_piezaT_random(){
        PieceT pieceT = new PieceT();
        Board board = new Board();

        board.addPieceBoard(pieceT); 

        pieceT.rotateRandom(); 

        assertTrue(board.LimitesVeri(pieceT));
    }

    @Test
    public void girar_piezaDogRight_random(){
        PieceDogRight piece = new PieceDogRight();
        Board board = new Board();

        board.addPieceBoard(piece); 

        piece.rotateRandom(); 

        assertTrue(board.LimitesVeri(piece));
    }

    @Test
    public void girar_piezaLleft_random(){
        PieceLLeft piece = new PieceLLeft();
        Board board = new Board();

        board.addPieceBoard(piece); 

        piece.rotateRandom(); 

        assertTrue(board.LimitesVeri(piece));
    }

    @Test
    public void girar_piezaLRight_random(){
        PieceLRight piece = new PieceLRight();
        Board board = new Board();

        board.addPieceBoard(piece); 

        piece.rotateRandom(); 

        assertTrue(board.LimitesVeri(piece));
    }

    @Test
    public void girar_piezaSquare_random(){
        PieceSquare piece = new PieceSquare();
        Board board = new Board();

        board.addPieceBoard(piece); 

        piece.rotateRandom(); 

        assertTrue(board.LimitesVeri(piece));
    }

    @Test
    public void girar_piezaStick_random(){
        PieceStick piece = new PieceStick();
        Board board = new Board();

        board.addPieceBoard(piece); 

        piece.rotateRandom(); 

        assertTrue(board.LimitesVeri(piece));
    }

    @Test
    public void girar_2_veces_piezaStick_random(){
        PieceStick piece = new PieceStick();
        Board board = new Board();

        board.addPieceBoard(piece); 

        piece.rotateRandom(); 
        piece.rotateRandom(); 

        assertTrue(board.LimitesVeri(piece));
    }





}
