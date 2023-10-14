package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoService;
import lotto.model.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

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
        int lottoCnt = lottoService.getLottoCnt(purchasePrice);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottoList.add(lottoService.getLottoNumbers());
        }
        outputView.printLottoCntAndList(lottoList);
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
        List<Prize> winningResults = lottoService.getWinningResults(winningNumbers, bonusNumber, lottoList);
        List<Integer> winningCounts = lottoService.getWinningCounts(winningResults);
        outputView.printWinningResults(winningCounts);
        Double winningRate = lottoService.getWinningRate(winningCounts, lottoCnt);
        outputView.printWinningRate(winningRate);
    }

}
