package com.tetris;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class TestTetris1 {
    // @Test
    // public void la_pieza_existe(){
    // PieceL pieceL = new PieceL();

    // assert pieceL.getPiece() != null;
    // }

    @Test
    public void la_piece_LLeft_tiene_la_forma_correcta() {
        // Crear una instancia de PieceL
        PieceLLeft pieceL = new PieceLLeft();

        // Definir la forma esperada de la pieza LLeft
        int[][] formaEsperada = {
            {0, 1, 0},
            {0, 1, 0},
            {1, 1, 0}

        };

        // Obtener la forma actual de la pieza L
        int[][] formaActual = pieceL.getShape();

        // Comparar la forma actual con la forma esperada
        assertArrayEquals(formaEsperada, formaActual);
    }

    @Test
    public void la_piece_LRight_tiene_la_forma_correcta() {
        // Crear una instancia de PieceL
        PieceLRight pieceL = new PieceLRight();

        // Definir la forma esperada de la pieza LLeft
        int[][] formaEsperada = {
            {0, 1, 0},
            {0, 1, 0},
            {0, 1, 1}
        };

        // Obtener la forma actual de la pieza L
        int[][] formaActual = pieceL.getShape();

        // Comparar la forma actual con la forma esperada
        assertArrayEquals(formaEsperada, formaActual);
    }

    @Test
    public void la_piece_DogLeft_tiene_la_forma_correcta() {
        PieceDogLeft pieceDog = new PieceDogLeft();

        int[][] formaEsperada = {
            {0, 0, 0},
            {1, 1, 0},
            {0, 1, 1}
        };

        int[][] formaActual = pieceDog.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    }

    @Test
    public void la_piece_DogRight_tiene_la_forma_correcta() {
        PieceDogRight pieceDog = new PieceDogRight();

        int[][] formaEsperada = {
            {0, 0, 0},
            {0, 1, 1},
            {1, 1, 0}
        };

        int[][] formaActual = pieceDog.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    }

    @Test
    public void la_piece_square_tiene_la_forma_correcta() {
        PieceSquare pieceSquare = new PieceSquare();

        int[][] formaEsperada = {
            {1, 1},
            {1, 1}
        };

        int[][] formaActual = pieceSquare.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    }

    @Test
    public void la_piece_t_tiene_la_forma_correcta() {
        PieceT pieceT = new PieceT();

        int[][] formaEsperada = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };

        int[][] formaActual = pieceT.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    }

    @Test
    public void la_piece_Stick_tiene_la_forma_correcta() {
        PieceStick pieceStick = new PieceStick();

        int[][] formaEsperada = {
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 }
        };

        int[][] formaActual = pieceStick.getShape();

        assertArrayEquals(formaEsperada, formaActual);
    }
}
