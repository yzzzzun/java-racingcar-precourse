package racingcar.model;

import racingcar.exception.RacingCarException;

public class Car implements Comparable<Car> {

	private static final String CAR_RESULT_FORMAT = "%s : %s";
	private static final int MAX_CARNAME_LENGTH = 5;
	private static final String CARNAME_EXCEPTION_MESSAGE = "자동차명은 5자리 이하로 입력하세요.";

	private final String name;
	private int moveCount;

	public Car(String name) {
		if (name.length() > MAX_CARNAME_LENGTH) {
			throw new RacingCarException(CARNAME_EXCEPTION_MESSAGE);
		}

		this.name = name;
		this.moveCount = 0;
	}

	public String getName() {
		return this.name;
	}

	public int getMoveCount() {
		return this.moveCount;
	}

	public void moveByRandomNumber(int randomNumber) {
		if (randomNumber >= 4) {
			this.moveCount++;
		}
	}

	public String getCarRacingResult() {
		return String.format(CAR_RESULT_FORMAT, this.name, this.getMoveDistance());
	}

	private String getMoveDistance() {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < this.moveCount; i++) {
			stringBuilder.append("-");
		}

		return stringBuilder.toString();
	}

	@Override
	public int compareTo(Car car) {
		return car.moveCount - this.moveCount;
	}

}
