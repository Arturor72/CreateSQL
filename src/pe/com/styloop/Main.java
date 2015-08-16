package pe.com.styloop;

import pe.com.styloop.process.Process;

public class Main {
	public static void main(String[] args) {
		Process process = new Process();
		boolean state = false;
		try {
			state = process.generateScript();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (state)
			System.out.println("Successful");
		else
			System.out.println("You have errors");
	}
}
