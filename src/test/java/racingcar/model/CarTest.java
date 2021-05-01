package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.exception.RacingCarException;

class CarTest {

	private static final String CARNAME_EXCEPTION_MESSAGE = "자동차명은 5자리 이하로 입력하세요.";

	private Car car;

	@BeforeEach
	void setUp() {
		this.car = new Car("car");
	}

	@Test
	@DisplayName("입력된 이름으로 자동차 명이 생성되는지 확인")
	void 입력된이름으로_자동차생성확인() {

		String expected = "Car1";
		Car car = new Car(expected);
		String actual = car.getName();
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	@DisplayName("자동차명이 5자 이상이면 오류발생")
	void 자동차명_오류확인() {

		assertThatExceptionOfType(RacingCarException.class).isThrownBy(() -> {
			new Car("CarCar");
		}).withMessageMatching(CARNAME_EXCEPTION_MESSAGE);
	}

	@Test
	@DisplayName("랜덤 숫자가 4이상이면 1칸이동")
	void 숫자가_4이상이면_자동차이동() {
		this.car.moveByRandomNumber(4);
		int moveCount = car.getMoveCount();
		assertThat(moveCount).isEqualTo(1);
	}

	@Test
	@DisplayName("랜덤 숫자가 3이하이면 정지")
	void 숫자가_3이하이면_자동차이동안함() {
		this.car.moveByRandomNumber(3);
		int moveCount = car.getMoveCount();
		assertThat(moveCount).isEqualTo(0);
	}
}
