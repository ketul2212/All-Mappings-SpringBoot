package com.ketul.bidirectional.repo;

import com.ketul.bidirectional.module.UserBidirectional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBidirectionalRepository extends JpaRepository<UserBidirectional, Long> {
    String deleteByName(String name);
    UserBidirectional findByAddressBidirectional_Email(String email);
}