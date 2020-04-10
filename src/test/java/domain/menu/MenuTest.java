package domain.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {
	@DisplayName("생성자 테스트")
	@Test
	void constructor() {
		assertThat(new Menu(1, "후라이드", Category.CHICKEN, 16_000)).isInstanceOf(Menu.class);
	}

	@DisplayName("isSameMenuNumber 테스트")
	@Test
	void isSameMenuNumber() {
		Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
		MenuNumber menuNumber = MenuNumber.of("1");
		assertThat(menu.isSameMenuNumber(menuNumber)).isTrue();
	}
}