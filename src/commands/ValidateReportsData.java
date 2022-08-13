package commands;


import validation.AndStrategy;
import validation.MonthValidationStrategy;
import validation.YearValidationStrategy;

import java.util.List;

public class ValidateReportsData extends Command {
    public ValidateReportsData(int order, String text) {
        super(order, text);
    }

    @Override
    public void execute() {
        new AndStrategy(
                List.of(new MonthValidationStrategy(),
                        new YearValidationStrategy())
        ).isTruthy();
        System.out.println("Сверка данных прошла успешно.");
    }

}
