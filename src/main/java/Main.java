public class Main {
    public static void main(String[] args) {
        OriginateAMICommandBuilder originateAMICommandBuilder = new OriginateAMICommandBuilder();

        AMICommand amiCommand = originateAMICommandBuilder
                .setActionId("ABC45678901234567890")
                .setChannel("SIP/1234/68467117")
                .setTimeout(20000)
                .addApplications(new AMIApplication("PlayBack", "hello-world"))
                .build();

        System.out.println(amiCommand.getInSocketFormat());
    }
}
