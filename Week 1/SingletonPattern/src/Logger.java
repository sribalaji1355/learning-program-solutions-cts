public class Logger {
    private static Logger singleInstance;

    private Logger() {
        System.out.println("This is Logger Instance");
    }

    public static Logger getInstance() {
        if (singleInstance == null) {
            singleInstance = new Logger();
        }
        return singleInstance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
