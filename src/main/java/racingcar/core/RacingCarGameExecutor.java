package racingcar.core;

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
		String attemptInput = this.inputView.makeAttemptInput();

		int attemptCount = Integer.parseInt(attemptInput);
		for (int i = 0; i < attemptCount; i++) {
			//TODO racing car attempt
		}
	}
}
