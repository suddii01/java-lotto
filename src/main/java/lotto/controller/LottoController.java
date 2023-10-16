package lotto.controller;

import lotto.exception.LottoExceptionType;
import lotto.model.Lotto;
import lotto.model.LottoService;
import lotto.model.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.exception.LottoExceptionType.*;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void runLottoGame() {
        int purchasePrice = inputView.readPurchasePrice();
        validatePurchasePrice(purchasePrice);
        int lottoCnt = lottoService.calculateLottoCount(purchasePrice);

        List<Lotto> lottoList = generateLottoList(lottoCnt);
        outputView.printLottoCntAndList(lottoList);

        Lotto winningLotto = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
        validateBonusNumber(winningLotto, bonusNumber);

        List<Prize> winningResults = lottoService.getWinningResults(winningLotto, bonusNumber, lottoList);
        List<Integer> winningCounts = lottoService.getWinningCounts(winningResults);
        outputView.printWinningResults(winningCounts);

        Double winningRate = lottoService.getWinningRate(winningCounts, lottoCnt);
        outputView.printWinningRate(winningRate);
    }

    private List<Lotto> generateLottoList(int lottoCnt) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottoList.add(lottoService.getLottoNumbers());
        }
        return lottoList;
    }

    private void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < 0) throw new IllegalArgumentException(INVALID_PRICE_RANGE.getMessage());
    }
    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        for (Integer number : winningLotto.getNumbers()) {
            if (bonusNumber == number) throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }
}
