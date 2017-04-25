public class QuickSort_day07 {

	/**
	 * 快速排序的实现
	 * 最重要的是选择基准点将数据划分。partition函数
	 */
	public static void main(String[] args) {
		int[] data = {6,3,7,4,1};
		QuickSort quickSort = new QuickSort();
		quickSort.QuickSort(data, 0, data.length - 1);
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
			
		}
	}

}

class QuickSort {
	/**
	 * data为要排序的数组；
	 * start 为当前数组的起始位置
	 * end为当前数组的终止位置
	 * */
	//以基准点将数组划分为两个部分,在基准点前面的数字比基准点的数字小，在基准点后面的数字比基准点的数字大
	/*** 划分思路：选择第一个数为基准点；
	 * 两个指针start和end（这样好理解）分别指向数组的头和尾；
	 * 从后往前选择一个比基准点小的数和基准点进行交换，end--；
	 * 从前往后选择一个比基准点数大的数和当前的基准点进行交换，start++。
	 * 最终start和end一定会相等。
	 */
	public int partition(int[] data, int start, int end) {
		int key = data[start];//选择当前数组的第一个数作为基准点
		while(start < end) {//最终start和end一定会碰到一起
			//从后面选择一个比key小的数和key交换
			while (end > start && data[end] >= key) {
				end--;
			}
			if(end != start) {
				int temp = data[end];
				data[end] = data[start];
				data[start] = temp;
			}
			//从前往后选择一个比key大的值和key交换
			while (start < end && data[start] < key) {
				start++;
			}
			if(end != start) {
				int temp = data[start];
				data[start] = data[end];
				data[end] = temp;
			}
		}
		//将key放入最终的位置
		data[start] = key;
		return start;//最终start和end相等，返回哪个都行（基准点最终的位置）
	}
	
	//在划分完毕之后，我们发现在基准点的左边和右边执行相同的操作即可完成排序。想到递归
	public  void QuickSort(int[] data, int start,int end) {
		if(data == null || data.length == 0) {//数组为空直接返回
			return;
		}
		if(start >= end) {//递归结束条件,注意一定要加上大于，否则报错
			return;
		}
		//首先划分
		int index = partition(data, start, end);
		//左边进行相同的操作
		QuickSort(data, start, index - 1);
		//右边进行相同的操作
		QuickSort(data, index + 1, end);
	}
}
