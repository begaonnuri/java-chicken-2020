package domain.table;

import java.util.Objects;

public class TableNumber {
	private static final int MIN_TABLE_NUMBER = 1;
	private static final int MAX_TABLE_NUMBER = 8;

	private int number;

	private TableNumber(int number) {
		validateBound(number);
		this.number = number;
	}

	public static TableNumber of(String input) {
		return TableNumber.of(Integer.parseInt(input));
	}

	public static TableNumber of(int input) {
		return new TableNumber(input);
	}

	private void validateBound(int number) {
		if (number < MIN_TABLE_NUMBER || number > MAX_TABLE_NUMBER) {
			throw new IllegalArgumentException("목록에 있는 테이블 번호를 입력해주세요.");
		}
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TableNumber that = (TableNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return number + "";
	}
}
