public class SingleTon {

	/**
	 * 设计一个类，使该类只有一个实例
	 */
	public static void main(String[] args) {
		

	}

}
//恶汉单例设计模式,线程安全
class SingleTon1 {
	//1.私有化构造方法
	private SingleTon1() {}
	//2.生成一个该类的实例，使用private static修饰
	private static SingleTon1 siTon1 = new SingleTon1();
	//3.定义一个公共静态的方法返回该实例给外部使用
	public static SingleTon1 getInstance() {
		return siTon1;
	}
}
//懒汉单例设计模式，非线程安全
class SingleTon2 {
	//1.私有化构造方法
	private SingleTon2() {}
	//2.定义该类的一个private static的引用类型的定义,不指向该类实例
	private static SingleTon2 siTon2 = null;
	//3.定义一个公共静态的方法返回该类的实例给外部使用
	public static SingleTon2 getInstance() {
		if(siTon2 == null) {//先判断实例是否存在，不存在才创建，有点懒
			siTon2 = new SingleTon2();
		}
		return siTon2;
	}
}

//解决懒汉设计模式的线程安全问题，使用同步代码块解决
class SingleTon3 {
	//1.私有化构造方法
	private SingleTon3() {}
	//2.定义该类一个private static 的引用类型的变量,不指向任何对象
	private static SingleTon3 sinTon3 = null;
	//定义一个public static 方法，返回该类的实例给外部使用
	public static SingleTon3 getInstance() {
		if (sinTon3 == null) {
			//如果sinTon3实例没有创建
			synchronized("锁") {//加最简单的锁（字符串）
				if(sinTon3 == null) {
					sinTon3 = new SingleTon3();
				}
			}
		}
		return sinTon3;
	}
}
