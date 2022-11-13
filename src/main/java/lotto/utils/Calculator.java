package lotto.utils;

import static lotto.constants.LottoConstant.VALID_LOTTERY_NUMBER_LENGTH;
import static lotto.model.Rank.FIFTH_PLACE;
import static lotto.model.Rank.FIRST_PLACE;
import static lotto.model.Rank.FOURTH_PLACE;
import static lotto.model.Rank.NONE;
import static lotto.model.Rank.SECOND_PLACE;
import static lotto.model.Rank.THIRD_PLACE;
import static lotto.model.Rank.findCountWithRank;
import static lotto.model.Rank.findRankWithCount;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class Calculator {
    public static Rank calculateLottoRank(Lotto customerLotto, List<Integer> winningNumber, int bonusNumber) {
        int count = calculateDuplicateNumberCount(customerLotto, winningNumber);
        if (count == findCountWithRank(THIRD_PLACE) && isLottoContainBonusNumber(customerLotto, bonusNumber)) {
            return SECOND_PLACE;
        }
        return findRankWithCount(count);
    }

    private static int calculateDuplicateNumberCount(Lotto customerLotto, List<Integer> winningNumber) {
        int count = 0;
        for (int i = 0; i < VALID_LOTTERY_NUMBER_LENGTH; i++) {
            if (customerLotto.isContain(winningNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    private static boolean isLottoContainBonusNumber(Lotto customerLotto, int bonusNumber) {
        return customerLotto.isContain(bonusNumber);
    }

    public static Map<Rank, Integer> calculateCountsByRanks(List<Rank> customerRanks) {
        Map<Rank, Integer> countsByRanks = new java.util.HashMap<>(Map.of(
                FIRST_PLACE, 0,
                SECOND_PLACE, 0,
                THIRD_PLACE, 0,
                FOURTH_PLACE, 0,
                FIFTH_PLACE, 0
        ));

        for (Rank rank : customerRanks) {
            if (rank != NONE) {
                countsByRanks.put(rank, countsByRanks.get(rank) + 1);
            }
        }
        return countsByRanks;
    }
}

