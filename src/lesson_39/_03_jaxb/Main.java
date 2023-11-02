package lesson_39._03_jaxb;

import jakarta.xml.bind.JAXBException;
import lesson_39._03_jaxb.model.CatJaxb;
import lesson_39._03_jaxb.utils.XmlCatUtils;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<CatJaxb> cats = XmlCatUtils.unmarshal();

            cats.forEach(System.out::println);
            
        }  catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
