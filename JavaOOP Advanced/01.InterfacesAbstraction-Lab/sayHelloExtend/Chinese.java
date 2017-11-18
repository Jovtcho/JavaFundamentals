package sayHelloExtend;

public class Chinese extends BasePerson implements Person{
    Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djiga Djiga!";
    }
}
