package www.bit.com;

import java.util.Stack;

public class Cross {
	
	/**
	 * 每次运输，船上的人数都有可能是下面的五种情况：（不管是从左岸到右岸还是右岸到左岸）
	 * 1.1个传教士，0个野人
	 * 2.0个传教士，1野人
	 * 3.1个传教士，1个野人
	 * 4.2个传教士，0个野人
	 * 5.0个传教士，2个野人
	 */
	public static Rule[] rule = {new Rule(1, 0), new Rule(0, 1), new Rule(1, 1), new Rule(2, 0), new Rule(0, 2)};
	public static int NUM = 0;//记录解法的种类
	
	public static void main(String[] args) {
		Stack<Node> open = new Stack<Node>();//将左岸经历过的每一个状态都记录进open中，在选择一次运输规则Rule进行一次运输的时候，
												//需要判断，左岸的状态是否在以前已经经历过，如果经历过，则换运输规则Rule
	    Node node = new Node(3,3,1);//初始状态
	    open.add(node);
	    transport(open,node);
	}
	
	//运输，再进行一次运输前，判断是否已经达到最终状态，没有则进行运输
	public static void transport(Stack<Node> open,Node node) {
	    if(node.m == 0 && node.c == 0 && node.b == 0) {//已经全部到达右岸，输出结果
	        printRes(open);
	    }
	    else {
	    	crossRiver(open,node);
	    }
	}
	
	//深度优先搜索加回溯，进行过河操作
	public static void crossRiver(Stack<Node> open,Node newnode) {
	    int i = 0;
	    boolean flag = false;
	    Node node = new Node();//用于记录左岸的状态
	    node.m = newnode.m;
	    node.c = newnode.c;
	    node.b = newnode.b;
	    if(node.b == 1) {//船在左岸
	        for(i = 0;i < 5;i++) {//分别考虑五种类型的运输Rule
	            node.m = newnode.m - rule[i].mm;//左岸还剩多少传教士
	            node.c = newnode.c - rule[i].cc;//左岸还剩多少野人
	            node.b = 0;//船到了右岸
	            flag = isLegal(open,node);//判断是否符合规则（左右两岸的传教士不会被吃掉，以及左岸的状态以前不能出现过）若不符合，直接开始下一种运输方案
	            if(flag) {//flag为true,表示传教士不会被吃掉，且左岸的目前的状态以前没有出现过(两岸需要同时考虑)
	                open.push(node);//将上船之后的当前左岸状态加入open结果集中
	                transport(open,node);//每一次运输完成之后，判断是否完成，没有则需要继续运输
	                if(!open.isEmpty()) {//在打印一条可行路径之后进行回溯，每次向上一层
	                	open.pop();//回溯，每次向上一层（脑海中要有树），然后分别考察当前运输方案的后面，（根据i的值）是否有满足条件的方案
	                }
	            }
	        }
	    }
	    else {//船在右岸，船不可能自己回来，需要考虑到达右岸之后，从右岸回到左岸的情况
	        for(i = 0;i < 5;i++) {//分别考虑五种类型的运输Rule
	            node.m = newnode.m + rule[i].mm;//现在是船回到左岸，node记录左岸状态，船不可能自己回来
	            node.c = newnode.c + rule[i].cc;//所以是加法
	            node.b = 1;//船在左岸
	            flag = isLegal(open,node);
	            if(flag) {              
	            	open.push(node);
	            	transport(open,node);//每一次运输完成之后，判断是否完成，没有则需要继续运输
	                if(!open.isEmpty()) {
	                	open.pop();//回溯
	                }
	            }
	        }
	    }
	}
	
	//判断在进行一次运输之后，判断传教士是否会被吃掉
	public static boolean isLegal(Stack<Node> open,Node newnode) { 
		boolean res = isVisited(open,newnode);//判断左岸的状态以前是否已经出现过，避免出现死循环（运过去之后又全部运了回来）
	    if(res == false) {//若左岸的状态在以前没有经历过，判断它是否符合相关约束条件
	        if(newnode.m >= 0 && newnode.m <= 3 && newnode.c >= 0 && newnode.c <= 3) {
	            if(newnode.m == 0 || newnode.m ==3 || newnode.m == newnode.c) {//传教士不会被吃掉的情况，左岸右岸都需要考虑
	                return true;
	            }
	        }
	    }
	    return false;//左岸的状态以前已经出现过，不合法，直接开始下一种运输方案
	}
	
	//在进行一次运输之后，判断左岸目前的状态是否已经经历过。newnode表示左岸目前的状态
	public static boolean isVisited(Stack<Node> open,Node newnode) {
	    int i = 0;
	    if(!open.isEmpty()) {
	        for(i = 0;i != open.size() - 1;i++) {
	            if(newnode.m == open.get(i).m && newnode.c == open.get(i).c
	            		&& newnode.b == open.get(i).b) {
	                return true;//1表示目前左岸的状态以前已经存在过，说明运过去之后，又全部运了回来。会出现死循环
	            }    
	        }
	    }
	    return false;
	}

	//打印结果
	public static void printRes(Stack<Node> open) {
	    int i;
	    System.out.println("解法"+ ++NUM +":");
	    System.out.println("***************************************************************************************");
	    if(!open.isEmpty()) {
	    	System.out.println("左岸传教士人数\t"+"左岸野人人数\t"+"船在哪边（1表示左边，0表示右边）\t"+"\t详细步骤\t");
	        for(i = 0;i <= open.size() - 2;i++) {
	        	Node node = open.get(i);//左岸当前状态
	        	Node node2 = open.get(i + 1);//左岸下一状态
	            System.out.print(node.m + "\t\t" + node.c + "\t\t\t" + node.b);
	            if(open.get(i).b == 1) {//船在左岸
	            	int m = node.m - node2.m;//船上装的传教士数
		        	int c = node.c - node2.c;//船上装的野人数
	            	System.out.println("\t\t\t船往右岸开"+",船上装"+ c +"野人"+",装"+ m +"传教士"); 
	            	
	        	} else {
	        		int m = node2.m - node.m;//船上装的传教士数
		        	int c = node2.c - node.c;//船上装的野人数
	        		System.out.println("\t\t\t船往左岸开"+",船上装"+ c +"野人"+",装"+ m +"传教士"); 
	        	}
	        }
	        Node node3 = open.get(open.size() - 1);
	        System.out.println(node3.m + "\t\t" + node3.c + "\t\t\t" + node3.b+"\t\t\t完成");
	    }
	    System.out.println("***************************************************************************************");
	    System.out.println();
	}
}

//Node记录左岸的情况，只需要记录一边的情况即可
public class Node {
	int m;//传教士
    int c;//野人
    int b;//船在岸的哪边，假设1表示在左岸，初始状态
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	} 
	public Node(int m, int c, int b) {
		this.m = m;
		this.c = c;
		this.b = b;
	}
	public Node() {
	}
}

public class Rule {
	int mm;//每次运输的传教士数
	int cc;//每次运输的野人数
	public int getMm() {
		return mm;
	}
	public void setMm(int mm) {
		this.mm = mm;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public Rule(int mm, int cc) {
		this.mm = mm;
		this.cc = cc;
	}
}


