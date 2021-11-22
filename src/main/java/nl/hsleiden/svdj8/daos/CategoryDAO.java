package nl.hsleiden.svdj8.daos;

import nl.hsleiden.svdj8.models.tables.Category;
import nl.hsleiden.svdj8.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

@Component
public class CategoryDAO {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDAO(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ArrayList<Category> getAll(){
        ArrayList<Category> categories = (ArrayList<Category>) categoryRepository.findAll();
        categories.sort(Comparator.comparingLong(Category::getCategoryID));
        return categories;
    }

    public Category getFirst() {
        return getAll().get(0);
    }

    public Category getById(long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);
    }

}
