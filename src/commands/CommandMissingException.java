package commands;

public class CommandMissingException extends RuntimeException {

    public CommandMissingException(String message) {
        super(message);
    }
}
