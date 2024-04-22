package kz.dar.university.datastoreapi.services;

import kz.dar.university.datastoreapi.model.Category;
import kz.dar.university.datastoreapi.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoryService {


    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll(){
        return categoryRepository.findAllWithEvents();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategoryById(Long id, Category updatedCategory){
        Category existingCategory = categoryRepository.findById(id).orElse(null);

        if(existingCategory != null){
//            modelMapper.map(updatedCategory, existingCategory);
            existingCategory.setName(updatedCategory.getName());
            existingCategory.setEvents(updatedCategory.getEvents());
        }

        return categoryRepository.save(existingCategory);
    }

    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
    }

}
