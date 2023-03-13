package org.example;

import java.util.Arrays;
import java.util.List;

public class WordEngGame extends AbstractGame {
    @Override
    List<String> generateChatList() {
        String[] values = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        List<String> charList = Arrays.asList(values);
        return charList;
    }
}