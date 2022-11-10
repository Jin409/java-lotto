package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String READ_USER_PAID_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_LOTTERY_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_LOTTERY_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String readUserPaidMoney() {
        System.out.println(READ_USER_PAID_MONEY_MESSAGE);
        return Console.readLine();
    }

    public static String readLotteryNumbers() {
        System.out.println(READ_LOTTERY_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String readBonusLotteryNumber() {
        System.out.println(READ_BONUS_LOTTERY_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
