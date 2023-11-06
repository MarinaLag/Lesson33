package lesson_39._03_jaxb;

import jakarta.xml.bind.JAXBException;
import lesson_39._03_jaxb.model.CatJaxb;

import static lesson_39._03_jaxb.utils.JaxbCatUtils.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<CatJaxb> cats = unmarshal();

            printCats(cats);

            marshall(cats);

        } catch (JAXBException | IOException e) {
            throw new RuntimeException();
        }
    }
}
