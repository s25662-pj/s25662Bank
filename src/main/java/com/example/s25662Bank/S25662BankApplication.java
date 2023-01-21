package com.example.s25662Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S25662BankApplication {

	private final BankService bankService;

	public S25662BankApplication(BankService bankService) {
		this.bankService = bankService;


		//Java nie umie liczyc
		TransferInfo transferInfo1 = bankService.transfer(123456, 11.00f);
		System.out.println(transferInfo1.toString());

		TransferInfo transferInfo2 = bankService.addMoney(125662, 10.00f);
		System.out.println(transferInfo2.toString());

		bankService.getUserInfo(123453);

	}


	public static void main(String[] args) {
		SpringApplication.run(S25662BankApplication.class, args);
	}

}
