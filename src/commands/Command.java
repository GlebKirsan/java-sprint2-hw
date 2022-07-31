package commands;

public abstract class Command {

    @Override
    public String toString() {
        return getOrder() + ". " + getText();
    }

    abstract String getText();

    public abstract void execute();

    abstract int getOrder();
}
