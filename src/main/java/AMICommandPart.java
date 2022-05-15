public class AMICommandPart {
    private final String commandPartName;
    private final String commandPartValue;

    public AMICommandPart(String commandPartName, String commandPartValue) {
        this.commandPartName = commandPartName;
        this.commandPartValue = commandPartValue;
    }

    @Override
    public String toString() {
        return this.commandPartName + ": " + this.commandPartValue;
    }
}
