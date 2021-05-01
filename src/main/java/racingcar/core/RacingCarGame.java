package racingcar.core;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.Cars;

public class RacingCarGame {

	private final NumberGenerator numberGenerator;

	private RacingCarGame() {
		this.numberGenerator = new NumberGenerator();
	}

	private static class LazyHolder {
		private static final RacingCarGame INSTANCE = new RacingCarGame();
	}

	public static RacingCarGame getInstance() {
		return LazyHolder.INSTANCE;
	}

	public void race(Cars cars) {

		List<Car> carList = cars.getCars();

		for (Car car : carList) {
			int randomNumber = this.numberGenerator.getRandomNumber();
			car.moveByRandomNumber(randomNumber);
		}
	}

}
