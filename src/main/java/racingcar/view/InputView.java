package racingcar.view;

import java.util.Scanner;

public class InputView extends View {

	private static final String INPUT_ATTEMT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String INPUT_RACING_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private final Scanner scanner = new Scanner(System.in);

	public String makeRacingCarNameInput() {
		out.println(INPUT_RACING_CAR_MESSAGE);
		return this.scanner.nextLine();
	}

	public String makeAttemtInput() {
		out.println(INPUT_ATTEMT_MESSAGE);
		return this.scanner.nextLine();
	}

	public void closeScanner() {
		this.scanner.close();
	}
}
