/* 
Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
1.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

2.Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

3.** (Для преподавателя: если не успели выполнить задание 7, дать наводку из этого задания) Дана json строка (можно сохранить в файл и читать из файла)

[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода:

Студент Иванов получил 5 по предмету Математика.

Студент Петрова получил 4 по предмету Информатика.

Студент Краснов получил 5 по предмету Физика.

4*. Реализуйте простой калькулятор, с консольным интерфейсом. К калькулятору добавить логирование.
*/

package Java.dz2;

public class First {
    static String request = "select * from students";

    public static void main(String[] args) {
        String where = "";
        StringBuilder sb = new StringBuilder(where);
        one(sb);


        request += " WHERE " + sb + ";";
        System.out.println(request);
    }
    
    /*
    Если значение null, то параметр не должен попадать в запрос.
    Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
     */
    public static void one(StringBuilder sb) {
        String[] mas = {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"};

        for (String param : mas) {
            String part1 = param.split(":")[0];
            String part2 = param.split(":")[1];
            if (part2.equals("null") || part2.length() == 0){
                continue;
            }
            if (sb.length() != 0){
                sb.append(" AND ");
            }
            sb.append(part1 + " = " + part2);
        }
    }
}
