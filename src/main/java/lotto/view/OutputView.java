package lotto.view;

import lotto.model.Lotto;
import lotto.model.Prize;

import java.util.List;

import static lotto.model.Prize.*;

public class OutputView {
    public void printLottoCntAndList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            lotto.sortLottoNumbers();
            lotto.printLottoNumbers();
        }
    }

    public void printWinningResults(List<Integer> winningCounts) {
        List<Prize> prizeList = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
        for (Prize prize : prizeList) {
            int winningCount = winningCounts.get(prize.getMatchCount() - 1);
            printPrize(prize, winningCount);
        }
    }

    public void printWinningRate(Double winningRate) {
        System.out.println("총 수익률은 " + winningRate + "%입니다.");
    }

    public void printPrize(Prize prize, int winningCount) {
        System.out.println(prize.getMatchCount() + "개 일치 (" + prize.getPrizeMoney() + ")원 - " + winningCount + "개");
    }

}
