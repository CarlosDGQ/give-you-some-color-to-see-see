public class MinNumberInRotatedArray_day08 {

	/**
	 * 求旋转数组中的最小数字。
	 * 旋转数组：将一个数组开始的若干位元素搬到数组的末尾，称之为数组的旋转。
	 * 输入一个递增排序的数组，输出旋转数组的最小数字。例如{3，4，5，1，2}为{1，2，3，4，5}
	 * 的一个旋转，该数组的最小数字为1.
	 * 
	 * 通过观察：我们可以看到最小的数字一定位于后面的递增子数组中，而且是第一个。
	 * 数组的第一个元素一定是大于等于最后一个元素。（有特例，单独考虑）
	 * 
	 * 思路：数组是基本有序的，可以使用折半查找法来查找数组的最小数字。
	 * 首先和折半查找法一样使用两个指针分别指向数组的开头和结尾，接着我们找到数组的中间元素，
	 * 如果它比第一个指针指向的元素大或者相等，则中间元素位于前面的递增子数组中，我们可以将第一个指针指向中间元素；
	 * 继续进行查找；如果中间元素比第二个指针指向的元素小或者相等，则中间元素位于后面的递增数组之中；我们可以将第二个指针
	 * 指向中间元素，继续查找。
	 * 当两个指针相邻的时候，说明查找已经结束，而且第二个指针指向的元素就是最小元素（最小的元素一定位于第二个递增数组之中）。
	 * 
	 * 考虑特例：
	 * 1.如果将前面的0个数字搬到最后面，及排序数组本身，这仍然是一个数组的旋转。
	 * 所以如发现数组的第一个元素比最后一个元素小，直接返回数组的第一个数字即可。
	 * 2.如果第一个指针指向的元素、第二个指针指向的元素、中间元素相等；那么无法判断中间元素是属于前面的递增数组还是后面的递增数组
	 * 此时只能使用顺序查找。
	 */
	public static void main(String[] args) {
		int[] data = {3,4,5,1,2};
		MinNumberInRotatedArray minNumberInRotatedArray = new MinNumberInRotatedArray();
		int min = minNumberInRotatedArray.min(data);
		System.out.println(min);

	}

}

class MinNumberInRotatedArray{
	public int min(int[] data) {
		if(data == null || data.length == 0) {
			throw new RuntimeException("data is null"); //抛出运行时异常
		}
		
		int low = 0;
		int height = data.length - 1;
		if(data[low] < data[height]) {//特例1
			return data[low];
		}
		while(low + 1 != height) {
			int mid = (low + height) / 2;
			if(data[mid] == data[low] && data[low] == data[height]) {//特例2
				return findMin(data);
			}
			if(data[mid] >= data[low]) {
				low = mid;
			} else if(data[mid] <= data[height]){
				height = mid;
			}
		}
		return data[height];
	}
	
	public int findMin(int[] data) {//顺序查找
		int min = data[0];
		for(int i = 0; i < data.length; i++) {
			if(min > data[i]) {
				min = data[i];
			}
		}
		return min;
	}
}
