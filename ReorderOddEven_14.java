public class ReorderOddEven_14 {

	/**
	 * 调整一个数组，使奇数位于偶数的前面
	 * 思路1：设置两个指针，分别指向第一个元素和最后一个元素
	 * 从前往后找到一个偶数，第一个指针指向它；从后往前找到一个奇数，第二个指针指向他。交换。
	 * 直到两个指针重合。
	 * 思路2：使程序具有可扩展性。如果要求将所有负数放在所有的非负数之前或者分成两部分将能被3整除的
	 *		放在不能被3整除的前面，这时我们发现只是判断条件不同，大体的框架是相同的。
	 *		可以使用模板模式。将条件判断抽取出来，这样程序的可扩展性就大大提高了。
	 *
	 *前面两种解法都不保证元素的相对顺序，如果需要保证元素的相对顺序可以使用下面的思路。
	 *思路3：首先创建一个新的数组,然后算出奇数的个数，计算出偶数在新数组中开始位置.分别从奇数和偶数开始的位置填充
	 *新数组。
	 */
	public static void main(String[] args) {
		int[] arr = {1,24,5,74,3,5};
		//ReorderOddEven.reorderOddEven_1(arr);
		arr = ReorderOddEven.reorderOddEven_3(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

class ReorderOddEven {
	public static void  reorderOddEven_1(int[] arr) {
		if(arr == null || arr.length == 0) {//空数组直接返回
			return;
		}
		
		int begin = 0;
		int end = arr.length - 1;
		
		while(begin < end) {
			//从前往后找到一个偶数
			while (begin != arr.length - 1 && (arr[begin] & 0x1) != 0) {
				begin++;
			}
			//从后往前找到一个奇数
			while (end != 0 && (arr[end] & 0x1) == 0) {
				end--;
			}
			
			if(begin < end) {
				int temp = arr[begin];
				arr[begin] = arr[end];
				arr[end] = temp;
				begin++;
				end--;
			}
		}
	}
	
	//将条件单独抽出来，这样程序的可扩展性就大大的提高了
	public static boolean isEven(int value) {
		return (value & 0x1) == 0;//如果是偶数返回true
	}
	
	public static void  reorderOddEven_2(int[] arr) {
		if(arr == null || arr.length == 0) {//空数组直接返回
			return ;
		}
		
		int begin = 0;
		int end = arr.length - 1;
		
		while(begin < end) {
			//从前往后找到一个偶数
			while (begin != arr.length - 1 && isEven(arr[begin])) {
				begin++;
			}
			//从后往前找到一个奇数
			while (end != 0 && isEven(arr[end])) {
				end--;
			}
			
			if(begin < end) {
				int temp = arr[begin];
				arr[begin] = arr[end];
				arr[end] = temp;
				begin++;
				end--;
			}
		}
	}
	
	public static int[] reorderOddEven_3(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		
		int[] newArr = new int[arr.length];
		
		int oddCount = 0;//奇数个数
		int oddStart = 0;
		int evenStart = 0;//新数组中偶数开始填充的位置
		for(int i =0; i < arr.length; i++) {//计算数组中奇数的个数
			if((arr[i] & 0x01) == 1) {
				oddCount++;
			}
		}
		evenStart = oddCount;//新数组中偶数开始的位置
		for(int i = 0; i < arr.length; i++) {
			if((arr[i] & 0x01) == 1) {//奇数放入新数组
				newArr[oddStart++] = arr[i];
			} else {//偶数放入新数组
				newArr[evenStart++] = arr[i];
			}
		}
		return newArr;
	}
}
