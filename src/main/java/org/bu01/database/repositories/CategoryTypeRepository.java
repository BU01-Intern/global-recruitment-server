package org.bu01.database.repositories;

import org.bu01.database.entities.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryTypeRepository extends JpaRepository<CategoryType, UUID> {
}
