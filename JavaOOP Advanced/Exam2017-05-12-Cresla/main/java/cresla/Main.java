package cresla;

import cresla.core.ManagerImpl;
import cresla.engine.Engine;
import cresla.entities.IdentifiableImpl;
import cresla.interfaces.*;
import cresla.io.ConsoleInputReader;
import cresla.io.ConsoleOutputWriter;
import cresla.repository.ReactorRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        InputReader reader = new ConsoleInputReader(bufferedReader);
        OutputWriter writer = new ConsoleOutputWriter();
        Identifiable identifiable = new IdentifiableImpl();
        Repository reactorRepository = new ReactorRepository();
        Manager manager = new ManagerImpl(identifiable, reactorRepository);
        Runnable engine = new Engine(reader, writer, manager);

        engine.run();
    }
}
