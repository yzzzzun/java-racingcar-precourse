package racingcar.core;

public class NumberMovingStrategy implements MovingStrategy {

	private static final int MOVABLE_CONDITION = 4;
	private NumberGenerator numberGenerator;

	public NumberMovingStrategy() {
		this.numberGenerator = new NumberGenerator();
	}

	@Override
	public boolean moveable() {
		return this.numberGenerator.getRandomNumber() >= MOVABLE_CONDITION;
	}

}
