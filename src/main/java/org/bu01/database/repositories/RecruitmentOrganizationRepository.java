package org.bu01.database.repositories;

import org.bu01.database.entities.RecruitmentOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecruitmentOrganizationRepository extends JpaRepository<RecruitmentOrganization, UUID> {
    RecruitmentOrganization findAllById(UUID id);
}
