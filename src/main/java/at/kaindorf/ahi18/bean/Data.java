package at.kaindorf.ahi18.bean;

import at.kaindorf.ahi18.xml.adapter.LocalDateAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Comparator;

@XmlRootElement(name="Messung")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@lombok.Data
public class Data implements Comparator {
    @XmlAttribute(name="Station")
    private String name;

    @XmlElement(name="Datum")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate date;

    @XmlElement(name="Tmin")
    private float tmin;
    @XmlElement(name="Tmax")
    private float tmax;
    @XmlElement(name="Niederschlagsmenge")
    private float precipitation;

    @Override
    public int compare(Object o1, Object o2) {
        Data data1 = (Data) o1;
        Data data2 = (Data) o2;
        return data1.getName().equals(data2.getName()) && data1.getDate().isEqual(data2.getDate()) ? 0 : data1.getDate().compareTo(data2.getDate()) ;
    }
}
