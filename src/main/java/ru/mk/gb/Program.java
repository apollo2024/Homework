package ru.mk.gb;

import ru.mk.gb.UI.ConsoleView;
import ru.mk.gb.models.Person;
import ru.mk.gb.services.AppExternalizable;

public class Program {
    public static final String FILE_JSON = "persons.json";
    private static final ConsoleView cv = new ConsoleView();

    public static void main(String[] args) {

        while (true) {
            try {
                switch (cv.menu()) {
                    // Сериализация данных
                    case 1 -> new AppExternalizable().serializationPerson(FILE_JSON, new Person(cv.inputFirstName(), cv.inputLastName(), cv.inputAge()));
                    // Десериализация данных
                    case 2 -> new AppExternalizable().deSerializationPerson(FILE_JSON);
                    // Закрытие приложения
                    case 0 -> System.exit(0);
                    default -> System.out.println("Некорректный ввод");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}