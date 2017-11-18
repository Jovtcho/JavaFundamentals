package collectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddCollectionImpl implements AddCollection {
    private List<String> elements;

    public AddCollectionImpl() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int addElement(String element) {
        this.elements.add(element);
        return this.elements.lastIndexOf(element);
    }
}
