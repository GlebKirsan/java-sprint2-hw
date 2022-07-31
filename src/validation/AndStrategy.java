package validation;

import java.util.List;

public class AndStrategy implements Strategy {
    private final List<Strategy> strategies;

    public AndStrategy(List<Strategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public boolean isTruthy() {
        return strategies.stream().anyMatch(Strategy::isTruthy);
    }
}
