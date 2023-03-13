package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {
    private Integer cows;
    private Integer bulls;
    private String userInput;

    public void result() {
        System.out.printf("Кол-во коров: %d, Кол-во быков: %d\n", this.getCows(), this.getBulls());
    }
}
