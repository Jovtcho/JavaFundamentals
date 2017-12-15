package p01_system_resources.implementations;

import p01_system_resources.interfaces.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}
