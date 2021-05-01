package racingcar.view;

import java.util.Scanner;

import racingcar.exception.RacingCarException;

public class InputView extends View {

	private static final String INPUT_ATTEMPT_ERROR_MESSAGE = "시도횟수는 숫자만 입력하세요";
	private static final String INPUT_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String INPUT_RACING_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String NUMERIC_REGEX = "(^[0-9]*$)";
	private final Scanner scanner = new Scanner(System.in);

	public String makeRacingCarNameInput() {
		out.println(INPUT_RACING_CAR_MESSAGE);
		return this.scanner.nextLine();
	}

	public String makeAttemptInput() {
		out.println(INPUT_ATTEMPT_MESSAGE);

		String attemptInput = this.scanner.nextLine();
		if (attemptInput.matches(NUMERIC_REGEX) == false) {
			throw new RacingCarException(INPUT_ATTEMPT_ERROR_MESSAGE);
		}
		return attemptInput;
	}

	public void closeScanner() {
		this.scanner.close();
	}
}
