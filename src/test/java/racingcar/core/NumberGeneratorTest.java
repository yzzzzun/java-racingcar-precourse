package racingcar.core;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

	@Test
	@DisplayName("0~9까지의 랜덤 숫자 생성 확인")
	void 랜덤넘버_생성확인() {
		NumberGenerator numberGenerator = NumberGenerator.getInstance();
		int randomNumber = numberGenerator.getRandomNumber();
		assertThat(randomNumber).isBetween(0, 9);
	}

}
