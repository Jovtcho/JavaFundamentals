package militaryElite.interfaces;

import militaryElite.implementations.Private;

import java.util.List;
import java.util.Map;

public interface ILeutenantGeneral extends IPrivate{
    List<Private> getPrivates();

    void addPrivate(Private privateSoldier);
}
