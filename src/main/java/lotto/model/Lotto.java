package lotto.model;

import java.util.Collections;
import java.util.List;

import static lotto.exception.LottoExceptionType.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public void printLottoNumbers() {
        System.out.print("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.println(numbers.get(numbers.size() - 1) + "]");
    }

    public void sortLottoNumbers() {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
