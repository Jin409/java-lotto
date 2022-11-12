package lotto.utils;

import static lotto.constants.LottoConstant.LOTTERY_NUMBER_SEPARATOR;
import static lotto.validator.NumberValidator.hasValidType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberAdapter {
    public static List<Integer> fitWinningNumber(String beforeWinningNumber) {
        hasValidType(beforeWinningNumber);
        String[] tempLotteryNumbers = beforeWinningNumber.split(LOTTERY_NUMBER_SEPARATOR);
        int[] afterLotteryNumbers = Arrays.stream(tempLotteryNumbers).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(afterLotteryNumbers)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int fitBonusNumber(String beforeBonusNumber) {
        return Integer.parseInt(beforeBonusNumber);
    }

    public static List<Integer> fitWinningNumberWithBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        winningNumber.add(bonusNumber);
        return winningNumber;
    }

    public static int getPaidMoney(String beforePaidMoney) {
        return Integer.parseInt(beforePaidMoney);
    }
}
