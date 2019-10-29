package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BalanceCalculatorTest {
	@Autowired
	BalanceCalculatorController balanceController;
	@Test
	void contextLoads() {
	}
	@Test
	void balanceCalculatorTest() {
		assertEquals("Total Balance of Uttam=63.00", balanceController.getTotalBalanceOfTheEmployee("Uttam"));
	}

}
