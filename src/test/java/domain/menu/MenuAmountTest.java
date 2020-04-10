package domain.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuAmountTest {
	@DisplayName("of - 메뉴 수량을 입력한 경우 MenuAmount 반환")
	@Test
	void of() {
		assertThat(MenuAmount.of("1")).isInstanceOf(MenuAmount.class);
	}

	@DisplayName("of - 1이하 100이상의 메뉴 수량을 입력한 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"0, 100"})
	void of_InvalidBound(String input) {
		assertThatThrownBy(() -> MenuAmount.of(input)).isInstanceOf(IllegalArgumentException.class);
	}
}