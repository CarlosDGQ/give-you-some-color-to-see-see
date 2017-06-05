public class Cube_28 {

	/**
	 * 输入一个含有8个数字的数组，判断有没有可能将这8个数字放到正方体的8个顶点上，
	 * 使正方体的三组相对的面上的4个顶点的和相等。
	 * 思路：将8个数字进行全排列。判断有没有符合条件的情况。
	 */
	public static void main(String[] args) {
		Cube cube = new Cube();
		int[] arr = {1,2,3,4,5,6,7,8};
		cube.cube(arr, 0);

	}

}

class Cube{
	public void cube(int[] arr, int begin) {
		if(arr == null || arr.length == 0) {
			return;
		}
		if(begin == arr.length) {//递归终止条件
			if((arr[0] + arr[1] + //判断是否符合三组相对面顶点和相等
					arr[2] + arr[3] == arr[4] + arr[5] + 
					arr[6] + arr[7]) && (arr[0] + arr[1] + 
							arr[4] + arr[5] == arr[2] + arr[3] + 
									arr[6] + arr[7]) && (arr[0] + arr[2] + 
											arr[4] + arr[6] == arr[1] + arr[3] + 
											arr[5] + arr[7])) {
				System.out.println(Arrays.toString(arr));
			}
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			swap(arr, begin, i);
			cube(arr, begin + 1);
			swap(arr, begin, i);
		}
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
