public class StringPermutation_28 {

	/**
	 * 输入一个字符串，打印该字符串中字符的所有排列。例如，输入字符串abc，则打印abc，acb，bca，bac
	 * cab，cba
	 * 思路：1.求所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符进行交换。
	 * 2.固定一个字符，求后面所有字符的排列，这时候我们仍然把后面的字符看成两部分：后面字符的第一个字符，以及这个
	 * 字符后的所有字符，然后进行相关交换。
	 */
	public static void main(String[] args) {
		String str = null;
		Scanner scanner = new Scanner(System.in);
		str = scanner.nextLine();
		if(str == null || str.length() == 0) {
			
		}
		char[] string = str.toCharArray();
		StringPermutation stringPermutation = new StringPermutation();
		ArrayList<String> list = stringPermutation.stringPermutation(string, 0);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

class StringPermutation{
	ArrayList<String> list = new ArrayList<String>();
	//str为原字符串数组，begin为当前字符串的第一个字符的索引
	public ArrayList<String>  stringPermutation(char[] str, int begin) {
		
		if(str == null) {
			return list;
		}
		if(begin == str.length) {//递归结束条件
			//System.out.println(str);
			String  resStr= new String(str);
			for(int i = 0; i < list.size(); i++) {
				if(resStr.equals(list.get(i))) {
					return list;
				}
			}
			list.add(resStr);	
		} 
		for(int i = begin; i < str.length; i++) {
			//求所有可能出现在字符串第一个位置的字符
			swap(str, begin, i);
			//递归求除去第一个字符之后的字符串的所有排列
			stringPermutation(str, begin + 1);
			//复位
			swap(str, begin, i);
		}
		return list;
	}
	
	public void swap(char[] str, int i, int j) {
		if(str[i] == str[j]) {
			return;
		}
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
}
