package it.tris.scacchiera.utils;

import org.springframework.stereotype.Component;



@Component
public class TrisUtils {


	private static int [][] matrix;
	
	
	public void setPosition(Integer horizontal,Integer vertical,String player) {
		if(matrix==null)
			creaMatrix();
		if(player.equals("X")&& matrix[horizontal][vertical]==0) {
			matrix[horizontal][vertical]=1;
		}
		else if(player.equals("O")&& matrix[horizontal][vertical]==0){
			matrix[horizontal][vertical]=-1;
		}
	}

	public static int[][] getMatrix() {
		return matrix;
	}


	public static void setMatrix(int[][] matrix) {
		TrisUtils.matrix = matrix;
	}
	
	private void creaMatrix() {
		matrix = new int[3][3];
	}
	
	public int checkWinner(int result) {
		int sum;
		for(int i = 0;i<3;i++) {
			sum=0;
			for(int j=0;j<3;j++) {
				sum+=matrix[i][j];
			}
			if(sum==result) {
				return sum;
			}
		}
		for(int i = 0;i<3;i++) {
			sum=0;
			for(int j=0;j<3;j++) {
				sum+=matrix[j][i];
			}
			if(sum==result) {
				return sum;
			}
		}
		if(matrix[0][0]+matrix[1][1]+matrix[2][2]==result|| matrix[0][2]+matrix[1][1]+matrix[2][0]==result) {
			return result;
		}
		return 0;
	}
//	for(int [] a:matrix) {
//	sum=0;
//	for(int i:a) {
//		sum+=i;
//	}
//	if(sum==result) {
//		return sum;
//	}
//}
}
