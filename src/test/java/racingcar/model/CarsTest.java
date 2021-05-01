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
		this.cars = new Cars();

		Car car1 = new Car("test1");
		car1.moveByRandomNumber(5);
		car1.moveByRandomNumber(5);
		cars.addCar(car1);

		Car car2 = new Car("test2");
		car2.moveByRandomNumber(5);
		cars.addCar(car2);

		Car car3 = new Car("test3");
		car3.moveByRandomNumber(5);
		car3.moveByRandomNumber(5);
		cars.addCar(car3);

		Car car4 = new Car("test4");
		cars.addCar(car4);
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
			Cars cars = new Cars();
			cars.addCar(new Car("test12345"));
			cars.addCar(new Car("test2"));
			cars.addCar(new Car("test3"));
			cars.addCar(new Car("test4"));
		}).withMessageMatching(CARNAME_EXCEPTION_MESSAGE);
	}

	@Test
	@DisplayName("1등 자동차 목록 반환")
	void 우승자동차확인() {
		String winners = this.cars.getWinners();
		assertThat(winners).isEqualTo("test1, test3");
	}

}
