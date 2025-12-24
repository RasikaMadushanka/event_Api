package edu.icet.ecom.Controller;

import edu.icet.ecom.Model.Dto.category_dto;
import edu.icet.ecom.Model.Dto.event_dto;
import edu.icet.ecom.Service.category_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class category_Controller {
    @Autowired
    category_Service categoryService;

    @GetMapping("/all")
    public List<event_dto> getAllcategory() {
        return getAllcategory();
    }
    @PostMapping("/add")
    public void addCategory(@RequestBody category_dto category) {
        categoryService.addCategory(category);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<category_dto> updateEvent(@PathVariable String id, @RequestBody category_dto category) {
        category_dto updarecategory = categoryService.updateCategory(id, category);
        return ResponseEntity.ok(updarecategory);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id) {
       categoryService.deleteCategory(id);
    }
    }

