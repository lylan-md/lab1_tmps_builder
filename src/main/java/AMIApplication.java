public class AMIApplication {
    private final AMICommandPart application;
    private final AMICommandPart data;

    public AMIApplication(String application, String data) {
        this.application = new AMICommandPart("Application", application);
        this.data = new AMICommandPart("Data", data);
    }

    public AMICommandPart getApplication() {
        return this.application;
    }

    public AMICommandPart getData() {
        return this.data;
    }
}
