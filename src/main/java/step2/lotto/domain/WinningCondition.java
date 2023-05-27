package step2.lotto.domain;

public enum WinningCondition {
	NOTHING(0, 0),
	FOURTH_PRIZE(3, 5_000),
	THIRD_PRIZE(4, 50_000),
	SECOND_PRIZE(5, 1_500_000),
	FIRST_PRIZE(6, 2_000_000_000);

	private final int matchCount;
	private final int winningMoney;

	WinningCondition(int matchCount, int winningMoney) {
		this.matchCount = matchCount;
		this.winningMoney = winningMoney;
	}

	public static WinningCondition from(int matchCount) {
		for (WinningCondition condition : WinningCondition.values()) {
			if (condition.matchCount == matchCount) {
				return condition;
			}
		}

		throw new IllegalArgumentException("당첨 조건이 존재하지 않습니다.");
	}

	public int getWinningMoney() {
		return winningMoney;
	}
}
