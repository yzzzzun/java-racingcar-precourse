package racingcar.core;

public class NumberMovingStrategy implements MovingStrategy {

	private static final int MOVABLE_CONDITION = 4;
	private NumberGenerator numberGenerator;

	private static class LazyHolder {
		private static final NumberMovingStrategy INSTANCE = new NumberMovingStrategy();
	}

	public static NumberMovingStrategy getInstance() {
		return LazyHolder.INSTANCE;
	}

	private NumberMovingStrategy() {
		this.numberGenerator = NumberGenerator.getInstance();
	}

	@Override
	public boolean moveable() {
		return this.numberGenerator.getRandomNumber() >= MOVABLE_CONDITION;
	}

}
