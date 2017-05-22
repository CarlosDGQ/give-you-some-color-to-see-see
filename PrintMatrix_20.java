public class PrintMatrix_20 {

	/**
	 * 顺时针打印矩阵
	 * 思路：将矩阵看成由若干顺时针的圈组成，我们可以使用循环来进行打印，每次打印一个圈。
	 * 接下来，我们分析循环的结束条件；
	 * 假设矩阵的行数是rows,列数是cols，打印第一圈的时候，矩阵左上角的坐标是（0,0）
	 * 打印第二圈的时候，起始坐标是（1,1），依次类推。我们发现打印的每一圈的时候，起始坐标行标和列表
	 * 总是相同的，
	 * 对于一个5*5的矩阵来说，最后一圈的起始坐标是（2,2），而且只有一个数字，我们发现2*2 < 5.
	 * 对于一个6*6的矩阵来说，最后一圈的起始坐标是（2,2），同理，2*2 < 6.
	 * 类推，可以找到循环继续的条件是：2*start < rows && 2*start < cols.
	 * 接下来，分析如何打印每一圈：
	 * 打印一圈可以分为从左往右、从上往下、从右往左、从下往上，四个步骤；
	 * 但是在一次打印中，并不是每个步骤都需要。
	 * 从左往右一定是需要的，因为打印一圈至少有一步；
	 * 从上往下，需要满足终止行号大于起始行号；
	 * 从右往左，需要满足终止行号大于起始行号而且终止列大于起始列；
	 * 从下往上，需要满足终止行号至少比起始行号大2，而且终止列号大于起始列号。
	 * 有了以上的分析，我们就可以动手写代码了。
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		PrintMatrix.printMatrix(matrix, 4, 4);
	}

}

class PrintMatrix {
	public static void printMatrix(int[][] matrix,int rows, int cols) {//循环打印
		if(matrix == null || rows <= 0 || cols <= 0) {
			return;
		}
		int start = 0;//起始坐标
		while (start * 2 < rows && start * 2 < cols) {
			printMatrixInCircle(matrix,start,rows, cols);
			start++;
		}
	}
	public static void printMatrixInCircle(int[][] matrix, int start, int rows, int cols) {//每次打印一圈
		if(matrix == null || start < 0 || rows <= 0 || cols <= 0) {
			return;
		}
		//计算终止行号、终止列号（起始行号和列号已经知道了,就是start）
		int endRow = rows - start - 1;
		int endCol = cols - start - 1;
		//从左往右
		for(int i = start; i <= endCol; i++) {
			System.out.print(matrix[start][i]+",");
		}
		//从上往下
		if(endRow > start) {//终止行号大于起始行号
			for(int i = start  + 1; i <= endRow; i++) {
				System.out.print(matrix[i][endCol]+",");
			}
		}
		//从右往左
		if(endRow > start && endCol > start) {//终止行号大于起始行号而且终止列号大于起始列号
			for(int i = endCol - 1; i >= start; i--) {
				System.out.print(matrix[endRow][i]+",");
			}
		}
		//从下往上
		if(endRow - start >= 2 && endCol > start) {//终止行号至少比起始行号大2，而且终止列号大于起始列号
			for(int i = endRow - 1; i > start; i--) {
				System.out.print(matrix[i][start]+",");
			}
		}
	}
}
