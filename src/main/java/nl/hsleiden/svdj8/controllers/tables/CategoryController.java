package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.AdviceDAO;
import nl.hsleiden.svdj8.models.tables.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    public final AdviceDAO adviceDAO;

    public CategoryController(AdviceDAO adviceDAO) {
        this.adviceDAO = adviceDAO;
    }

    @GetMapping(value = "/category/all")
    public List<Advice> getAllCategories() {
        return adviceDAO.getAll();
    }

    @GetMapping(value = "/category/{id}")
    public Advice getCategory(@PathVariable final Long id) {
        return adviceDAO.getById(id);
    }

    @PutMapping(value = "/category/{id}")
    public Advice editCategory(@RequestBody Advice editAdvice, @PathVariable Long id) throws Exception {

        return adviceDAO.getByIdOptional(id)
                .map(advice -> {
                    advice.setName(editAdvice.getName());
                    advice.setDescription(editAdvice.getDescription());
                    return adviceDAO.addCategory(advice);
                })
                .orElseThrow(() -> new Exception(
                        "No category found with id " + id + "\""));
    }

    @PutMapping(value = "/category")
    public Advice addCategory(@RequestBody Advice newAdvice) {
        return adviceDAO.addCategory(newAdvice);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Long id) {
        adviceDAO.deleteCategory(id);
    }
}
