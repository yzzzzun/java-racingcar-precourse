package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Cars {

	private static final int FIRST_INDEX = 0;
	private List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public void addCar(Car car) {
		this.cars.add(car);
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public String getWinners() {
		Collections.sort(this.cars);

		Car winnerCar = this.cars.get(FIRST_INDEX);
		int max = winnerCar.getMoveCount();

		StringJoiner joiner = new StringJoiner(", ");
		joiner.add(winnerCar.getName());

		for (int i = 1; i < this.cars.size(); i++) {
			Car car = this.cars.get(i);
			this.addCoWinner(max, joiner, car);
		}
		return joiner.toString();
	}

	private void addCoWinner(int max, StringJoiner joiner, Car coWinner) {
		if (max == coWinner.getMoveCount()) {
			joiner.add(coWinner.getName());
		}
	}
}
