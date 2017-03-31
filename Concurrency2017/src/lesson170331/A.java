package lesson170331;

public class A {
	
	int i = 0;
	
	synchronized void x() {
		i++;
	}
	
	synchronized void y() {
		i--;
	}

}
