import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class Database {
    private Integer[] numbers;

    public Database(Integer... numbers) throws OperationNotSupportedException {
        this.setNumbers(numbers);
    }

    private void setNumbers(Integer[] numbers) throws OperationNotSupportedException {
        if (numbers.length > 16 || numbers.length < 1) {
            throw new OperationNotSupportedException();
        }
        this.numbers = new Integer[16];
        System.arraycopy(numbers, 0, this.numbers, 0, numbers.length);
    }

    public void add(Integer element) throws OperationNotSupportedException {
        if (element == null) {
            throw new OperationNotSupportedException();
        }

        int index = Arrays.asList(this.numbers).indexOf(null);
        if (index < 0) {
            throw new OperationNotSupportedException();
        }

        this.numbers[index] = element;
    }

    public void remove() throws OperationNotSupportedException {
        int index = Arrays.asList(this.numbers).indexOf(null);
        if (index == 0) {
            throw new OperationNotSupportedException();
        }

        this.numbers[index - 1] = null;
    }

    public Integer[] getNumbers() {
        int count = 0;
        for (Integer number : this.numbers) {
            if (number != null) {
                count++;
            }
        }
        Integer[] elements = new Integer[count];
        for (int index = 0; index < elements.length; index++) {
            elements[index] = this.numbers[index];
        }

        return elements;
    }
}
