package com.ketul.bidirectional.service;

import com.ketul.bidirectional.module.AddressBidirectional;
import com.ketul.bidirectional.module.UserBidirectional;
import com.ketul.bidirectional.module.dto.UserBidirectionalRequestDto;
import com.ketul.bidirectional.repo.UserBidirectionalRepository;
import com.ketul.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserBidirectionalService {

    @Autowired
    private UserBidirectionalRepository userBidirectionalRepository;

    public UserBidirectional saveUserBidirectional(UserBidirectionalRequestDto userBidirectionalRequestDto) {

        AddressBidirectional addressBidirectional = new AddressBidirectional();
        addressBidirectional.setEmail(userBidirectionalRequestDto.getEmail());

        UserBidirectional userBidirectional = new UserBidirectional();
        userBidirectional.setName(userBidirectionalRequestDto.getName());

        addressBidirectional.setUserBidirectional(userBidirectional);
        userBidirectional.setAddressBidirectional(addressBidirectional);

        return userBidirectionalRepository.save(userBidirectional);
    }

    public List<UserBidirectional> getAllUserBidirectional() {
        return userBidirectionalRepository.findAll();
    }

    public UserBidirectional getUserBidirectional(String email) {
        UserBidirectional userBidirectional = userBidirectionalRepository.findByAddressBidirectional_Email(email);

        if(userBidirectional == null)
            throw new UserNotFoundException("User is not Found");
        return userBidirectional;
    }

    public UserBidirectional updateUserBidirectional(String email, UserBidirectionalRequestDto userBidirectionalRequestDto) {
        UserBidirectional userBidirectional = userBidirectionalRepository.findByAddressBidirectional_Email(email);

        if(userBidirectional == null)
            throw new UserNotFoundException("User Not Found");
        else {
            userBidirectional.setName(userBidirectionalRequestDto.getName());
            userBidirectional.getAddressBidirectional().setEmail(userBidirectionalRequestDto.getEmail());
            userBidirectional.getAddressBidirectional().setUserBidirectional(userBidirectional);

            return userBidirectionalRepository.save(userBidirectional);
        }
    }

    @Transactional
    public String deleteUserBidirectional(String email) {
        UserBidirectional userBidirectional = userBidirectionalRepository.findByAddressBidirectional_Email(email);

        if(userBidirectional == null)
            throw new UserNotFoundException("User Not Found");
        else {
            userBidirectionalRepository.deleteByName(userBidirectional.getName());
            return "Record is successfully deleted.";
        }
    }
}