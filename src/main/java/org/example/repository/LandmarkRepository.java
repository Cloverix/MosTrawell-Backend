package org.example.repository;

import org.example.entity.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandmarkRepository extends JpaRepository<Landmark, Long> {
    List<Landmark> findAllByNameContainingIgnoreCase(String name);
    List<Landmark> findAllByAddressContainingIgnoreCase(String address);
}
