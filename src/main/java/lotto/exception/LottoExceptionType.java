package lotto.exception;

public enum LottoExceptionType {
    INVALID_PRICE_RANGE("[ERROR] 구입 금액은 0이상이어야 합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호의 숫자 범위는 1 이상 45 이하여야 합니다."),
    INVALID_NUMBER_COUNT("[ERROR] 로또 번호는 6개의 숫자로 구성되어야 합니다."),
    DUPLICATED_WINNING_NUMBER("[ERROR] 당첨 번호는 중복된 숫자를 허용하지 않습니다."),
    DUPLICATED_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_INPUT_FORMAT("[ERROR] 입력된 번호가 올바른 형식이 아닙니다.");

    private final String message;

    LottoExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
