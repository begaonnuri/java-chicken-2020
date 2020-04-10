package view;

import java.util.List;
import java.util.Map;

import domain.menu.Menu;
import domain.menu.MenuAmount;
import domain.table.Table;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";

	private OutputView() {
	}

	public static void printMain() {
		System.out.println("## 메인화면");
		System.out.println("1 - 주문등록");
		System.out.println("2 - 결제하기");
		System.out.println("3 - 프로그램 종료");
		System.out.println();
	}

	public static void printOrderInfo(final Table table) {
		StringBuilder builder = new StringBuilder();
		builder.append("## 주문 내역");
		for (Map.Entry<Menu, MenuAmount> e : table.getBill().entrySet()) {
			builder.append(e.getKey().getName());
			builder.append(e.getValue());
			builder.append("개");
			builder.append(e.getKey().getPrice());
		}
		System.out.println(builder);
	}

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printLine(BOTTOM_LINE, size);
	}

	public static void printMenus(final List<Menu> menus) {
		for (final Menu menu : menus) {
			System.out.println(menu);
		}
	}

	private static void printLine(final String line, final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(line);
		}
		System.out.println();
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}
}
