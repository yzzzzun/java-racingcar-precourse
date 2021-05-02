package racingcar.core;

public class RandomMovingStrategy implements MovingStrategy {

	private static final int MOVABLE_CONDITION = 4;
	private NumberGenerator numberGenerator;

	private static class LazyHolder {
		private static final RandomMovingStrategy INSTANCE = new RandomMovingStrategy();
	}

	public static RandomMovingStrategy getInstance() {
		return LazyHolder.INSTANCE;
	}

	private RandomMovingStrategy() {
		this.numberGenerator = NumberGenerator.getInstance();
	}

	@Override
	public boolean moveable() {
		return this.numberGenerator.getRandomNumber() >= MOVABLE_CONDITION;
	}

}
