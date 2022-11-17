package co.com.personalsoft.microservices.controller;

import co.com.personalsoft.microservices.miscellaneous.validator.group.GroupValidatorOnCreate;
import co.com.personalsoft.microservices.miscellaneous.validator.group.GroupValidatorOnUpdate;
import co.com.personalsoft.microservices.model.AccountDTO;
import co.com.personalsoft.microservices.model.UserDTO;
import co.com.personalsoft.microservices.service.UserService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {

        UserDTO userDTO = userService.getUserById(id);

        Link withSelfRel = linkTo(methodOn(UserController.class).getUserById(userDTO.getId())).withSelfRel();
        userDTO.add(withSelfRel);

        return ResponseEntity.ok().body(userDTO);
    }


    @GetMapping
    public ResponseEntity<CollectionModel<UserDTO>> getAllUser() {

        List<UserDTO> list = userService.getAllUser();

        for (UserDTO userDTO : list) {
            Link withSelfRel = linkTo(methodOn(UserController.class).getUserById(userDTO.getId())).withSelfRel();
            userDTO.add(withSelfRel);

            Link accountRel = linkTo(methodOn(UserController.class).getUserAccounts(userDTO.getId())).withSelfRel();
            userDTO.add(accountRel);
        }

        Link link = linkTo(methodOn(UserController.class).getAllUser()).withSelfRel();
        CollectionModel<UserDTO> result = CollectionModel.of(list, link);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@Validated(value = {GroupValidatorOnCreate.class}) @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.addUser(userDTO));
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@Validated(value = {GroupValidatorOnUpdate.class, GroupValidatorOnCreate.class}) @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.updateUser(userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> removeUser(@PathVariable Integer id) {
        return ResponseEntity.ok().body(userService.removeUser(id));
    }


    @GetMapping("/{id}/accounts")
    public ResponseEntity<List<AccountDTO>> getUserAccounts(@PathVariable Integer id) {
        return ResponseEntity.ok().body(userService.getUserAccounts(id));
    }

    @GetMapping("/{id}/accounts/{idAccount}")
    public ResponseEntity<AccountDTO> getUserAccountById(@PathVariable Integer id, @PathVariable Integer idAccount) {
        return ResponseEntity.ok().body(userService.getUserAccountById(id, idAccount));
    }
}
