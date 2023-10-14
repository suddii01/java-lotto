package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
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
