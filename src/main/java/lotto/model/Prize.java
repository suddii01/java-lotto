package lotto.model;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),  // 5개 번호 + 보너스 번호
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    Prize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize valueOf(int matchCount, boolean hasBonus) {
        if (matchCount == 5 && hasBonus) {
            return SECOND;
        }
        for (Prize prize : values()) {
            if (prize.getMatchCount() == matchCount) {
                return prize;
            }
        }
        return NONE;
    }
}
