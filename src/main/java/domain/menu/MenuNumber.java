package domain.menu;

public class MenuNumber {
	private int number;

	private MenuNumber(int number) {
		validateBound(number);
		this.number = number;
	}

	public static MenuNumber of(String input) {
		return new MenuNumber(Integer.parseInt(input));
	}

	private void validateBound(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("0이상의 정수를 입력해주세요.");
		}
	}
}
