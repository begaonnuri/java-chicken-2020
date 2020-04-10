package domain.table;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.Menu;
import domain.menu.MenuAmount;
import domain.menu.MenuNumber;
import domain.menu.MenuRepository;

class TableTest {
	@DisplayName("addMenu 테스트")
	@Test
	void addMenu() {
		HashMap<Menu, MenuAmount> bill = new HashMap<>();
		TableNumber tableNumber = TableNumber.of("1");
		MenuNumber menuNumber = MenuNumber.of("1");
		MenuAmount menuAmount = MenuAmount.of("1");
		bill.put(MenuRepository.findByMenuNumber(menuNumber), menuAmount);
		Table table = new Table(tableNumber, bill);

		Table actual = table.addMenu(menuNumber, menuAmount);
		Table expected = new Table(tableNumber, bill);

		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("isSameTableNumber 테스트")
	@Test
	void isSameTableNumber() {
		Table actual = new Table(1);
		Table expected = TableRepository.findByTableNumber(TableNumber.of(1));

		assertThat(actual).isEqualTo(expected);
	}
}