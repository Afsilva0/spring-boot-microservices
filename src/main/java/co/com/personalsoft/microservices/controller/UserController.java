package co.com.personalsoft.microservices.controller;

import co.com.personalsoft.microservices.miscellaneous.validator.group.GroupValidatorOnCreate;
import co.com.personalsoft.microservices.miscellaneous.validator.group.GroupValidatorOnUpdate;
import co.com.personalsoft.microservices.model.AccountDTO;
import co.com.personalsoft.microservices.model.UserDTO;
import co.com.personalsoft.microservices.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/prueba")
    public ResponseEntity<String> getPrueba() {
        log.error("error");
        log.info("info");
        log.debug("debug");
        log.trace("trace");

        return ResponseEntity.ok().body("Hola mundo");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {

        Optional<UserDTO> userDTO = userService.getUserById(id);

        if (userDTO.isPresent()) {
            Link withSelfRel = linkTo(methodOn(UserController.class).getUserById(userDTO.get().getId())).withSelfRel();
            userDTO.get().add(withSelfRel);
        }

        return ResponseEntity.ok().body(userDTO.orElse(null));
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

    @GetMapping("/pageable")
    public ResponseEntity<CollectionModel<UserDTO>> getAllUserPage(@RequestParam Integer page, @RequestParam Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        List<UserDTO> list = userService.getAllUserPageable(pageable);

        for (UserDTO userDTO : list) {
            Link withSelfRel = linkTo(methodOn(UserController.class).getUserById(userDTO.getId())).withSelfRel();
            userDTO.add(withSelfRel);

            Link accountRel = linkTo(methodOn(UserController.class).getUserAccounts(userDTO.getId())).withSelfRel();
            userDTO.add(accountRel);
        }

        Link link = linkTo(methodOn(UserController.class).getAllUserPage(page, size)).withSelfRel();
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

    @GetMapping("/getByAgeGreaterThanAndGender")
    public ResponseEntity<List<UserDTO>> getByAgeGreaterThanAndGender(@RequestParam int age, @RequestParam String gender) {
        return ResponseEntity.ok().body(userService.getByAgeGreaterThanAndGender(age, gender));
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
