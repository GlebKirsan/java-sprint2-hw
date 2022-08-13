package commands;


import validation.YearSummaryValidator;

public class ValidateReportsData extends Command {
    private final YearSummaryValidator yearSummaryValidator;

    public ValidateReportsData(int order, String text) {
        super(order, text);
        yearSummaryValidator = new YearSummaryValidator();
    }

    @Override
    public void execute() {
        yearSummaryValidator.validate();
    }

}
