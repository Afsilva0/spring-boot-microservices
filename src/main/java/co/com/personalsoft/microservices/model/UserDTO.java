package co.com.personalsoft.microservices.model;


import co.com.personalsoft.microservices.miscellaneous.validator.CustomValidator;
import co.com.personalsoft.microservices.miscellaneous.validator.group.GroupValidatorOnCreate;
import co.com.personalsoft.microservices.miscellaneous.validator.group.GroupValidatorOnUpdate;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO extends RepresentationModel<UserDTO> {

    @NotNull(message = "{app.field.id.notnull.error}", groups = GroupValidatorOnUpdate.class)
    private Integer id;

    @NotNull(message = "{app.field.document.notnull.error}", groups = GroupValidatorOnCreate.class)
    private String document;

    @NotNull(message = "{app.field.name.notnull.error}", groups = GroupValidatorOnCreate.class)
    private String name;

    private String lastName;

    @CustomValidator(groups = GroupValidatorOnUpdate.class)
    @Min(value = 18, message = "{app.field.edad.min.error}",
            groups = GroupValidatorOnCreate.class)
    private int age;

    @Size(max = 1,groups = GroupValidatorOnCreate.class)
    private String gender;
}
