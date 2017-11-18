package collectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class MyListImpl implements MyList {
    private List<String> elements;

    public MyListImpl() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int addElement(String element) {
        this.elements.add(0, element);
        return this.elements.indexOf(element);
    }

    @Override
    public String remove() {
        return this.elements.remove(0);
    }

    @Override
    public int size() {
        return this.elements.size();
    }
}
