package domain.table;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TableNumberTest {
	@DisplayName("of - 테이블 번호를 입력한 경우 TableNumber 반환")
	@Test
	void of() {
		assertThat(TableNumber.of("1")).isInstanceOf(TableNumber.class);
	}

	@DisplayName("of - 0이하 9이상의 테이블 번호를 입력한 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"0", "9"})
	void of_InvalidBound(String input) {
		assertThatThrownBy(() -> TableNumber.of(input)).isInstanceOf(IllegalArgumentException.class);
	}
}