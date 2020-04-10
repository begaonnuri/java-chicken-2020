package domain.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuRepositoryTest {
	@DisplayName("findByMenuNumber - 메뉴 번호를 입력한 경우 해당 메뉴 반환")
	@Test
	void findByMenuNumber() {
		MenuNumber menuNumber = MenuNumber.of("1");
		Menu expected = new Menu(1, "후라이드", Category.CHICKEN, 16_000);

		Menu actual = MenuRepository.findByMenuNumber(menuNumber);

		assertThat(actual).isEqualTo(expected);
	}
}