package org.example.factory;

import org.example.poem.LogEntry;
import org.example.poem.LogReader;

public class Program {
    public static String data = """
У лукоморья дуб
Златая цепь
И днём
И ночью
Кот ходит
И орёт.""";
    
    public static void main(String[] args) {
        LogReader logReader = new ConcreteReaderCreator()
                .createLogReader(LogType.Poem, data);
        for (LogEntry log : logReader.readLogEntry()) {
            System.out.println(log.getText());
        }
    }
}
