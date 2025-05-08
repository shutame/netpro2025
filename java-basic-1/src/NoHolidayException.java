public class NoHolidayException extends Exception {
    public NoHolidayException(String message) {
        super(message);
    }

    public NoHolidayException(String message, Throwable cause) {
        super(message, cause);
    }
}
