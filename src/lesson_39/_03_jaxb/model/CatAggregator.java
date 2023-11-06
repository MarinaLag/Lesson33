package lesson_39._03_jaxb.model;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.List;

@XmlRootElement(name = "cats")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CatAggregator {
    @XmlElement(name = "cat")
    private List<CatJaxb> cats;
}
