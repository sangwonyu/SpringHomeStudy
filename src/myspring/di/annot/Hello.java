package myspring.di.annot;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hello {
	@Value("${myname}")//name에 Spring을 주입
	private String name;
	/*
	 * @Autowired
	 * 
	 * @Qualifier("StringPrinter")
	 */ // 프로퍼티파일 이용하면, 두 어노테이션 태그 불필요
	@Resource(name="${printer1}")
	private Printer printer;
	//printer를 구현하는 클래스가 2개(SpringPrinter,ConsolPrinter) Quailfier를 통해 명시
	//직접 주입하기 때문에 setter는 필요없음
	
	private List<String> names;
	
	public Hello() {}
	
	public Hello(String name, Printer printer) {
		super();
		this.name = name;
		this.printer = printer;
	}
	
	/*
	 * public void setName(String name) { this.name = name; }
	 */
	/*
	 * public void setPrinter(Printer printer) { this.printer = printer; }
	 */
	
	public List<String> getNames() {
		return names;
	}

	/*
	 * public void setNames(List<String> names) { this.names = names; }
	 */

	public String sayHello() {
		return "Hello" + name;
	}
	
	public void print() {
		this.printer.print(sayHello());
	}
	
}
