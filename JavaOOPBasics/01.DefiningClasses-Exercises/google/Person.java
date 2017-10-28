package google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    // “<Name> company <companyName> <department> <salary>”
    // “<Name> pokemon <pokemonName> <pokemonType>”
    // “<Name> parents <parentName> <parentBirthday>”
    // “<Name> children <childName> <childBirthday>”
    // “<Name> car <carModel> <carSpeed>”
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.company = new Company();
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = new Car();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.name).append(System.lineSeparator());
        sb.append(this.company.toString()).append(System.lineSeparator());
        sb.append(this.car.toString());
        sb.append("Pokemon:").append(System.lineSeparator());
        if (!this.pokemons.isEmpty()) {
            for (Pokemon pokemon : pokemons) {
                sb.append(pokemon.toString());
            }
        }
        sb.append("Parents:").append(System.lineSeparator());
        if (!this.parents.isEmpty()) {
            for (Parent parent : parents) {
                sb.append(parent.toString());
            }
        }
        sb.append("Children:").append(System.lineSeparator());
        if (!this.children.isEmpty()) {
            for (Child child : children) {
                sb.append(child.toString());
            }
        }
        return sb.toString();
    }

    class Company {
        private String companyName;
        private String department;
        private double salary;

        public Company() {
        }

        public Company(String companyName, String department, double salary) {
            this.companyName = companyName;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Company:");
            if (this.companyName == null && this.department == null && this.salary == 0) {
                return sb.toString();
            }
            sb.append(System.lineSeparator())
                    .append(String.format("%s %s %.2f", this.companyName, this.department, this.salary));
            return sb.toString();
        }
    }

    class Pokemon {
        private String pokemonName;
        private String pokemonType;

        public Pokemon(String pokemonName, String pokemonType) {
            this.pokemonName = pokemonName;
            this.pokemonType = pokemonType;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.pokemonName == null && this.pokemonType == null) {
                return sb.toString();
            }
            sb.append(String.format("%s %s%n", this.pokemonName, this.pokemonType));
            return sb.toString();
        }
    }

    class Parent {
        private String parentName;
        private String parentBirthday;

        public Parent(String parentName, String parentBirthday) {
            this.parentName = parentName;
            this.parentBirthday = parentBirthday;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.parentName == null && this.parentBirthday == null) {
                return sb.toString();
            }
            sb.append(String.format("%s %s%n", this.parentName, this.parentBirthday));
            return sb.toString();
        }
    }

    class Child {
        private String childName;
        private String childBirthday;

        public Child(String childName, String childBirthday) {
            this.childName = childName;
            this.childBirthday = childBirthday;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.childName == null && this.childBirthday == null) {
                return sb.toString();
            }
            sb.append(String.format("%s %s%n", this.childName, this.childBirthday));
            return sb.toString();
        }
    }

    class Car {
        private String carModel;
        private int carSpeed;

        public Car() {
        }

        public Car(String carModel, int carSpeed) {
            this.carModel = carModel;
            this.carSpeed = carSpeed;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Car:");
            if (this.carModel == null && this.carSpeed == 0) {
                return sb.append(System.lineSeparator()).toString();
            }
            sb.append(System.lineSeparator())
                    .append(String.format("%s %d%n", this.carModel, this.carSpeed));
            return sb.toString();
        }
    }
}
