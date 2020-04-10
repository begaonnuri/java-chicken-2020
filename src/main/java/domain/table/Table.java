package domain.table;

import java.util.HashMap;

import domain.menu.Menu;
import domain.menu.MenuAmount;
import domain.menu.MenuNumber;
import domain.menu.MenuRepository;

public class Table {
	private final TableNumber number;
	private final HashMap<Menu, MenuAmount> bill;

	public Table(final int number) {
		this.number = TableNumber.of(number);
		this.bill = new HashMap<>();
	}

	public Table(TableNumber number, HashMap<Menu, MenuAmount> bill) {
		this.number = number;
		this.bill = new HashMap<>(bill);
	}

	public Table addMenu(MenuNumber menuNumber, MenuAmount menuAmount) {
		HashMap<Menu, MenuAmount> bill = new HashMap<>();
		Menu menu = MenuRepository.findByMenuNumber(menuNumber);
		bill.put(menu, menuAmount);
		return new Table(number, bill);
	}

	public boolean isSameTableNumber(TableNumber tableNumber) {
		return number.equals(tableNumber);
	}

	@Override
	public String toString() {
		return "Table{" +
				"number=" + number +
				", bill=" + bill +
				'}';
	}
}
