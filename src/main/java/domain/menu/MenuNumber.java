package domain.menu;

import java.util.Objects;

public class MenuNumber {
	private static final int MIN_MENU_NUMBER = 0;

	private int number;

	private MenuNumber(int number) {
		validateBound(number);
		this.number = number;
	}

	public static MenuNumber of(String input) {
		return MenuNumber.of(Integer.parseInt(input));
	}

	public static MenuNumber of(int input) {
		return new MenuNumber(input);
	}

	private void validateBound(int number) {
		if (number < MIN_MENU_NUMBER) {
			throw new IllegalArgumentException("0이상의 정수를 입력해주세요.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MenuNumber that = (MenuNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return "" + number;
	}
}
