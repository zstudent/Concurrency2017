package lesson170705;

public class Reentrant {
	
	static class A {
		
		synchronized void m() {}
		
	}
	
	static class B extends A {
		
		@Override
		synchronized void m() {
			super.m();
		}
	}
	
	public static void main(String[] args) {
		
		B b = new B();
		
		b.m();
		
	}

}
