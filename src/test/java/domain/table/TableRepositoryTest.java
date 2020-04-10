package domain.table;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableRepositoryTest {
	@DisplayName("findByTableNumber - 테이블 번호를 입력한 경우 해당 테이블 반환")
	@Test
	void findByTableNumber() {
		TableNumber tableNumber = TableNumber.of("1");
		Table expected = new Table(1);

		Table actual = TableRepository.findByTableNumber(tableNumber);

		assertThat(actual).isEqualTo(expected);
	}
}