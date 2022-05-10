package com.ketul.bidirectional.repo;

import com.ketul.bidirectional.module.AddressBidirectional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBidirectionalRepository extends JpaRepository<AddressBidirectional, Long> {
}