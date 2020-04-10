package domain;

import java.util.Arrays;

public enum Function {
	ORDER("1"),
	ACCOUNT("2"),
	EXIT("3");

	private String command;

	Function(String command) {
		this.command = command;
	}

	public static Function of(String input) {
		return Arrays.stream(values())
				.filter(function -> function.command.equals(input))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("해당 기능이 없습니다."));
	}
}
