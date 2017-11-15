package Medium;

public class rotateMatrix {
	public void rotate(int[][] matrix) {
        //switching i and j
        for(int i = 0; i < matrix.length; i++){
        		for(int j = i; j < matrix.length; j++){ //can't start from 0 also, will result in the same 
                swap(matrix, i , j , j, i);
            }
        }
        
        for(int l = 0, r = matrix.length-1; l <= r; l++, r--){
            for(int j = 0; j < matrix.length; j++){
                swap(matrix, j, l , j, r);
            }
        }
        
        //return matrix;
    }
    
    public void swap(int[][] matrix, int a_i, int a_j, int b_i, int b_j){
        int a = matrix[a_i][a_j];
        matrix[a_i][a_j] = matrix[b_i][b_j];
        matrix[b_i][b_j] = a;
    }
}
