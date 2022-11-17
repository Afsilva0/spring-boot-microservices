package co.com.personalsoft.microservices.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountryDTO extends RepresentationModel<CountryDTO> {

    private String isoCode;

    private  String name;

    private String flag;
}
