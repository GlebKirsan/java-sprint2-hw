package commands;


import validation.AndStrategy;
import validation.MonthValidationStrategy;
import validation.YearValidationStrategy;

import java.util.List;

public class ValidateReportsData extends Command {
    private final int order;
    private final String text;

    public ValidateReportsData(int order, String text) {
        this.order = order;
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void execute() {
        new AndStrategy(
                List.of(new MonthValidationStrategy(),
                        new YearValidationStrategy())
        ).isTruthy();
        System.out.println("Сверка данных прошла успешно.");
    }

    @Override
    public int getOrder() {
        return order;
    }

}
