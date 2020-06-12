package com.khanh.algorithm.sort;

import java.util.Scanner;
        import java.util.Arrays;
        import java.util.concurrent.ThreadLocalRandom;

public class MatrixDiagonalSum {
    private int sumL = 0;
    private int sumR = 0;
    private final int row;
    private final int col;
    public MatrixDiagonalSum(int row, int col){
        this.row  = row;
        this.col = col;
    }

    private void fillMatrix(int[][] matrix){
        //Random rand = new Random();
        for (int r = 0; r < this.row; r++) {
            for(int c = 0; c < this.col; c++){
                matrix[r][c] = ThreadLocalRandom.current().nextInt(1,10); //Generate random number from range 1-10
            }
        }
    }

    public int[][] matrixInit(){
        int [][] matrix = new int[this.row][this.col];
        fillMatrix(matrix);

        return matrix;

    }

    public boolean isMatrixPerfect(){
        return this.row == this.col;
    }

    private void matrixDiagonalSum(int[][] matrix){
        //this.sum = 0;
        for (int r = 0; r < this.row; r++) {
            for(int c = 0; c < this.col; c++){
                if (r == c) {
                    System.out.println("ElementLeft: " + matrix[r][c]);
                    this.sumL += matrix[r][c];
                }
                if (r+c == this.row - 1){
                    System.out.println("ElementRight: " + matrix[r][c]);
                    this.sumR += matrix[r][c];
                }
            }
        }
    }

    public void calculateSum(int[][] matrix){
        matrixDiagonalSum(matrix);
    }

    public int getMatrixDiaSumLeft(){
        return this.sumL;
    }

    public int getMatrixDiaSumRight(){
        return this.sumR;
    }

    public int getSumDiff(){
        return Math.abs(this.sumL - this.sumR);
    }

    public static void print2D(int[][] mat)
    {
        System.out.println("Matrix");
        // Loop through all rows
        for (int[] row : mat)

            // converting each row as string
            // and then printing in a separate line

            System.out.println(Arrays.toString(row));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input row of matrix: ");
        int row = sc.nextInt();
        System.out.print("Input column of matrix: ");
        int col = sc.nextInt();

        //Create class instance
        MatrixDiagonalSum mSum = new MatrixDiagonalSum(row,col);

        //Create matrix
        int[][] matrix = mSum.matrixInit();

        //Print matrix
        print2D(matrix);

//        00,01,02,03,04
//        10,11,12,13,14
//        20,21,22,23,24
//        30,31,32,33,34
//        40,41,42,43,44



        //Check if the matrix is perfect
        if(mSum.isMatrixPerfect()){
            //mSum.matrixDiagonalSum(matrix);
            //Calculate diagonal sum
            mSum.calculateSum(matrix);
            //Get sum value
            int sumL = mSum.getMatrixDiaSumLeft();
            int sumR = mSum.getMatrixDiaSumRight();
            int diff = mSum.getSumDiff();
            System.out.print("SumL: " + sumL + "\n");
            System.out.print("SumR: " + sumR + "\n");
            System.out.print("Diff: " + diff + "\n");
        }
        else{
            System.out.println("Matrix is not perfect.");
        }
    }
}