import java.io.*;
import java.util.*;

public class SudokuTester{
    public static void main(String[] args) throws Exception{
        Random rand = new Random();
          int max=8,min=0;

        int data[][] = new int[9][9];

        int[] num1to9 = {1,2,3,6,7,8,9,4,5};


        int r = 0;//r for row
        int c = 0;//c for column

        boolean rowBool, colBool, coordinateBool;
        int stuck = 0;

        int guessNum =0;
        // int guessNum = min + (int)(Math.random() * ((max - min) + 1));
        while(r < 9){
            while(c < 9){
                rowBool = row(data, num1to9, r, guessNum);
                colBool = col(data, num1to9, c, guessNum);
                coordinateBool = coordinate(data, num1to9, r, c, guessNum);
                if(rowBool && colBool && coordinateBool){
                    data[r][c] = num1to9[guessNum];
                    guessNum = min + (int)(Math.random() * ((max - min) + 1));
                    stuck = 0;
                    c = c + 1;
                }


               else if (stuck > 50){
                    restartRow(data, r);
                    c = 0;
                    stuck = 0;
                }


                else{
                    guessNum = guessNum + 1;
                    if(guessNum == 9){
                    guessNum = min + (int)(Math.random() * ((max - min) + 1));
                    }
                    stuck++;
                }
                print1(data);
                System.out.println("stuck# = "+stuck);
                Thread.sleep(1000);
            }
            if(c==9){ 
                r = r+1;
                c = 0;
            }
        }
    }

    public static boolean row(int[][] data, int[] num1to9, int r, int guessNum){
        for(int c = 0; c < 9; c++) {
            if(data[r][c] == num1to9[guessNum]) {
                return false;
            }
        }
        return true;
    }
    public static boolean col(int[][] data, int[] num1to9, int c, int guessNum) {
        for(int r = 0; r < 9; r++){
            if(data[r][c] == num1to9[guessNum]) return false;
        }
        return true;
    }
    public static boolean coordinate(int[][] data, int[] num1to9, int r, int c, int guessNum) {
        //groups
        int[] group1 = {data[0][0],data[0][1],data[0][2],
                        data[1][0],data[1][1],data[1][2],
                        data[2][0],data[2][1],data[2][2]};

        int[] group2 = {data[0][3],data[0][4],data[0][5],
                        data[1][3],data[1][4],data[1][5],
                        data[2][3],data[2][4],data[2][5]};

        int[] group3 = {data[0][6],data[0][7],data[0][8],
                        data[1][6],data[1][7],data[1][8],
                        data[2][6],data[2][7],data[2][8]};
            
        int[] group4 = {data[3][0],data[3][1],data[3][2],
                        data[4][0],data[4][1],data[4][2],
                        data[5][0],data[5][1],data[5][2]};
            
        int[] group5 = {data[3][3],data[3][4],data[3][5],
                        data[4][3],data[4][4],data[4][5],
                        data[5][3],data[5][4],data[5][5]};
            
        int[] group6 = {data[3][6],data[3][7],data[3][8],
                        data[4][6],data[4][7],data[4][8],
                        data[5][6],data[5][7],data[5][8]};

        int[] group7 = {data[6][0],data[6][1],data[6][2],
                        data[7][0],data[7][1],data[7][2],
                        data[8][0],data[8][1],data[8][2]};

        int[] group8 = {data[6][3],data[6][4],data[6][5],
                        data[7][3],data[7][4],data[7][5],
                        data[8][3],data[8][4],data[8][5]};

        int[] group9 = {data[6][6],data[6][7],data[6][8],
                        data[7][6],data[7][7],data[7][8],
                        data[8][6],data[8][7],data[8][8]};

        if((r==0 && c==0) || (r==0 && c==1) || (r==0 && c==2) || 
            (r==1 && c==0) || (r==1 && c==1) || (r==1 && c==2)||
            (r==2 && c==0) || (r==2 && c==1) || (r==2 && c==2)){
                for(int x = 0; x < group1.length; x++){
                    if(group1[x] == num1to9[guessNum]) return false;
                }
        }
        else if((r==0 && c==3) || (r==0 && c==4) || (r==0 && c==5) || 
            (r==1 && c==3) || (r==1 && c==4) || (r==1 && c==5)||
            (r==2 && c==3) || (r==2 && c==4) || (r==2 && c==5)){
                for(int x = 0; x < group2.length; x++){
                    if(group2[x] == num1to9[guessNum]) return false;
                }
        }
        else if((r==0 && c==6) || (r==0 && c==7) || (r==0 && c==8) || 
            (r==1 && c==6) || (r==1 && c==7) || (r==1 && c==8)||
            (r==2 && c==6) || (r==2 && c==7) || (r==2 && c==8)){
                for(int x = 0; x < group3.length; x++){
                    if(group3[x] == num1to9[guessNum]) return false;
                }
        }

        else if((r==3 && c==0) || (r==3 && c==1) || (r==3 && c==2) || 
            (r==4 && c==0) || (r==4 && c==1) || (r==4 && c==2)||
            (r==5 && c==0) || (r==5 && c==1) || (r==5 && c==2)){
                for(int x = 0; x < group4.length; x++){
                    if(group4[x] == num1to9[guessNum]) return false;
                }
        }
        else if((r==3 && c==3) || (r==3 && c==4) || (r==3 && c==5) || 
            (r==4 && c==3) || (r==4 && c==4) || (r==4 && c==5)||
            (r==5 && c==3) || (r==5 && c==4) || (r==5 && c==5)){
                for(int x = 0; x < group5.length; x++){
                    if(group5[x] == num1to9[guessNum]) return false;
                }
        } 
        else if((r==3 && c==6) || (r==3 && c==7) || (r==3 && c==8) || 
            (r==4 && c==6) || (r==4 && c==7) || (r==4 && c==8)||
            (r==5 && c==6) || (r==5 && c==7) || (r==5 && c==8)){
                for(int x = 0; x < group6.length; x++){
                    if(group6[x] == num1to9[guessNum]) return false;
                }
        }
        if((r==6 && c==0) || (r==6 && c==1) || (r==6 && c==2) || 
            (r==7 && c==0) || (r==7 && c==1) || (r==7 && c==2)||
            (r==8 && c==0) || (r==8 && c==1) || (r==8 && c==2)){
                for(int x = 0; x < group7.length; x++){
                    if(group7[x] == num1to9[guessNum]) return false;
                }
        }
        else if((r==6 && c==3) || (r==6 && c==4) || (r==6 && c==5) || 
            (r==7 && c==3) || (r==7 && c==4) || (r==7 && c==5)||
            (r==8 && c==3) || (r==8 && c==4) || (r==8 && c==5)){
                for(int x = 0; x < group8.length; x++){
                    if(group8[x] == num1to9[guessNum]) return false;
                }
        }
        else if((r==6 && c==6) || (r==6 && c==7) || (r==6 && c==8) || 
            (r==7 && c==6) || (r==7 && c==7) || (r==7 && c==8)||
            (r==8 && c==6) || (r==8 && c==7) || (r==8 && c==8)){
                for(int x = 0; x < group9.length; x++){
                    if(group9[x] == num1to9[guessNum]) return false;
                }
        }  
        return true;
    }

    public static void restartRow(int[][] data, int r) {
        for (int c = 0; c < 9; c++){
            data[r][c] = 0;
        }
    }

    public static void print1(int data[][]) {
        for(int i = 0; i < 9; i++) {
            for(int j= 0; j < 9; j++) {
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }
    }
}