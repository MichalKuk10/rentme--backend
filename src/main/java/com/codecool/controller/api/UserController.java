package com.codecool.controller.api;

import com.codecool.converter.AppUserConverter;
import com.codecool.model.AppUser;
import com.codecool.modelDTO.UserAddressDTO;
import com.codecool.modelDTO.AppUserDTO;
import com.codecool.modelDTO.UserNameDTO;
import com.codecool.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;


@Controller
@CrossOrigin
@RestController
@RequestMapping("/users/")
public class UserController {

    private UserService userService;
    private AppUserConverter appUserConverter;

    public UserController(UserService userService, AppUserConverter appUserConverter) {
        this.userService = userService;
        this.appUserConverter = appUserConverter;
    }

    
    @GetMapping(value = "/admins/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<AppUserDTO> getAllAdmins() {
        return appUserConverter.entitiesToDTO(userService.getAllAdmins());
    }


    @GetMapping(value = "/renters/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public List<AppUserDTO> getAllRenters() {
        return appUserConverter.entitiesToDTO(userService.getAllRenters());
    }

    @GetMapping(value = "/renters/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public AppUserDTO findUserById(@PathVariable("id") Long id) {
        return appUserConverter.entityToDTO(userService.getUserById(id));
    }


    @GetMapping(value = "/admins/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public AppUserDTO findAdminById(@PathVariable("id") Long id) {
        return appUserConverter.entityToDTO(userService.getUserById(id));
    }


    @GetMapping(value = "/address/item/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public UserAddressDTO findUserAddressByItemId(@PathVariable("id") Long id) {
        return userService.getUserAddressByItemId(id);
    }


    @GetMapping(value = "/users/find-by/item/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    public UserNameDTO findUserNameByItemId(@PathVariable("id") Long id) {
        return userService.getUserNameByItemId(id);
    }


    @PostMapping()
    @ResponseBody
    @ResponseStatus(CREATED)
    public void addUser(@RequestBody AppUser appUser) {
        userService.addUser(appUser);
    }


    @PutMapping
    @ResponseBody
    @ResponseStatus(OK)
    public void updateUser(@RequestBody AppUser appUser) {
        userService.updateUser(appUser);
    }


    @DeleteMapping
    @ResponseBody
    @ResponseStatus(NO_CONTENT)
    public void deleteAppUser(long id) {
        userService.deleteUser(id);
    }

}
