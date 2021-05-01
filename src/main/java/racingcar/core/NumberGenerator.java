package racingcar.core;

import java.util.Random;

public class NumberGenerator {

	private static final int RANDOM_BOUND = 10;
	private final Random random;

	public NumberGenerator() {
		this.random = new Random();
	}

	public int getRandomNumber() {
		this.random.setSeed(System.currentTimeMillis());
		return this.random.nextInt(RANDOM_BOUND);
	}
}
