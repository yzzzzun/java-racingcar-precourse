package racingcar.core;

import java.util.Random;

public class NumberGenerator {

	private static final int RANDOM_BOUND = 10;
	private final Random random;

	private static class LazyHolder {
		private static final NumberGenerator INSTANCE = new NumberGenerator();
	}

	public static NumberGenerator getInstance() {
		return LazyHolder.INSTANCE;
	}

	private NumberGenerator() {
		this.random = new Random();
	}

	public int getRandomNumber() {
		return this.random.nextInt(RANDOM_BOUND);
	}
}
