package nl.hsleiden.svdj8.daos;

import nl.hsleiden.svdj8.models.tables.Category;
import nl.hsleiden.svdj8.models.tables.Question;
import nl.hsleiden.svdj8.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryDAO {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDAO(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll(){
        ArrayList<Category> categories = (ArrayList<Category>) categoryRepository.findAll();
        categories.sort(Comparator.comparingLong(Category::getCategoryID));
        return categories;
    }
    public Optional<Category> getByIdOptional(long id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory;
    }

    public Category getById(long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);
    }

    public Category addCategory(Category newCategory){
        return categoryRepository.save(newCategory);
    }
    public void deleteCategory(long id){
        categoryRepository.deleteById(id);
    }
}
