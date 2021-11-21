package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.CategoryDAO;
import nl.hsleiden.svdj8.models.tables.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category", method = RequestMethod.GET)
public class CategoryController {

    @Autowired
    public final CategoryDAO categoryDAO;

    public CategoryController(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getCategoryy(@PathVariable final Long id) {
        return new ResponseEntity<>(categoryDAO.getById(id), HttpStatus.OK);
    }


}
