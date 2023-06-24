package com.project.graduation.repository;

import com.project.graduation.domain.registrant.Registrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrantRepository extends JpaRepository<Registrant, Long> {
    @Query("SELECT e FROM registrant e WHERE e.user_id = :variableValue")
    List<Registrant> findByVariable(@Param("variableValue") String variableValue);
}
