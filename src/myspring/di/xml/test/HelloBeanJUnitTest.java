package myspring.di.xml.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

import static org.junit.Assert.*;
public class HelloBeanJUnitTest {
	ApplicationContext context;
	@Before
	public void init() {
		//Ioc 컨테이너 생성
		context = new GenericXmlApplicationContext("config/beans.xml");
	}
	
	@Test @Ignore
	public void test1() {
		
		//Hello Bean 가져오기
		Hello hello =(Hello)context.getBean("hello");
		assertEquals("HelloSpring", hello.sayHello()); //assertEquals로 결과값 보기
		hello.print();
		//StringPrinter Bean 가져오기
		Printer printer = context.getBean("printer",Printer.class);
		assertEquals("HelloSpring",printer.toString());
	}
	
	@Test
	public void test2() {
		//Hello Bean 가져오기
		Hello hello =(Hello)context.getBean("hello");
		Hello hello2 =(Hello)context.getBean("hello");
		//hello와 hello2 같은 주소인지 확인
		assertSame(hello,hello2);
		//결과값을 통해 알 수 있는 것은 bean을 통해 얻은 객체는 singletone이라는 것을  알 수 있음
	}
}
