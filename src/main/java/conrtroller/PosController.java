package conrtroller;

import static view.InputView.*;
import static view.OutputView.*;

import java.util.List;

import domain.Function;
import domain.menu.Menu;
import domain.menu.MenuAmount;
import domain.menu.MenuNumber;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;

public class PosController {
	public void run() {
		printMain();
		Function function = Function.of(inputFunctionNumber());

		if (function == Function.ORDER) {
			final List<Table> tables = TableRepository.tables();
			printTables(tables);

			final String tableNumber = InputView.inputTableNumber();

			final List<Menu> menus = MenuRepository.menus();
			printMenus(menus);

			final MenuNumber menuNumber = MenuNumber.of(inputMenuNumber());
			final MenuAmount menuAmount = MenuAmount.of(inputMenuAmount());
		}
	}
}
