package co.com.personalsoft.microservices.service.impl;

import co.com.personalsoft.microservices.dao.entities.UserEntity;
import co.com.personalsoft.microservices.model.AccountDTO;
import co.com.personalsoft.microservices.model.UserDTO;
import co.com.personalsoft.microservices.dao.repository.UserRepository;
import co.com.personalsoft.microservices.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/* @Primary le da priorida a la implementación sobre otras
 */
@Primary

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

    private UserRepository userRepository;
    private ModelMapper mapper = new ModelMapper();


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDTO> getUserById(Integer id) {

        Optional<UserEntity> userEntity = userRepository.findById(id);

        if (userEntity.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(convertToDTO(userEntity.get()));
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserEntity> listUserEntity = userRepository.findAll();
        List<UserDTO> listUserDTO = listUserEntity.stream().map(this::convertToDTO).collect(Collectors.toList());
        return listUserDTO;
    }

    @Override
    public List<UserDTO> getAllUserPageable(Pageable pageable) {
        List<UserEntity> listUserEntity = userRepository.findAll(pageable).getContent();
        List<UserDTO> listUserDTO = listUserEntity.stream().map(this::convertToDTO).collect(Collectors.toList());
        return listUserDTO;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        UserEntity userEntity = userRepository.save(convertToEntity(userDTO));
        return convertToDTO(userEntity);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity userEntity = userRepository.save(convertToEntity(userDTO));
        return convertToDTO(userEntity);
    }

    @Override
    public Boolean removeUser(Integer id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<AccountDTO> getUserAccounts(Integer id) {
        return null;
    }

    @Override
    public AccountDTO getUserAccountById(Integer id, Integer idAccount) {
        return null;
    }


    @Override
    public List<UserDTO> getByAgeGreaterThanAndGender(int age, String gender) {
        List<UserEntity> listUserEntity = userRepository.findByAgeGreaterThanAndGender(age, gender);
        List<UserDTO> listUserDTO = listUserEntity.stream().map(this::convertToDTO).collect(Collectors.toList());
        return listUserDTO;
    }

    private UserDTO convertToDTO(UserEntity userEntity) {
        return mapper.map(userEntity, UserDTO.class);
    }

    private UserEntity convertToEntity(UserDTO userDTO) {
        return mapper.map(userDTO, UserEntity.class);
    }
}
