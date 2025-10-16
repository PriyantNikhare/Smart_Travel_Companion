package com.st.repository;

import com.st.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabRepository extends JpaRepository<Cab, Long> {
    // Find all cabs in a city that are currently available
    List<Cab> findByCityIgnoreCaseAndIsAvailableTrue(String city);
}
