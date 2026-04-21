package org.example.repository;

import org.example.entity.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LandmarkRepository extends JpaRepository<Landmark, Long> {
    List<Landmark> findAllByName(String name);
    List<Landmark> findAllByAddress(String address);
}
