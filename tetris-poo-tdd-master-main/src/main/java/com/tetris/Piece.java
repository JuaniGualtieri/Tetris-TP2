package com.tetris;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

//test
public class Piece{
    
    public int[][] piece;
    public int x;
    public int y;
    private ClockDemo clock;
    private Timer timer;
    public int[][] shape;
    private final Random random_rot = new Random();
    
    
    public Piece() {
        //----> falta probar
        //this.timer = new Timer();
        //this.clock = new ClockDemo();
        //startTimer();
    }

    public Piece(int[][] piece){
        this.piece = piece;
        this.timer = new Timer();
        this.clock = new ClockDemo();
        startTimer();
    }

    public void setPiece(int [][] piece){
        this.piece = piece;
    }

    public int[][] getPiece(){
        return piece; 
    }
    
    public int[][] getShape() {
        return getPiece(); // O simplemente return piece;
    }
    

    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return x; 
    }

    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return y; 
    }

    public void rotateRandom() {
        
        int num = random_rot.nextInt(2);
    
        if (num == 1) {
            rotateIzq();
        } else {
            rotateDer();
        }
    }

    //rotacion sentido horario
    public void rotateIzq() {
        int n = piece.length;
        int[][] rotatedPiece = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedPiece[n - 1 - j][i] = piece[i][j]; //al reves!
            }
        }
        
        this.piece = rotatedPiece;
    }

    public void rotateDer() {
        int n = piece.length;
        int[][] rotatedPiece = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedPiece[j][n - 1 - i] = piece[i][j];
            }
        }
        
        this.piece = rotatedPiece;
    }

    public void moveDown() {
        this.y += 1;  //pieza 1 pos abajo
    }

    public void moveRight() {
        this.x += 1;  
    }

    public void moveLeft() {
        this.x -= 1;  
    }

    public void startTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                clock.tic();  // +1 seg
                moveDown();   // pieza 1 pos abajo
            }
        }, 0, 2000);  // periodo de 1seg
    }

    //stop para el timer una vez que finaliza
    public void stopTimer() {
        timer.cancel();
    }
    
}


