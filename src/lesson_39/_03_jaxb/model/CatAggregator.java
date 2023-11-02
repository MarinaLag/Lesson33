package lesson_39._03_jaxb.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@XmlRootElement(name = "cats")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CatAggregator {
    @XmlAttribute(name = "cat")
    private List<CatJaxb> cats;
}
