package org.bu01.database.repositories;

import org.bu01.database.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
    boolean existsAllByName(String name);
    boolean existsByCode(String code);
    boolean existsAllById(UUID id);
    Organization findAllById(UUID id);
    Organization findAllByName(String name);
}
