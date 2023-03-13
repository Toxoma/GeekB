package org.example;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class History {
    List <String> list = new ArrayList<>();
    public void addAction(String value){
        this.list.add(value);
    }

    public void showHistory(){
        System.out.println("История:");
        for (int i = 0; i < this.list.size(); i++) {
            System.out.printf("%d) %s\n", i+1, this.list.get(i));
        }
        System.out.println("Конец истории.");
    }
}
