package lotto.model;

import static lotto.constants.LottoConstant.LOTTO_PRICE;
import static lotto.validator.ErrorMessages.INVALID_PAID_MONEY_ERROR_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    private Customer customer;
    private int paidMoney;

    @BeforeEach
    void setUp() {
        int paidMoney = 3000;
        customer = new Customer(paidMoney);
    }

    @Test
    @DisplayName("유효하지 않은 paidMoney 로 객체를 생성하면 객체가 생성되지 않고 예외를 반환한다.")
    void checkCustomerConstructorWithInvalidPaidMoney() {
        //given
        int invalidPaidMoney = LOTTO_PRICE + 1;

        //when, then
        assertThatThrownBy(() -> new Customer(invalidPaidMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PAID_MONEY_ERROR_MESSAGE);

    }

    @Test
    @DisplayName("로또 번호들에 따라 로또의 개수만큼 알맞은 순위를 반환한다.")
    void checkJudgeLottoRanks() {
        //given
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        //when
        List<Rank> ranks = customer.judgeLottoRanks(winningNumber, bonusNumber);

        //then
        assertEquals(ranks.size(), paidMoney / LOTTO_PRICE);
    }
}
