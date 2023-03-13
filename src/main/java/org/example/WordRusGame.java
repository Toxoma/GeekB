package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordRusGame extends AbstractGame {
    @Override
    List<String> generateChatList() {
        String[] values = new String[]{"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "э", "ю", "я"};
        List<String> charList = Arrays.asList(values);
        return charList;
    }
}