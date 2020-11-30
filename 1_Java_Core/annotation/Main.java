package annotation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("" + field.isAnnotationPresent(MyAnnotation.class));
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                saveFieldsInFile();
            }
        }
    }

    public static void saveFieldsInFile() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("E:/Java/save.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.flush();
            System.out.println("Fields were written !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}