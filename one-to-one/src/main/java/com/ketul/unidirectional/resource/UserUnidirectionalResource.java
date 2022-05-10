package com.ketul.unidirectional.resource;

import com.ketul.unidirectional.module.UserUnidirectional;
import com.ketul.unidirectional.module.dto.UserUnidirectionalRequestDto;
import com.ketul.unidirectional.service.UserUnidirectionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/unidirectional")
public class UserUnidirectionalResource {

    @Autowired
    private UserUnidirectionalService userUnidirectionalService;

    @PostMapping("/save")
    public UserUnidirectional saveUser(@Valid @RequestBody UserUnidirectionalRequestDto userUnidirectionalRequestDto) {
        return userUnidirectionalService.saveUser(userUnidirectionalRequestDto);
    }

    @GetMapping("/getAll")
    public List<UserUnidirectional> getAllUserUnidirectional() {
        return userUnidirectionalService.getAllUserUnidirectional();
    }

    @GetMapping("/getUser/{email}")
    public UserUnidirectional getUserUnidirectional(@PathVariable String email) {
        return userUnidirectionalService.getUserUnidirectional(email);
    }

    @PutMapping("/update/{email}")
    public UserUnidirectional updateUserUnidirectional(@PathVariable String email, @RequestBody UserUnidirectionalRequestDto userUnidirectionalRequestDto) {
        return userUnidirectionalService.updateUserUnidirectional(email, userUnidirectionalRequestDto);
    }

    @DeleteMapping("delete/{email}")
    public String deleteUserUnidirectional(@PathVariable String email) {
        return userUnidirectionalService.deleteUserUnidirectional(email);
    }
}