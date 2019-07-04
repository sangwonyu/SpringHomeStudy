package myspring.di.xml;

public class ConsolPrinter implements Printer {

	@Override
	public void print(String message) {
		System.out.println(message);
	}

}
