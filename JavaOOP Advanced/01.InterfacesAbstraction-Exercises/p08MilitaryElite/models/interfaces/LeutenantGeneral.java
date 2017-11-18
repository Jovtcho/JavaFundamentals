package p08MilitaryElite.models.interfaces;

import java.util.Collection;

public interface LeutenantGeneral{
    void addPrivate(Private _private);
    Collection<Private> getPrivatesUnderCommand();
}
