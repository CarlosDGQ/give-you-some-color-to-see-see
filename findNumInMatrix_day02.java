public class FindNum {

	/**
	 * 存在一个二维数组，每一行是从左往右递增和每一列从上往下都是递增；
	 * 输入一个数，查找这个数是否在这个二维数组中；
	 * 存在返回true，不存在返回false
	 * 解题思路：首先选取右上角的数字，如果等于要查找的数字则查找结束；否则二维数组如果右上角的数字
	 * 大于要查找的数字，则右上角的数字所属的列的下面所有数字均大于要查找的数，可以去掉这一列，继续查找；
	 * 若右上角的数字小于要查找的数字，则右上角数字所在的行的左边的数字全部小于要查找的数，则去除右上角数字所属的行
	 * 继续查找。
	 * *******************每次去掉一行或一列*******************。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//方便测试，就不自己手动输入二维数组了
		int[][] data = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int num =0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要查找的数:");
		num = scanner.nextInt();
		boolean res = findNum(data, num,4,4);//行数列数手动指定
		System.out.println(res);
	}
	public static boolean findNum(int[][] data,int num,int rows,int cols){
		//判断二维数组是否为空
		if(data == null || data.length ==0 || (data.length == 1 && data[0].length == 0)) {
			return false;
		}
		if(rows > 0 && cols > 0) {
			int row = 0; //行
			int col = cols - 1; //列
			while(row <= rows - 1 && col >= 0) {
				if(data[row][col] == num) {//相等
					return true;
				} else if(data[row][col] > num) {//右上角的数大于要查找的数
					col--;
				} else {
					row++;
				}
			}
		}
		return false;
	} 
}
