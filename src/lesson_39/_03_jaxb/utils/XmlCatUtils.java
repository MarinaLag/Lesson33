package lesson_39._03_jaxb.utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lesson_39._03_jaxb.model.CatAggregator;
import lesson_39._03_jaxb.model.CatJaxb;
import org.glassfish.jaxb.runtime.api.JAXBRIContext;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class XmlCatUtils {
    public static final String INPUT_FILE = "src/lesson_39/_03_jaxb/resources/inputcats.xml";
    public static final String OUTPUT_FILE = "src/lesson_39/_03_jaxb/resources/outcats.xml";

    public static List<CatJaxb> unmarshal() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(CatAggregator.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        CatAggregator catAggregator = (CatAggregator) unmarshaller.unmarshal(new FileReader(INPUT_FILE));
        return catAggregator.getCats();
    }




}
