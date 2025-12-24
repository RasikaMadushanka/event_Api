package edu.icet.ecom.Repository;

import edu.icet.ecom.Model.Entity.category_entity;
import edu.icet.ecom.Model.Entity.event_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface category_Repository extends JpaRepository<category_entity, String> {
    Optional<category_entity> findById(String id);
}
