package co.com.personalsoft.microservices.service.impl;

import co.com.personalsoft.microservices.model.AccountDTO;
import co.com.personalsoft.microservices.model.UserDTO;
import co.com.personalsoft.microservices.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/* @Primary le da priorida a la implementación sobre otras
 */
//@Primary

/* @ConditionalOnProperty se usa para crear condiciones
 * Dependiendo de configuración  del properties
 */
//@ConditionalOnProperty(prefix = "app",name = "bd",havingValue = "mysql")

/* @Qualifier le asigna un nombre a la implementación
 * Cuyo nombre se puede usar en los controladores cuando se realiza la inyección de dependencias
 */
//@Qualifier("PrimeraImpl")

/* @Lazy se utiliza para que las implementaciones se cargen de forma perezosa
 * No se carge la implementación al iniciar el proyecto
 * Se usa para implementaciones no se use mas
 */
//@Lazy

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO getUserById(Integer id) {
        return new UserDTO(1, "ANDRES", "SILVA", 24);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return List.of(new UserDTO(1, "ANDRES", "SILVA", 24), new UserDTO(2, "PAOLA", "SILVA", 23), new UserDTO(3, "GIOVANNA", "GUZMAN", 38));
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        return new UserDTO(1, "ANDRES", "SILVA", 24);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return new UserDTO(1, "ANDRES", "SILVA", 24);
    }

    @Override
    public Boolean removeUser(Integer id) {
        return true;
    }

    @Override
    public List<AccountDTO> getUserAccounts(Integer id) {
        return null;
    }

    @Override
    public AccountDTO getUserAccountById(Integer id, Integer idAccount) {
        return null;
    }
}
