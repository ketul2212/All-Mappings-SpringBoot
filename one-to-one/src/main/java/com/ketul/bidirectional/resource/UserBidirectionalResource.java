package com.ketul.bidirectional.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ketul.bidirectional.module.AddressBidirectional;
import com.ketul.bidirectional.module.UserBidirectional;
import com.ketul.bidirectional.module.dto.UserBidirectionalRequestDto;
import com.ketul.bidirectional.service.UserBidirectionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/bidirectional")
public class UserBidirectionalResource {

    @Autowired
    private UserBidirectionalService userBidirectionalService;

    @Transactional
    @PostMapping("/save")
    public UserBidirectional saveUserBidirectional(@RequestBody UserBidirectionalRequestDto userBidirectionalRequestDto) {
        return userBidirectionalService.saveUserBidirectional(userBidirectionalRequestDto);
    }

    @GetMapping("/getAll")
    public List<UserBidirectional> getAllUserBidirectional() {
        return userBidirectionalService.getAllUserBidirectional();
    }

    @GetMapping("/getUser/{email}")
    public UserBidirectional getUserBidirectional(@PathVariable String email) {
        return userBidirectionalService.getUserBidirectional(email);
    }

    @PutMapping("/update/{email}")
    public UserBidirectional updateUserBidirectional(@PathVariable String email, @RequestBody UserBidirectionalRequestDto userBidirectionalRequestDto) {
        return userBidirectionalService.updateUserBidirectional(email, userBidirectionalRequestDto);
    }

    @DeleteMapping("delete/{email}")
    public String deleteUserBidirectional(@PathVariable String email) {
        return userBidirectionalService.deleteUserBidirectional(email);
    }
}
