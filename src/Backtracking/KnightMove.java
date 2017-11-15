package Backtracking;

public class KnightMove {
    int[] x = {-2, -1, 1, 2, -2, -1, 1, 2};
    int[] y = {-1, -2, -2, -1, 1, 2, 2, 1};
    int[][] list;
    int c = 0;

    public static void main(String[] args){
        KnightMove k = new KnightMove();
        int moves = k.numOfMoves(2,3,3);
        System.out.println("valid number of moves:" + moves);
    }

    public int numOfMoves(int N, int i, int j){
        list = new int[10][10]; //board of 10
        knightMove(list, N, i-1, j-1);
        int count = 0;
        for(int m = 0; m < 10; m++){
            for(int n = 0; n< 10; n++){
                //System.out.println("execute "+(m*10+n+1)+ ": with list[i][j] " + list[m][n]);
                if(list[m][n]==1){
                    //System.out.println("check here!!!!");
                    count++;
                }
            }
        }
        //System.out.println("c is " + c);
        return count;
    }

    public void knightMove(int[][] list, int N, int i, int j){
        if(N==0){
            if(list[i][j] !=1 ){
                list[i][j] = 1;
                c++;
                //System.out.println("add knight at i = "+ 1+ ", j = "+j);
            }
        }else{
            for(int k = 0; k<8; k++){
                int I = x[k] + i;
                int J = y[k] + j;
                if(I<0 || I > 9 || J<0 || J>9){
                    continue;
                }else{
                    knightMove(list, N-1, I, J);
                    //list[I][J] = 0;
                }
            }
        }

    }
}
