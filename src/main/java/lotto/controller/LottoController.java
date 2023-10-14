package lotto.controller;

import lotto.model.LottoService;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final WinningLotto winningLotto;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService, WinningLotto winningLotto) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.winningLotto = winningLotto;
    }

    public void runLottoGame() {
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
    }

}
