package familyTree;

import java.util.*;

public class Person {
    private String name;
    private String birthday;
    private Map<String, String> parents;
    private Map<String, String> children;

    public Person(String name, String birthday) {
        this.setName(name);
        this.setBirthday(birthday);
        this.setParents();
        this.setChildren();
    }

    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    void setName(String name) {
        this.name = name;
    }

    void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private void setParents() {
        this.parents = new LinkedHashMap<>();
    }

    private void setChildren() {
        this.children = new LinkedHashMap<>();
    }

    public void addParent(String name, String birthday) {
        this.parents.put(name, birthday);
    }

    public void addChild(String name, String birthday) {
        this.children.put(name, birthday);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.name).append(" ")
                .append(this.birthday).append(System.lineSeparator());
        sb.append("Parents:").append(System.lineSeparator());
        for (String parent : parents.keySet()) {
            sb.append(parent).append(" ").append(parents.get(parent)).append(System.lineSeparator());
        }
        sb.append("Children:").append(System.lineSeparator());
        for (String child : children.keySet()) {
            sb.append(child).append(" ").append(children.get(child)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}