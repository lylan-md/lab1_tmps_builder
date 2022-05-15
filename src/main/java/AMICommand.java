import java.util.ArrayList;

public class AMICommand {
    private final String action;
    private final ArrayList<AMICommandPart> commandParts;

    public AMICommand(String action, ArrayList<AMICommandPart> commandParts) {
        this.action = action;
        this.commandParts = commandParts;
    }

    public String getInSocketFormat() {
        StringBuilder stringBuilder = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");

        stringBuilder.append("Action: " + this.action + lineSeparator);

        for (AMICommandPart amiCommandPart: commandParts) {
            stringBuilder.append(amiCommandPart + lineSeparator);
        }

        return stringBuilder.toString();
    }
}
