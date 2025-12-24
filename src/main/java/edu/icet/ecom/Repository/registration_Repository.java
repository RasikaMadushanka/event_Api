package edu.icet.ecom.Repository;

import edu.icet.ecom.Model.Entity.event_entity;
import edu.icet.ecom.Model.Entity.registration_entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface registration_Repository extends JpaRepository<registration_entity,String> {
    Optional<registration_entity> findById(String id);
}
