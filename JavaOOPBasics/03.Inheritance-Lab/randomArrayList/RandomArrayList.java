package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<Object> extends ArrayList<Object> {
    private Random rnd;

    RandomArrayList() {
        setRnd();
    }

    private void setRnd() {
        this.rnd = new Random();
    }

    Object getRandomElement() {
        int index = this.rnd.nextInt(super.size());
        Object element = super.get(index);
        super.remove(index);
        return element;
    }
}
