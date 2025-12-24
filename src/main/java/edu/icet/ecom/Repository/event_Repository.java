package edu.icet.ecom.Repository;

import edu.icet.ecom.Model.Entity.event_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface event_Repository extends JpaRepository<event_entity, String> {

    Optional<event_entity> findById(String id);
}
