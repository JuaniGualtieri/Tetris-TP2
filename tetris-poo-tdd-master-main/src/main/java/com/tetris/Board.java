package com.tetris;
import java.util.Random;

public class Board {

    private final int ancho = 10;
    private final int alto = 20; // Tablero clásico de Tetris: 10 columnas x 20 filas
    public final int[][] grid = new int[alto][ancho]; // Representación del tablero como matriz
    private Piece pieceActual;
    private final Random random = new Random();
    private int totalCleared = 0;
    private final int linesToClear = 5; // Para ganar: completar 5 líneas

    // Coloca una pieza en el tablero, en una posición aleatoria de la fila superior
    public void addPieceBoard(Piece piece) {
        int xPos = random.nextInt(ancho - piece.getShape()[0].length); // Evita que se salga del borde
        pieceActual = piece;
        placePiece(pieceActual, xPos, 0);
    }

    // Variante determinista para pruebas: coloca la pieza en una posición fija (x,y)
    public void addPieceBoard(Piece piece, int x, int y) {
        pieceActual = piece;
        placePiece(pieceActual, x, y);
    }

    // Simula la caída libre de una pieza hasta que toca el fondo o colisiona
    public void dropPiece(Piece piece) {
        while (true) {
            piece.moveDown();
            if (!LimitesVeri(piece)) { // Si salió de límites o chocó
                piece.setY(piece.getY() - 1); // Corrige la última bajada
                break;
            }
        }
        placePiece(piece, piece.getX(), piece.getY()); // La pieza queda pintada en el tablero
    }

    // Verifica si una pieza está dentro del tablero y no se superpone con otras
    public boolean LimitesVeri(Piece piece) {
        int[][] shape = piece.getPiece();
        int pieceWidth = shape[0].length;
        int pieceHeight = shape.length;
        int x = piece.getX();
        int y = piece.getY();

        // Límite del tablero (bordes y piso)
        if (x < 0 || x + pieceWidth > ancho || y < 0 || y + pieceHeight > alto) {
            return false;
        }

        // Colisión con otras piezas
        for (int i = 0; i < pieceHeight; i++) {
            for (int j = 0; j < pieceWidth; j++) {
                if (shape[i][j] != 0 && grid[y + i][x + j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Mueve hacia abajo la pieza actual (si no hay colisión)
    public boolean moveDown() {
        int currentY = pieceActual.getY();
        pieceActual.setY(currentY + 1);

        if (!LimitesVeri(pieceActual)) { // Si sale de los límites, vuelve atrás
            pieceActual.setY(currentY);
        }
        return true;
    }

    // Mueve la pieza actual a la derecha
    public boolean moveRight() {
        if (pieceActual == null) return false;

        int currentX = pieceActual.getX();
        pieceActual.setX(currentX + 1);

        if (!LimitesVeri(pieceActual)) {
            pieceActual.setX(currentX); // Revierte si choca o se sale
        }

        pieceActual.moveDown(); // Siempre desciende tras moverse
        updateBoard();
        return true;
    }

    // Mueve la pieza actual a la izquierda
    public boolean moveLeft() {
        if (pieceActual == null) return false;

        int currentX = pieceActual.getX();
        pieceActual.setX(currentX - 1);

        if (!LimitesVeri(pieceActual)) {
            pieceActual.setX(currentX);
        }

        pieceActual.moveDown();
        updateBoard();
        return true;
    }

    // Actualiza el tablero con la posición más reciente de la pieza actual
    public void updateBoard() {
        clearBoard();        
        placePiece(pieceActual, pieceActual.getX(), pieceActual.getY());
        checkFinalDelJuego();
    }

    // Limpia del tablero las celdas ocupadas por la pieza actual
    private void clearBoard() {
        int[][] shape = pieceActual.getPiece();
        int x = pieceActual.getX();
        int y = pieceActual.getY();

        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (shape[i][j] != 0) {
                    grid[y + i][x + j] = 0;
                }
            }
        }
    }

    // Dibuja la pieza en la posición indicada dentro de la grilla
    public void placePiece(Piece piece, int x, int y) {
        int[][] shape = piece.getPiece();
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (shape[i][j] != 0) {
                    grid[y + i][x + j] = shape[i][j];
                }
            }
        }
    }

    // Verifica si una fila está completa
    public boolean isLineComplete(int[] row) {
        for (int cell : row) {
            if (cell == 0) return false;
        }
        return true;
    }

    // Elimina una fila y baja todas las superiores
    public void removeLine(int row) {
        for (int i = row; i > 0; i--) {
            grid[i] = grid[i - 1];
        }
        grid[0] = new int[ancho]; // La fila superior queda vacía
    }

    // Recorre el tablero y elimina todas las filas completas
    public int clearLinea() {
        int linesCleared = 0;
        for (int row = 0; row < alto; row++) {
            if (isLineComplete(grid[row])) {
                removeLine(row);
                linesCleared++;
            }
        }
        return linesCleared;
    }

    // Chequea condición de victoria (cuando se limpian >= 5 filas)
    public boolean checkFinalDelJuego() {
        int linesCleareds = clearLinea();
        totalCleared += linesCleareds;
        return totalCleared >= linesToClear;
    }
}
