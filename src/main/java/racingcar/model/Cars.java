package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	public List<Car> getWinner() {
		Collections.sort(this.cars);

		List<Car> winner = new ArrayList<>();
		Car firstCar = this.cars.get(FIRST_INDEX);
		winner.add(firstCar);

		for (int i = 1; i < this.cars.size(); i++) {
			Car nextCar = this.cars.get(i);
			this.getCoWinner(winner, firstCar, nextCar);
		}

		return winner;
	}

	private void getCoWinner(List<Car> winner, Car firstCar, Car nextCar) {
		if (firstCar.getMoveCount() == nextCar.getMoveCount()) {
			winner.add(nextCar);
		}
	}

}
