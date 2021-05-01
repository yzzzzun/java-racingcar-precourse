package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Cars {
	private List<Car> cars = new ArrayList<>();

	public Cars(String carNames) {
		StringTokenizer stringTokenizer = new StringTokenizer(carNames, ",");

		while (stringTokenizer.hasMoreElements()) {
			String carName = stringTokenizer.nextToken();
			this.cars.add(new Car(carName.trim()));
		}
	}

	public List<Car> getCars() {
		return this.cars;
	}
}
