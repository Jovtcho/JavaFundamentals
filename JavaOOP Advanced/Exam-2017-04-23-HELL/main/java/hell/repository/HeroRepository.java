package hell.repository;

import hell.interfaces.Hero;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class HeroRepository implements Repository {
    private Map<String, Hero> heroRepository;

    public HeroRepository() {
        this.heroRepository = new LinkedHashMap<>();
    }

    @Override
    public void add(Hero hero) {
        this.heroRepository.put(hero.getName(), hero);
    }

    @Override
    public Hero getHeroByName(String heroName) {
        return this.heroRepository.get(heroName);
    }

    @Override
    public Map<String, Hero> getAll() {
        return Collections.unmodifiableMap(this.heroRepository);
    }
}
