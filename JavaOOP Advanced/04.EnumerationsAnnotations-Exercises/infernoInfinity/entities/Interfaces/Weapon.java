package infernoInfinity.entities.Interfaces;

import infernoInfinity.annotations.CustomAnnotation;
import infernoInfinity.enumerations.GemType;

@CustomAnnotation
public interface Weapon extends Comparable<Weapon> {
    void addGem(GemType gem, int index);

    void removeGem(int index);

    double getItemLevel();

    String print();
}
