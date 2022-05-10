package com.ketul.unidirectional.repo;

import com.ketul.unidirectional.module.UserUnidirectional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserUnidirectionalRepository extends JpaRepository<UserUnidirectional, Long> {
    public UserUnidirectional findByAddressUnidirectional_Email(String email);

    public String deleteByName(String name);
}