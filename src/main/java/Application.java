import static view.OutputView.*;

import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;

public class Application {
	// TODO 구현 진행
	public static void main(String[] args) {
		printMain();
		final List<Table> tables = TableRepository.tables();
		printTables(tables);

		final int tableNumber = InputView.inputTableNumber();

		final List<Menu> menus = MenuRepository.menus();
		printMenus(menus);
	}
}
