package com.ruoyi.web.stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootTest
public class ConsumerTest {

	//1.Consumer<T>  消费型   void  accept （T t）
	@Test
	public void accept() {
		happy(10000, (m) -> System.out.println("大保健消费" + m + "元"));
	}

	private void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}

	//2.default Consumer<T> andThen(Consumer<? super T> after)
	Function<Integer, Integer> first = x -> x * x;
	Function<Integer, Integer> after = y -> y * 2;

	@Test
	public void accept02() {
		System.out.println(first.apply(3));//3的平方
		System.out.println(after.apply(3));//3乘以2
		int res=first.andThen(after).apply(4);//先3的平方再乘以2
		System.out.println(res);
	}

}
