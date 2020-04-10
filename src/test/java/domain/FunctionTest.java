package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FunctionTest {
	@DisplayName("of - 기능 번호를 입력한 경우 Function 반환")
	@Test
	void of() {
		assertThat(Function.of("1")).isInstanceOf(Function.class);
	}

	@DisplayName("of - 없는 기능 번호를 입력한 경우 예외 발생")
	@Test
	void of_InvalidFunctionNumber() {
		assertThatThrownBy(() -> Function.of("4")).isInstanceOf(IllegalArgumentException.class);
	}
}