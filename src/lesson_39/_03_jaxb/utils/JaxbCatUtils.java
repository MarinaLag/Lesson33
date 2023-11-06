package lesson_39._03_jaxb.utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lesson_39._03_jaxb.model.CatAggregator;
import lesson_39._03_jaxb.model.CatJaxb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JaxbCatUtils {
    public static final String INPUT_FILE = "src/lesson_39/_03_jaxb/resources/inputcats.xml";
    public static final String OUTPUT_FILE = "src/lesson_39/_03_jaxb/resources/outcats.xml";

    //считывает
    public static List<CatJaxb> unmarshal() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(CatAggregator.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        CatAggregator catAggregator = (CatAggregator) unmarshaller.unmarshal(new FileReader(INPUT_FILE));
        return catAggregator.getCats();
        //мы должны получить какойто объект типа catAggregator
    }

    //записывает (из кота получим xml )
    public static void marshall(List<CatJaxb> cats) throws JAXBException, IOException {
        CatAggregator aggregator = new CatAggregator();
        aggregator.setCats(cats);
        JAXBContext context = JAXBContext.newInstance(CatAggregator.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(aggregator, new FileWriter(OUTPUT_FILE));
    }

    public static void printCats(List<CatJaxb> cats) {
        cats.forEach(System.out::println);
    }

}
