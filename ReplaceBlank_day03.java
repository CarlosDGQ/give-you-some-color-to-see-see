public class ReplaceBlank_03 {

	/**
	 * 实现一个函数将字符串的每个空格替换为%20
	 * 例如输入"we are happy.",则输出“we%20are%20happy.”
	 * 
	 * 1.使用String的函数replaceAll(),so easy。
	 * 2.题目说要自己实现一个函数。哟，有点意思。
	 * 解题思路：从前往后替换，时间复杂度为O(n^2),不好。
	 * 换一种，从后往前进行替换。
	 * 
	 * 注意：str.toCharArray() 返回一个新的字符数组，长度为字符串的长度。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "we are happy.";
		//String str2 = str.replaceAll(" ", "%20");
		//System.out.println(str2);
		if(str == null || str == "") {//注意边界条件，如果str为nll或者空字符串都需要进行处理
			return;
		}
		char[] data = str.toCharArray();//将字符串转换为字符串数组
		char[] newData = replaceBlank(data);
		System.out.println(newData);
	}
	public static char[] replaceBlank(char data[]) {
		System.out.println(data.length);
		if(data == null || data.length == 0) {//字符数组为空直接返回
			return null;
		}
		//1.首先计算出新数组的长度
		int numOfBlank = 0; //空格数
		int newDataLength = 0;//新数组的长度
		int originalLength = data.length;//旧数组的长度
		for(int i = 0; i < originalLength; i++) {
			if(data[i] == ' ') {
				numOfBlank++;
			}
		}
		newDataLength = originalLength + numOfBlank * 2;//每一个空格用%20三个字符代替，所以*2
		//开辟新数组的空间或者使用Arrays工具类的copyof方法
		//char[] newData = new char[newDataLength];
		//使用Arrays工具类
		char[] newData = Arrays.copyOf(data, newDataLength);//也会开辟一个新数组
		System.out.println(originalLength);
		System.out.println(newDataLength);
		//2.从后往前替换
		/*
		 * 使用两个指针，一个指向新数组的最后，一个指向数组的最前面。
		 * 只不过java中没有指针的概念，使用数组的下标实现。
		 * 
		 * */
		for(int i = originalLength - 1; i >= 0; i--) {//从旧数组的最后一位开始遍历
			if (data[i] == ' ') {//是空格直接进行替换
				newData[--newDataLength] = '0';
				newData[--newDataLength] = '2';
				newData[--newDataLength] = '%';
			} else {//不是空格，直接复制
				newData[--newDataLength] = data[i];
			}
		}
		return newData;
	}

}
