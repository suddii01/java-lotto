package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    public void printLottoCntAndList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            lotto.sortLottoNumbers();
            lotto.printLottoNumbers();
        }
    }

}
