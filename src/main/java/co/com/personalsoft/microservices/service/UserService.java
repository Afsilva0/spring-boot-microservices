package co.com.personalsoft.microservices.service;

import co.com.personalsoft.microservices.model.AccountDTO;
import co.com.personalsoft.microservices.model.UserDTO;


import java.util.List;


public interface UserService {


    public UserDTO getUserById(Integer id);


    public List<UserDTO> getAllUser();


    public UserDTO addUser(UserDTO userDTO);

    public UserDTO updateUser(UserDTO userDTO);


    public Boolean removeUser(Integer id);


    public List<AccountDTO> getUserAccounts(Integer id);


    public AccountDTO getUserAccountById(Integer id, Integer idAccount);
}
