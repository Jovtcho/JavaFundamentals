package collectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollectionImpl implements AddRemoveCollection {
    private List<String> elements;

    public AddRemoveCollectionImpl() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int addElement(String element) {
        this.elements.add(0, element);
        return this.elements.indexOf(element);
    }

    @Override
    public String remove() {
        return this.elements.remove(this.elements.size() - 1);
    }
}
