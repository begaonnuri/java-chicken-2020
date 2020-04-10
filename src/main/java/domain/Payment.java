package domain;

import java.util.Arrays;

import domain.table.Table;

public enum Payment {
	CARD("1"),
	CASH("2");

	private static final int AMOUNT_DISCOUNT_UNIT = 10000;
	private static final int AMOUNT_DISCOUNT_CONDITION = 10;
	private static final double PAY_METHOD_DISCOUNT_RATE = 0.95;

	private String command;

	Payment(String command) {
		this.command = command;
	}

	public static Payment of(String input) {
		return Arrays.stream(values())
				.filter(payment -> payment.command.equals(input))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("일치하는 결제 방법이 없습니다."));
	}

	public double pay(Table table) {
		double pay = discountAmount(table);
		if (this == CASH) {
			return discountPayMethod(pay);
		}
		return pay;
	}

	private double discountPayMethod(double pay) {
		return pay * PAY_METHOD_DISCOUNT_RATE;
	}

	public double discountAmount(Table table) {
		int pay = table.calculateBill();
		while (table.calculateAmount() / AMOUNT_DISCOUNT_CONDITION > 0) {
			pay -= AMOUNT_DISCOUNT_UNIT;
		}
		return pay;
	}
}
