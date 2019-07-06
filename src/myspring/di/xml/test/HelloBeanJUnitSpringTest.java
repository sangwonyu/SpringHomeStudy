package myspring.di.xml.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// Spring-test의 maven(library)에 ApplicationContext를 설정해주기 때문에 따로 GenericXml..을 설정안해도됨.
@ContextConfiguration(locations="classpath:config/beans.xml")
//GenericXml..을 생성을 안했기 때문에 따로 location을 설정해준다. 
public class HelloBeanJUnitSpringTest {
	@Autowired
	//해당 변수에 자동으로 빈을 매핑해줌. 즉, 위에서 자동으로 설정된 빈을 context변수에 맵핑.
	ApplicationContext context;
	
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
