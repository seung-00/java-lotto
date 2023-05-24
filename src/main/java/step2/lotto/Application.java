package step2.lotto;

import java.util.List;

import step1.calculator.domain.Calculator;
import step2.lotto.domain.LottoTicket;
import step2.lotto.domain.LottoTickets;
import step2.lotto.domain.LottoWinningStatistic;
import step2.lotto.domain.LottoWinningStatisticDto;

public class Application {

	public static void main(String[] args) {
		run();
	}

	public static void run() {
		int lottoCount = ready();

		LottoWinningStatisticDto lottoWinningStatisticDto = getLottoWinningStatisticDto(lottoCount);

		LottoUI.printLottoWinningStatistic(lottoWinningStatisticDto);
	}

	private static LottoWinningStatisticDto getLottoWinningStatisticDto(int lottoCount) {
		LottoTickets lottoTickets = LottoTickets.create();

		for (int i = 0; i < lottoCount; i++) {
			lottoTickets.add();
		}

		LottoUI.printLottoTickets(lottoTickets);

		List<Integer> numbers = LottoUI.uiForWinningNumbers();
		LottoWinningStatistic lottoWinningStatistic = LottoWinningStatistic.from(lottoTickets);
		LottoWinningStatisticDto lottoWinningStatisticDto = lottoWinningStatistic.calculateStatistic(LottoTicket.from(numbers));
		return lottoWinningStatisticDto;
	}

	private static int ready() {
		int lottoCount = LottoUI.uiForLottoPurchase();

		LottoTickets lottoTickets = LottoTickets.create();

		for (int i = 0; i < lottoCount; i++) {
			lottoTickets.add();
		}

		return lottoTickets;
	}

}
