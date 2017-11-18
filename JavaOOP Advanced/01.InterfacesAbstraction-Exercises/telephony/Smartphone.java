package telephony;

public class Smartphone implements Callable, Browseable {
    private static final String INVALID_NUMBER_MESSAGE = "Invalid number!";
    private static final String NUMBER_FORMAT_MESSAGE = "Calling... %s";
    private static final String INVALID_URL_MESSAGE = "Invalid URL!";
    private static final String URL_FORMAT_MESSAGE = "Browsing: %s!";

    public Smartphone() {
    }

    @Override
    public String browse(String url) {
        if (this.isContainDigit(url)) {
            return INVALID_URL_MESSAGE;
        } else {
            return String.format(URL_FORMAT_MESSAGE, url);
        }
    }

    @Override
    public String call(String number) {
        if (this.isContainOnlyNumbers(number)) {
            return String.format(NUMBER_FORMAT_MESSAGE, number);
        } else {
            return INVALID_NUMBER_MESSAGE;
        }
    }

    private boolean isContainOnlyNumbers(String number) {
        if (number != null && !number.isEmpty()) {
            for (char c : number.toCharArray()) {
                if (!Character.isDigit(c))
                    return false;
            }
        }

        return true;
    }

    private boolean isContainDigit(String url) {
        if (url != null && !url.isEmpty()) {
            for (char c : url.toCharArray()) {
                if (Character.isDigit(c)) {
                    return true;
                }
            }
        }

        return false;
    }
}
