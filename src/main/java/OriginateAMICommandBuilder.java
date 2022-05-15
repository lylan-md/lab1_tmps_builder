import java.util.ArrayList;

public class OriginateAMICommandBuilder implements AMICommandBuilderInterface {

    private final String action = "Originate";

    private String actionId = null;
    private String channel = null;
    private String exten = null;
    private String context = null;
    private int timeout = 0;
    private ArrayList<AMIApplication> applications = new ArrayList<>();

    public OriginateAMICommandBuilder setActionId(String actionId) {
        this.actionId = actionId;
        return this;
    }

    public OriginateAMICommandBuilder setChannel(String channel) {
        this.channel = channel;
        return this;
    }

    public OriginateAMICommandBuilder setExten(String exten) {
        this.exten = exten;
        return this;
    }

    public OriginateAMICommandBuilder setContext(String context) {
        this.context = context;
        return this;
    }

    public OriginateAMICommandBuilder setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public OriginateAMICommandBuilder addApplications(AMIApplication amiApplication) {
        this.applications.add(amiApplication);
        return this;
    }

    public OriginateAMICommandBuilder reset() {
        this.actionId = null;
        this.channel = null;
        this.exten = null;
        this.context = null;
        this.timeout = 0;
        this.applications.clear();
        return this;
    }

    public AMICommand build() {
        ArrayList<AMICommandPart> amiCommandParts = new ArrayList<>();

        if (actionId != null) {
            amiCommandParts.add(new AMICommandPart("ActionID", this.actionId));
        }

        if (channel != null) {
            amiCommandParts.add(new AMICommandPart("Channel", this.channel));
        }

        if (exten != null) {
            amiCommandParts.add(new AMICommandPart("Exten", this.exten));
        }

        if (context != null) {
            amiCommandParts.add(new AMICommandPart("Context", this.context));
        }

        if (timeout != 0) {
            amiCommandParts.add(new AMICommandPart("Timeout", Integer.toString(this.timeout)));
        }

        for(AMIApplication application: applications) {
            amiCommandParts.add(application.getApplication());
            amiCommandParts.add(application.getData());
        }

        return new AMICommand(this.action, amiCommandParts);
    }
}
