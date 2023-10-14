package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private LottoController lottoController;

    public Application() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();
        this.lottoController = new LottoController(inputView, outputView, lottoService);
    }

    public void run() {
        lottoController.runLottoGame();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}
