package domain.menu;

import java.util.Objects;

public class Menu {
	private final MenuNumber number;
	private final String name;
	private final Category category;
	private final int price;

	public Menu(final int number, final String name, final Category category, final int price) {
		this.number = MenuNumber.of(number);
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public boolean isSameMenuNumber(MenuNumber menuNumber) {
		return number.equals(menuNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Menu menu = (Menu)o;
		return price == menu.price &&
				Objects.equals(number, menu.number) &&
				Objects.equals(name, menu.name) &&
				category == menu.category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, name, category, price);
	}

	@Override
	public String toString() {
		return category + " " + number + " - " + name + " : " + price + "원";
	}
}
