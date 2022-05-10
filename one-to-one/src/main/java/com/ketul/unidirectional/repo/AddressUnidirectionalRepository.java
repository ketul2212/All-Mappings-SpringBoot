package com.ketul.unidirectional.repo;

import com.ketul.unidirectional.module.AddressUnidirectional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressUnidirectionalRepository extends JpaRepository<AddressUnidirectional, Long> {
}