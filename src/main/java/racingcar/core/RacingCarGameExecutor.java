package racingcar.core;

import java.util.StringTokenizer;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameExecutor {

	private final InputView inputView;
	private final OutputView outputView;

	public RacingCarGameExecutor() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void start() {
		Cars cars = this.generateCars();

		String attemptInput = this.inputView.makeAttemptInput();
		int attemptCount = Integer.parseInt(attemptInput);

		this.outputView.printResultMessage();
		for (int i = 0; i < attemptCount; i++) {
			RacingCarGame.getInstance().race(cars);
			this.outputView.printRacingResult(cars);
		}
		this.outputView.printWinners(cars);
		this.inputView.closeScanner();
	}

	private Cars generateCars() {
		String carNamesInput = this.inputView.makeRacingCarNameInput();
		StringTokenizer stringTokenizer = new StringTokenizer(carNamesInput, ",");

		Cars cars = new Cars();
		while (stringTokenizer.hasMoreElements()) {
			String carName = stringTokenizer.nextToken();
			cars.addCar(new Car(carName));
		}

		return cars;
	}

}
