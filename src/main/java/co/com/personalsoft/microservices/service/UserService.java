package co.com.personalsoft.microservices.service;

import co.com.personalsoft.microservices.model.AccountDTO;
import co.com.personalsoft.microservices.model.UserDTO;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;


public interface UserService {


    public Optional<UserDTO> getUserById(Integer id);


    public List<UserDTO> getAllUser();


    public List<UserDTO> getAllUserPageable(Pageable pageable);


    public UserDTO addUser(UserDTO userDTO);

    public UserDTO updateUser(UserDTO userDTO);


    public Boolean removeUser(Integer id);


    public List<AccountDTO> getUserAccounts(Integer id);


    public AccountDTO getUserAccountById(Integer id, Integer idAccount);

    public List<UserDTO> getByAgeGreaterThanAndGender(int age, String gender);
}
