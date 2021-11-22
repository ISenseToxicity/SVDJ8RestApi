package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.CategoryDAO;
import nl.hsleiden.svdj8.models.tables.Category;
import nl.hsleiden.svdj8.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    public final CategoryDAO categoryDAO;

    @Autowired
    public final CategoryRepository categoryRepository;

    public CategoryController(CategoryDAO categoryDAO, CategoryRepository categoryRepository) {
        this.categoryDAO = categoryDAO;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(value = "/category/all", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getCategory(@PathVariable final Long id) {
        return new ResponseEntity<>(categoryDAO.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    Category editCategory(@RequestBody Category editCategory, @PathVariable Long id) throws Exception {

        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(editCategory.getName());
                    category.setDescription(editCategory.getDescription());
                    return categoryRepository.save(category);
                })
                .orElseThrow(() -> new Exception(
                        "No category found with id " + id + "\""));

    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    Category addCategory(@RequestBody Category newCategory) {
        return categoryRepository.save(newCategory);
    }

    @DeleteMapping("/category/{id}")
    void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }

}
