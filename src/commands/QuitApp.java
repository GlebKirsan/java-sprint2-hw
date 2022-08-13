package commands;

public class QuitApp extends Command {
    public QuitApp(int order, String message) {
        super(order, message);
    }

    @Override
    public void execute() {
        throw new InterruptAppException("Прервать выполнение приложения.");
    }

}
