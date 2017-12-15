package hell.repository;

import hell.interfaces.Hero;

import java.util.Map;

public interface Repository {
    void add(Hero hero);

    Hero getHeroByName(String heroName);

    Map<String, Hero> getAll();
}
