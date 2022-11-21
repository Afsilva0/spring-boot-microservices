package co.com.personalsoft.microservices.dao.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Paises")
public class CountryEntity extends RepresentationModel<CountryEntity> {

    @Id
    private String isoCode;

    private  String name;

    private String flag;
}
