package racingcar.core;

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
		String carNamesInput = this.inputView.makeRacingCarNameInput();
		Cars cars = new Cars(carNamesInput);

		String attemptInput = this.inputView.makeAttemptInput();
		int attemptCount = Integer.parseInt(attemptInput);

		for (int i = 0; i < attemptCount; i++) {
			RacingCarGame.getInstance().race(cars);
		}

		this.inputView.closeScanner();
	}
}
