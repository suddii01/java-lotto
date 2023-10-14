package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Prize.*;

public class LottoService {
    public int getLottoCnt(int purchasePrice) {
        return purchasePrice / 1000;
    }

    public Lotto getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public Double getWinningRate(List<Integer> winningCounts, int lottoCnt) {
        int totalWinningCounts = 0;
        for (Integer winningCount : winningCounts) {
            totalWinningCounts += winningCount;
        }
        return Double.valueOf(totalWinningCounts) / Double.valueOf(lottoCnt);
    }

    public List<Integer> getWinningCounts(List<Prize> prizeList) {
        List<Integer> winningCounts = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            winningCounts.add(0);
        }
        for (Prize prize : prizeList) {
            int index = prize.getMatchCount() - 1;
            winningCounts.set(index, winningCounts.get(index) + 1);
        }
        return winningCounts;
    }

    public List<Prize> getWinningResults(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottoList) {
        List<Prize> winningResults = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            Prize prize = getWinningResult(winningNumbers, bonusNumber, lotto);
            if (prize == NONE) continue;
            winningResults.add(prize);
        }
        return winningResults;
    }

    public Prize getWinningResult(List<Integer> winningNumbers, int bonusNumber, Lotto lotto) {
        boolean hasBonus = false;
        int matchCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) matchCount++;
            if (number.equals(bonusNumber)) hasBonus = true;
        }
        return valueOf(matchCount, hasBonus);
    }
}
