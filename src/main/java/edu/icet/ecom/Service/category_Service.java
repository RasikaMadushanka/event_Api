package edu.icet.ecom.Service;

import edu.icet.ecom.Model.Dto.category_dto;
import edu.icet.ecom.Model.Dto.event_dto;
import edu.icet.ecom.Model.Entity.category_entity;
import edu.icet.ecom.Model.Entity.event_entity;
import edu.icet.ecom.Repository.category_Repository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class category_Service {
    @Autowired
    category_Repository categoryRepository;
    ModelMapper modelMapper = new ModelMapper();

    public List<category_dto> getAllcategory() {
        List<category_entity> categoryList = categoryRepository.findAll();
        return categoryList.stream()
                .map((element) -> modelMapper.map(element, category_dto.class))
                .toList();
    }

    public void addCategory(category_dto category) {
        category_entity model = modelMapper.map(category, category_entity.class);
        categoryRepository.save(model);

    }



    public category_dto updateCategory(String id, category_dto category) {
        category_entity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Category not found with ID: " + id));
        categoryEntity.setName(category.getName());
        categoryEntity.setSlug(category.getSlug());
        category_entity updatedEntity = categoryRepository.save(categoryEntity);
        return modelMapper.map(updatedEntity, category_dto.class);
    }


    public void deleteCategory(String id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found with ID: " + id);
        }
    }
}
