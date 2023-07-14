package org.bu01.database.repositories;

import org.bu01.database.entities.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryTypeRepository extends JpaRepository<CategoryType, UUID> {
    boolean existsByName(String name);
    CategoryType getCategoryTypeByName(String name);

    boolean existsByCode(String code);

    CategoryType findCategoryTypeById(UUID id);
}
