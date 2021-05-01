package racingcar.view;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView extends View {

	private static final String RESULT_MESSAGE = "실행결과";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

	public void printRacingResult(Cars cars) {

		List<Car> carList = cars.getCars();

		for (Car car : carList) {
			out.println(car.getCarRacingResult());
		}
		out.println();
	}

	public void printResultMessage() {
		out.println();
		out.println(RESULT_MESSAGE);
	}

	public void printWinners(Cars cars) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(cars.getWinners())
			.append(WINNER_MESSAGE);

		out.println(stringBuilder.toString());
	}

}
