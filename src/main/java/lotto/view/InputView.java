package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    public int readPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        Set<Integer> winningNumbers = new HashSet<>();
        String s = Console.readLine();
        String[] inputNumbers = s.split(",");

        for (String inputNumber : inputNumbers) {
            winningNumbers.add(Integer.parseInt(inputNumber.trim()));
        }
        return new ArrayList<>(winningNumbers);
    }

    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
