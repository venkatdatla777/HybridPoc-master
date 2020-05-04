package flextesting.utilities;

public class CommandFailedException extends Exception {

    private String output;
    private String error;

    public CommandFailedException(String command, String output, String error) {
        super(String.format("Execution of the command '%s' failed: %s", command, error));
        this.output = output;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public String getOutput() {
        return output;
    }
}