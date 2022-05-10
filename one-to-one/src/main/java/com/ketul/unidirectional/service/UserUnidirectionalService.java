package com.ketul.unidirectional.service;

import com.ketul.exception.UserNotFoundException;
import com.ketul.unidirectional.module.AddressUnidirectional;
import com.ketul.unidirectional.module.UserUnidirectional;
import com.ketul.unidirectional.module.dto.UserUnidirectionalRequestDto;
import com.ketul.unidirectional.repo.UserUnidirectionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserUnidirectionalService {

    @Autowired
    private UserUnidirectionalRepository userUnidirectionalRepository;

    public UserUnidirectional saveUser(UserUnidirectionalRequestDto userUnidirectionalRequestDto) {

        AddressUnidirectional addressUnidirectional = new AddressUnidirectional();
        addressUnidirectional.setEmail(userUnidirectionalRequestDto.getEmail());

        UserUnidirectional userUnidirectional = new UserUnidirectional();
        userUnidirectional.setName(userUnidirectionalRequestDto.getName());
        userUnidirectional.setAddressUnidirectional(addressUnidirectional);

        return userUnidirectionalRepository.save(userUnidirectional);
    }

    public List<UserUnidirectional> getAllUserUnidirectional() {
        return userUnidirectionalRepository.findAll();
    }

    public UserUnidirectional getUserUnidirectional(String email) {
        return userUnidirectionalRepository.findByAddressUnidirectional_Email(email);
    }

    public UserUnidirectional updateUserUnidirectional(String email, UserUnidirectionalRequestDto userUnidirectionalRequestDto) {
        UserUnidirectional userUnidirectional = userUnidirectionalRepository.findByAddressUnidirectional_Email(email);

        if(userUnidirectional == null)
            throw new UserNotFoundException("User is not present");
        else {
            userUnidirectional.setName(userUnidirectionalRequestDto.getName());
            userUnidirectional.getAddressUnidirectional().setEmail(userUnidirectionalRequestDto.getEmail());
            return userUnidirectionalRepository.save(userUnidirectional);
        }
    }

    @Transactional
    public String deleteUserUnidirectional(String email) {
        UserUnidirectional userUnidirectional = userUnidirectionalRepository.findByAddressUnidirectional_Email(email);

        if(userUnidirectional == null)
            return "User Not Found";
        else {
            userUnidirectionalRepository.deleteByName(userUnidirectional.getName());
            return "Record is successfully deleted.";
        }
    }
}