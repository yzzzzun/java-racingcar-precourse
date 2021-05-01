package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.exception.RacingCarException;

class CarsTest {
	private static final String CARNAME_EXCEPTION_MESSAGE = "자동차명은 5자리 이하로 입력하세요.";

	@Test
	@DisplayName("사용자 입력으로 cars가 정상적으로 생성되는지 확인")
	void Cars_생성테스트() {
		Cars cars = new Cars("test1 ,test2 ,test3 ,test4");
		List<Car> carList = cars.getCars();

		assertThat(carList.get(0).getMoveCount()).isEqualTo(0);
		assertThat(carList.get(0).getName()).isEqualTo("test1");
		assertThat(carList.get(1).getMoveCount()).isEqualTo(0);
		assertThat(carList.get(1).getName()).isEqualTo("test2");
		assertThat(carList.get(2).getMoveCount()).isEqualTo(0);
		assertThat(carList.get(2).getName()).isEqualTo("test3");
		assertThat(carList.get(3).getMoveCount()).isEqualTo(0);
		assertThat(carList.get(3).getName()).isEqualTo("test4");
	}

	@Test
	@DisplayName("car 이름이 5자리 이하로 입력된 경우 Cars 생성시 오류발생")
	void Cars_입력문자가_조건과다른경우() {
		assertThatExceptionOfType(RacingCarException.class).isThrownBy(() -> {
			new Cars("test123 ,abc ,cde ,def");
		}).withMessageMatching(CARNAME_EXCEPTION_MESSAGE);
	}

}
