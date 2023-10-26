package lesson_38._03_standart_compose;

import java.io.Serializable;
import java.util.StringJoiner;

public class StandardCat implements Serializable {
    static final long serialVersionUID = 1L;

    static String staticField = "Static";
    final String name;
    StandardBox box; // transient- выключает Serializable

    public StandardCat(String name, StandardBox box) {
        this.name = name;
        this.box = box;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "StandardCat " + "[", "]")
                .add("static='" + staticField + "'")
                .add("name='" + name + "'")
                .add("box=" + box)
                .toString();
    }
}
