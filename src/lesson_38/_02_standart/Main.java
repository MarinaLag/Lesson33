package lesson_38._02_standart;

import java.io.*;

public class Main {
    public static final String PATH_TO_OUTPUT = "src/lesson_38/_resources/output.file";

    public static void main(String[] args) {
        System.out.println("Creation: ");
        Child child = new Child(1);

        try (FileOutputStream os = new FileOutputStream(PATH_TO_OUTPUT);
             ObjectOutputStream oos = new ObjectOutputStream(os);//завернет в файл
             FileInputStream is = new FileInputStream(PATH_TO_OUTPUT);
             ObjectInputStream ois = new ObjectInputStream(is)){// развернет
     //   ObjectInputStream input= new ObjectInputStream(new FileInputStream(PATH_TO_OUTPUT))) {

            System.out.println("Serialization: ");
            oos.writeObject(child);//превращаем в поток байт и записываем в объект

            System.out.println("DeSerialization: ");
            Child child1 = (Child) ois.readObject();//объявляем, что мы хотим получить
            // readObject - получает поток байт и переопределяем его к необходимому типу

            System.out.println(child1);// по умолчанию вызывается toString (который переопределен в классе)

        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }


    }
}
