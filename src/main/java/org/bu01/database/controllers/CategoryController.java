package org.bu01.database.controllers;

import org.bu01.database.dto.CategoryDto;
import org.bu01.database.entities.Category;
import org.bu01.database.entities.CategoryType;
import org.bu01.database.repositories.CategoryRepository;
import org.bu01.database.repositories.CategoryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryTypeRepository categoryTypeRepository;

    @PostMapping("/create")
    ResponseEntity<?> createCategory(@RequestBody CategoryDto.RequestCategory category){
        if(categoryRepository.existsByCode(category.getCode())){
            return new ResponseEntity<>("Code existed!", HttpStatus.BAD_REQUEST);
        }
        if(categoryTypeRepository.existsByName(category.getCategoryType())){
            Category newCategory = new Category();
            newCategory.setName(category.getName());
            newCategory.setCode(category.getCode());
            newCategory.setEffectiveDate(category.getEffectiveDate());
            newCategory.setExpiredDate(category.getExpiredDate());
            newCategory.setDescription(category.getDescription());
            newCategory.setCategoryType(categoryTypeRepository.getCategoryTypeByName(category.getCategoryType()));
            categoryRepository.save(newCategory);
            return new ResponseEntity<>("Created!",HttpStatus.OK);
        }
        return new ResponseEntity<>("Bad request!",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/create-category-type")
    ResponseEntity<?> createCategoryType(@RequestBody CategoryType categoryType){
        if(categoryTypeRepository.existsByCode(categoryType.getCode())){
            return new ResponseEntity<>("Existed!", HttpStatus.BAD_REQUEST);
        }
        CategoryType newCategoryType = new CategoryType();
        newCategoryType.setCode(categoryType.getCode());
        newCategoryType.setName(categoryType.getName());
        categoryTypeRepository.save(newCategoryType);
        return new ResponseEntity<>("Created!", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateCategory(@PathVariable UUID id, @RequestBody CategoryDto.RequestCategory category){
        if(categoryRepository.existsById(id)){
            Category existCategory = categoryRepository.findById(id).get();
            if(categoryTypeRepository.existsByName(category.getCategoryType())){
                existCategory.setName(category.getName());
                existCategory.setCode(category.getCode());
                existCategory.setEffectiveDate(category.getEffectiveDate());
                existCategory.setExpiredDate(category.getExpiredDate());
                existCategory.setDescription(category.getDescription());
                existCategory.setCategoryType(categoryTypeRepository.getCategoryTypeByName(category.getCategoryType()));
                categoryRepository.save(existCategory);
                return new ResponseEntity<>("Updated!",HttpStatus.OK);

            }
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/remove/{id}")
    ResponseEntity<?> removeCategory(@PathVariable UUID id){
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return new ResponseEntity<>("Removed", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update-category-type/{id}")
    ResponseEntity<?> updateCategoryType(@PathVariable UUID id, @RequestBody CategoryType categoryType){
        if(categoryRepository.existsById(id)){
            CategoryType existedCategoryType = categoryTypeRepository.findCategoryTypeById(id);
            existedCategoryType.setName(categoryType.getName());
            existedCategoryType.setCode(categoryType.getCode());
            categoryTypeRepository.save(existedCategoryType);
            return new ResponseEntity<>("Updated!",HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/remove-category-type/{id}")
    ResponseEntity<?> removeCategoryType(@PathVariable UUID id){
        if(categoryTypeRepository.existsById(id)){
            categoryTypeRepository.deleteById(id);
            return new ResponseEntity<>("Removed!",HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }
    @GetMapping("/get-all")
    List<Category> getListCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/get-all-types")
    List<CategoryType> getListCategoryType(){
        return categoryTypeRepository.findAll();
    }
}
