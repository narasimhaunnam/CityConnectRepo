package com.cities.connected;

import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
@EnableAutoConfiguration
@TestPropertySource("classpath:city.txt")
public class ConnectedApplicationTests {

	 public static void main(final String... args) {
	        SpringApplication.run(ConnectedApplicationTests.class, args);
	    }

}
