package at.kaindorf.ahi18.bean;

import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Umweltschutzanalyse")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@lombok.Data
public class DataCollection {
    @XmlElementWrapper(name = "Messungen")
    @XmlElement(name="Messung")
    List<Data> data = new ArrayList<>();

    public static void main(String[] args) {
        File file = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "Weatherdata_xml", "allData.xml" ).toFile();

        DataCollection t = JAXB.unmarshal(file, DataCollection.class);
        t.getData().forEach(c -> System.out.println(c));
    }
}
