package collectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class MyCollection {
    private List<String> elements;

    protected MyCollection(List<String> elements) {
        this.elements = new ArrayList<>();
    }


}
