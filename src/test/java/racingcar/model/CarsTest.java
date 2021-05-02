package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.exception.RacingCarException;

class CarsTest {
	private static final String CARNAME_EXCEPTION_MESSAGE = "자동차명은 5자리 이하로 입력하세요.";

	private Cars cars;

	@BeforeEach
	void setUp() {
		this.cars = new Cars("test1,test2,test3,test4");
		List<Car> carList = this.cars.getCars();

		Car car1 = carList.get(0);
		car1.moveCar(() -> true);
		car1.moveCar(() -> true);

		Car car2 = carList.get(1);
		car2.moveCar(() -> true);

		Car car3 = carList.get(2);
		car3.moveCar(() -> true);
		car3.moveCar(() -> true);
	}

	@Test
	@DisplayName("사용자 입력으로 cars가 정상적으로 생성되는지 확인")
	void Cars_생성테스트() {

		List<Car> carList = this.cars.getCars();

		assertThat(carList.get(0).getMoveCount()).isEqualTo(2);
		assertThat(carList.get(0).getName()).isEqualTo("test1");
		assertThat(carList.get(1).getMoveCount()).isEqualTo(1);
		assertThat(carList.get(1).getName()).isEqualTo("test2");
		assertThat(carList.get(2).getMoveCount()).isEqualTo(2);
		assertThat(carList.get(2).getName()).isEqualTo("test3");
		assertThat(carList.get(3).getMoveCount()).isEqualTo(0);
		assertThat(carList.get(3).getName()).isEqualTo("test4");
	}

	@Test
	@DisplayName("car 이름이 5자리 이하로 입력된 경우 Cars 생성시 오류발생")
	void Cars_입력문자가_조건과다른경우() {
		assertThatExceptionOfType(RacingCarException.class).isThrownBy(() -> {
			new Cars("test12345,test2,test3,test4");
		}).withMessageMatching(CARNAME_EXCEPTION_MESSAGE);
	}

	@Test
	@DisplayName("1등 자동차 목록 반환")
	void 우승자동차확인() {
		List<Car> winner = this.cars.getWinner();
		assertThat(winner.get(0).getName()).isEqualTo("test1");
		assertThat(winner.get(1).getName()).isEqualTo("test3");
	}

}
