package co.com.personalsoft.microservices.service.impl;

import co.com.personalsoft.microservices.model.AccountDTO;
import co.com.personalsoft.microservices.model.UserDTO;
import co.com.personalsoft.microservices.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceCloudImpl implements UserService {
    @Override
    public Optional<UserDTO> getUserById(Integer id) {
        return null;
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
