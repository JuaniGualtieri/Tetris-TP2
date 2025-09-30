package com.tetris;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestCoberturaExtra {

    @Test
    public void testPieceStick_mueve_a_la_derecha_valido() {
        Board board = new Board();
        PieceStick stick = new PieceStick();
        stick.setX(0);
        stick.setY(0);

        board.placePiece(stick, stick.getX(), stick.getY());
        stick.moveRight();

        assertEquals(1, stick.getX());
        assertTrue(board.LimitesVeri(stick));
    }

    @Test
    public void testPieceStick_fuera_del_tablero_izquierda() {
        Board board = new Board();
        PieceStick stick = new PieceStick();
        stick.setX(-1);
        stick.setY(0);

        assertFalse(board.LimitesVeri(stick));
    }

    @Test
    public void testPieceStick_fuera_del_tablero_derecha() {
        Board board = new Board();
        PieceStick stick = new PieceStick();
        // lo posicionamos más allá del ancho
        stick.setX(board.grid[0].length);
        stick.setY(0);

        assertFalse(board.LimitesVeri(stick));
    }

    @Test
    public void testClearLinea_una_sola() {
        Board board = new Board();
        int lastRow = board.grid.length - 1;

        // llenamos la última fila completa
        for (int c = 0; c < board.grid[0].length; c++) {
            board.grid[lastRow][c] = 1;
        }

        int borradas = board.clearLinea();
        assertEquals(1, borradas);

        // ahora debería estar vacía
        for (int c = 0; c < board.grid[0].length; c++) {
            assertEquals(0, board.grid[lastRow][c]);
        }
    }

    @Test
    public void testUpdateBoard() {
        Board board = new Board();
        PieceSquare square = new PieceSquare();

        // Usamos addPieceBoard para que pieceActual quede asignado
        board.addPieceBoard(square);

        // Llamamos al updateBoard (debería borrar y volver a colocar la pieza actual)
        board.updateBoard();

        // Verificamos que haya quedado pintada la grilla en alguna posición
        boolean hayCeldaOcupada = false;
        for (int r = 0; r < board.grid.length; r++) {
            for (int c = 0; c < board.grid[0].length; c++) {
                if (board.grid[r][c] != 0) {
                    hayCeldaOcupada = true;
                    break;
                }
            }
            if (hayCeldaOcupada) break;
        }

        assertTrue("La grilla debería tener al menos una celda ocupada después de updateBoard()", hayCeldaOcupada);
    }
    
    @Test
public void testRemoveLine() {
    Board board = new Board();
    int lastRow = board.grid.length - 1;

    // Llenamos la última fila
    for (int c = 0; c < board.grid[0].length; c++) {
        board.grid[lastRow][c] = 1;
    }

    // Ponemos un bloque en la fila de arriba (para comprobar que baja)
    board.grid[lastRow - 1][0] = 2;

    // Removemos la última fila
    board.removeLine(lastRow);

    // La celda que estaba en la fila 18, columna 0 debería haber bajado a la fila 19
    assertEquals(2, board.grid[lastRow][0]);

    // Y la primera fila debería estar vacía
    for (int c = 0; c < board.grid[0].length; c++) {
        assertEquals(0, board.grid[0][c]);
    }
}



@Test
public void testCheckFinalDelJuego_incompleto() {
    Board board = new Board();

    // llenamos solo una fila (no alcanza para ganar todavía)
    int lastRow = board.grid.length - 1;
    for (int c = 0; c < board.grid[0].length; c++) {
        board.grid[lastRow][c] = 1;
    }

    boolean gano = board.checkFinalDelJuego();
    assertFalse("Todavía no debería ganar con una sola línea", gano);
}
@Test
public void testCheckFinalDelJuego_tableroVacio() {
    Board board = new Board();

    // No llenamos ninguna fila
    boolean gano = board.checkFinalDelJuego();

    assertFalse("Con tablero vacío no debería ganar", gano);
}

@Test
public void testRotateRandomPieceT() {
    PieceT piece = new PieceT();
    piece.setX(3); // en el centro
    piece.setY(0);

    int[][] original = piece.getPiece();
    piece.rotateDer();
    assertNotNull(piece.getPiece());

    piece.rotateIzq();
    assertNotNull(piece.getPiece());

    // Verificamos que la pieza siempre se mantiene como una matriz válida
    assertEquals(original.length, piece.getPiece().length);
}


@Test
public void testSetPiece_actualizaForma() {
    PieceSquare square = new PieceSquare();

    // Nueva forma manual (2x2 con distinto patrón)
    int[][] nuevaForma = {
        {1, 0},
        {0, 1}
    };

    square.setPiece(nuevaForma);

    // La forma de la pieza debe ser la nueva
    assertArrayEquals(nuevaForma, square.getPiece());
}

@Test
public void testRotateRandom_cambiaForma() {
    PieceT piece = new PieceT();
    int[][] formaInicial = piece.getShape();

    piece.rotateRandom();
    int[][] formaRotada = piece.getShape();

    // No podemos garantizar la rotación exacta (es random),
    // pero sí que sigue siendo una matriz válida y no null
    assertNotNull(formaRotada);
    assertEquals(formaInicial.length, formaRotada.length);
    assertEquals(formaInicial[0].length, formaRotada[0].length);
}

}
