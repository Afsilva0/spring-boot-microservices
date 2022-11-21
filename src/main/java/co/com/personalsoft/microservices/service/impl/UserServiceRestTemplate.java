package co.com.personalsoft.microservices.service.impl;

import co.com.personalsoft.microservices.model.AccountDTO;
import co.com.personalsoft.microservices.model.UserDTO;
import co.com.personalsoft.microservices.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceRestTemplate implements UserService {

    @Override
    public Optional<UserDTO> getUserById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        UserDTO user = restTemplate.getForObject(url, UserDTO.class);

        System.out.println(user);
        return Optional.ofNullable(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return null;
    }

    @Override
    public List<UserDTO> getAllUserPageable(Pageable pageable) {
        return null;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public Boolean removeUser(Integer id) {
        return null;
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
        return null;
    }
}
