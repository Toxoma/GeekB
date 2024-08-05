package org.example.poem;

public class Main {
    public static String data = """
У лукоморья дуб
Златая цепь
И днём
И ночью
Кот ходит
И орёт.""";

    public static void main(String[] args) {
        LogReader logReader = new PoemReader(data);
        logReader.setCurrentPosition(3);

        for (LogEntry log : logReader.readLogEntry()){
            System.out.println(log.getText());
        }
    }
}