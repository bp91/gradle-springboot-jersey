package it.testWebapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-dev.properties")
public class TestWebappApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void aTest() {
		int a = 1;
		
		assertEquals(a, 1);
	}
}
