package org.example.factory;

import org.example.poem.LogReader;

public abstract class BaseLogReaderCreator {
    protected LogReader createLogReader(LogType logType, Object data){
        LogReader logReader = createLogReaderInstance(logType);
        logReader.setDataSource(data);
        logReader.setCurrentPosition(2);
        return logReader;
    }
    protected abstract LogReader createLogReaderInstance(LogType logType);
}
