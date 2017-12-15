package p01_EventImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Dispatcher dispatcher = new Dispatcher("");
        NameChangeListener handler1 = new Handler();
        //NameChangeListener handler2 = new Handler();
        dispatcher.addNameChangeListener(handler1);
        //dispatcher.addNameChangeListener(handler2);

        while (true) {
            String name = br.readLine();
            if ("End".equalsIgnoreCase(name)) {
                break;
            }

            dispatcher.fireNameChangeEvent(new NameChange(name));
        }
    }
}
