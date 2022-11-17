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
public class AccountDTO extends RepresentationModel<AccountDTO> {

    private Integer id;

    private String flag;
}

