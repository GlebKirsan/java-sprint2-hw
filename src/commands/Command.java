package commands;

public abstract class Command {

    private final int order;

    private final String text;

    protected Command(int order, String text) {
        this.order = order;
        this.text = text;
    }

    @Override
    public String toString() {
        return getOrder() + ". " + getText();
    }

    public String getText() {
        return text;
    }

    public int getOrder() {
        return order;
    }

    public abstract void execute();
}
