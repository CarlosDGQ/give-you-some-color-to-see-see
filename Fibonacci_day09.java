/**
 * 斐波那契数列
 * 思路：使用传统的递归解决效率太低
 * 使用循环。
 * 首先计算f(0)和f(1),然后计算f(2),再根据
 * f(1)和f(2)计算f(3)....依次类推
 * 
 * 扩展1：一只青蛙依次可以跳上1级台阶或者2级台阶。求该青蛙跳上n级台阶有多少种跳法。
 * 思路：我们从简单情况开始一步步进行分析；如果是跳上1级台阶，很显然只有一种跳法；
 * 如果是跳上2级台阶，可以是1,1和2；两种跳法；3级台阶有1，1，1和1,2，和2,1，共三种跳法；
 * 跳上4级台阶有1，1，1，1和1，2,1，和2,1,1和1，1，2，和2,2，共五种跳法，可以发现
 * 跳法的种树很符合斐波那契数列的规律。可以利用斐波那契数列解决这个问题。
 * 
 * 
 * 扩展2：如果青蛙可以跳上1~n级台阶任何一种，又有多少种方法？
 * 思路：我们从简单情况开始一步步进行分析；如果是跳上1级台阶，很显然只有一种跳法；如果是跳上2级台阶，可以是1,1和2；两种跳法；
 * 3级台阶有1，1，1和1,2，和2,1和3；共四种跳法；4级台阶有1，1，1，1和1，2,1，和2,1,1和1，1，2，和2,2，和4和1,3和3,1
 * 共8种方法；若跳上五级台阶有1，1，1，1，1和1,2,1,1和1,1,2,1，和2,1,1,1和1，1，1，2,和2,3,和3,2和1，1，3和1，3，1和
 * 3，1，1和1,4,和4,1和5和2,1,2,2，2，1,1，2，2共有16中跳法；。。。。
 * 依次类推发现第n接台阶方法的种类数是2的n-1次方。
 
 一句话解决：每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)中情况
 * */
public class Fib_day09 {
	public static void main(String[] args) {
		Fab fab = new Fab();
		JumpNum jumpNum = new JumpNum();
		JumpDif jumpDif = new JumpDif();
		System.out.println(jumpDif.jump(5));
		System.out.println(jumpNum.jumpNum(4));
		System.out.println(fab.fab(7));
	}
}

//循环法解决斐波那契数列问题
class Fab {
	public int fab(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		int fabOne = 0;
		int fabTwo = 1;
		int fabN = 0;//要求的第n项
		for(int i = 2; i <= n; i++) {
			fabN = fabOne + fabTwo;
			fabOne = fabTwo;
			fabTwo = fabN;
		}
		return fabN;
	}
}

//斐波那契数列解决青蛙跳级的问题
class JumpNum {
	public int jumpNum(int n) {
		if(n == 1 || n == 2) {//跳上1级或者2级台阶，有n种，n为1或2
			return n;
		}
		int numOne = 1;
		int numTwo = 2;
		int count = 0;//种类数
		for(int i = 3; i <= n; i++) {
			count = numOne + numTwo;
			numOne = numTwo;
			numTwo = count;
		}
		return count;
	}
}

//变态跳台阶
class JumpDif {
	public int jump(int n) {
		return (int) Math.pow(2, n - 1);
	}
}
