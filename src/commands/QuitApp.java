package commands;

public class QuitApp extends Command {
    private final int order;
    private final String text;
    public QuitApp(int order, String message) {
        this.order = order;
        text = message;
    }

    @Override
    String getText() {
        return text;
    }

    @Override
    public void execute() {
        throw new InterruptAppException("Прервать выполнение приложения.");
    }

    @Override
    int getOrder() {
        return order;
    }
}
