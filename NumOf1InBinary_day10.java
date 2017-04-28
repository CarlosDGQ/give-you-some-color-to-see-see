public class NumOf1InBinary_day10 {

	/**
	 * 二进制中1的个数。
	 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 * 普通解法：
	 * 使用位运算分别判断每一位是否是1.
	 * 数字每次与flag进行与运算，falg的初始值是1，判断运算之后的值是否大于0；是则count++；不是则说明当前
	 * 位不是1，然后falg进行右移1位，再进行判断。因为flag一直在进行右移，所以最终会移动到int类型32位的最高位以外，此时
	 * flag的32位全部是0，即flag的值为0；说明整数的32位全部已经判断完毕，结束循环。
	 * 
	 * 让面试官眼前一亮的解法：
	 * 思路：如果一个数二进制的最后一位是1，减去1之后最后一位变为0；
	 * 如果一个二进制数的最后一位不是1，减去1之后，从右往左数遇到的第一个1变为0，这个1右边的数字全部变为1
	 * 如果减去1之后的数字与原先的数字进行&运算的话，我们会发现相比较原先的数字，就是少了从右往左遇到的第一个1.
	 * 
	 * 结论：一个数字的二进制减去1之后再与原来的数字进行&运算，会将整数从右往左数的第一个1变为0.
	 * 对于最后一位是1的数字也是满足这个规律的。
	 * 例如：1100减去1之后为1011，1011与1100进行与运算之后变为1000，相当于原数字少了一个1.
	 * =====》有多少个就进行多少次运算。最终原数字会变为0.
	 */
	public static void main(String[] args) {
		NumOf1InBinary numOf1InBinary = new NumOf1InBinary();
		System.out.println(numOf1InBinary.numOf1InBinary(-9));
	}

}
class NumOf1InBinary {
	//普通解法
	public int numOf1InBinary(int num) {
		int count = 0;//1的个数
		int flag = 1;
		while(flag != 0) {//flag一直右移，移动到最高位第32位之后，再右移就为0了，这是后int的每一位都已经进行了判断
			if((num & flag) != 0) {//&上flag不为0，说明当前位为1
				count++;
			}
			flag <<= 1;//flag每次右移一位
		}
		return count;
	}
	
	//让面试官眼前一亮的解法
	public int numOf1InBinary2(int num) {
		int count = 0;
		while(num != 0) {
			num = (num - 1) & num;
			count++;
		}
		return count;
	}
}
