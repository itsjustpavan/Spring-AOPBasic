package com.mycompany.app.calculator;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
	public Integer add(int number1,int number2) throws Exception
	{
		if(number1!=0  || number2!=0) {
		System.out.println("sum is "+ (number1+number2));
		return number1+number2;
	}
		throw new Exception();
	}
}
