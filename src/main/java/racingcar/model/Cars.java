package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import racingcar.core.NumberMovingStrategy;

public class Cars {

	private static final int FIRST_INDEX = 0;
	private final List<Car> cars = new ArrayList<>();

	public Cars(String carNamesInput) {
		StringTokenizer stringTokenizer = new StringTokenizer(carNamesInput, ",");
		while (stringTokenizer.hasMoreElements()) {
			String carName = stringTokenizer.nextToken();
			this.cars.add(new Car(carName));
		}
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

	public void moveCars() {
		this.cars.forEach(car -> car.moveCar(NumberMovingStrategy.getInstance()));
	}

}
