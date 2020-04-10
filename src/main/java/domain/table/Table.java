package domain.table;

import java.util.HashMap;

import domain.menu.Menu;
import domain.menu.MenuAmount;
import domain.menu.MenuNumber;
import domain.menu.MenuRepository;

public class Table {
	private final TableNumber number;

	public Table(final int number) {
		this.number = TableNumber.of(number);
	}
		this.number = number;
	}

	public boolean isSameTableNumber(TableNumber tableNumber) {
		return number.equals(tableNumber);
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
