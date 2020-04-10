package conrtroller;

import static view.InputView.*;
import static view.OutputView.*;

import java.util.List;

import domain.Function;
import domain.Payment;
import domain.menu.Menu;
import domain.menu.MenuAmount;
import domain.menu.MenuNumber;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableNumber;
import domain.table.TableRepository;

public class PosController {
	public void run() {
		Function function;
		Table table;
		do {
			printMain();
			function = Function.of(inputFunctionNumber());

			final List<Table> tables = TableRepository.tables();
			printTables(tables);

			final TableNumber tableNumber = TableNumber.of(inputTableNumber());

			if (function == Function.ORDER) {
				table = order(tableNumber);
			}
			if (function == Function.ACCOUNT) {
				pay(tableNumber);
			}
		} while (function != Function.EXIT);
	}

	private Table order(TableNumber tableNumber) {
		final Table table = TableRepository.findByTableNumber(tableNumber);

		final List<Menu> menus = MenuRepository.menus();
		printMenus(menus);

		final MenuNumber menuNumber = MenuNumber.of(inputMenuNumber());
		final MenuAmount menuAmount = MenuAmount.of(inputMenuAmount());

		return table.addMenu(menuNumber, menuAmount);
	}

	private void pay(TableNumber tableNumber) {
		final Table table = TableRepository.findByTableNumber(tableNumber);
		printOrderInfo(table);

		printPayProceedMessage(table);
		final Payment payment = Payment.of(inputPayMethod());
		final double result = payment.pay(table);
		printResult(result);
	}
}
