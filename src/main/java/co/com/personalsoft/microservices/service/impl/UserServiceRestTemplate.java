package co.com.personalsoft.microservices.service.impl;
import co.com.personalsoft.microservices.model.AccountDTO;
import co.com.personalsoft.microservices.model.UserDTO;
import co.com.personalsoft.microservices.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Primary
@Service
public class UserServiceRestTemplate implements UserService {

    @Override
    public UserDTO getUserById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts/1";


        UserDTO user = restTemplate.getForObject(url,UserDTO.class);

        System.out.println(user);
        return  user;
    }

    @Override
    public List<UserDTO> getAllUser() {
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
}
