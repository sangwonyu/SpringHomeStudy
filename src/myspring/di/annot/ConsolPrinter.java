package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("ConsolPrinter")
public class ConsolPrinter implements Printer {

	@Override
	public void print(String message) {
		System.out.println(message);
	}

}
