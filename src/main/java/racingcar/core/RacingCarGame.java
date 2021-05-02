package racingcar.core;

import racingcar.model.Cars;

public class RacingCarGame {

	private static class LazyHolder {
		private static final RacingCarGame INSTANCE = new RacingCarGame();
	}

	public static RacingCarGame getInstance() {
		return LazyHolder.INSTANCE;
	}

	public void race(Cars cars) {
		cars.moveCars();
	}

}
