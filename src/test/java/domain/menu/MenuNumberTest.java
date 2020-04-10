package domain.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuNumberTest {
	@DisplayName("of - 메뉴 번호를 입력한 경우 MenuNumber 반환")
	@Test
	void of() {
		assertThat(MenuNumber.of("1")).isInstanceOf(MenuNumber.class);
	}

	@DisplayName("of - 0 미만의 메뉴 번호를 입력한 경우 예외 발생")
	@Test
	void of_NegativeInteger() {
		assertThatThrownBy(() -> MenuNumber.of("-1")).isInstanceOf(IllegalArgumentException.class);
	}
}