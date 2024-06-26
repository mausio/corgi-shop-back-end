package com.pembroke.corgishopappbackend.service;

import com.pembroke.corgishopappbackend.dao.CategoryRepository;
import com.pembroke.corgishopappbackend.dto.CategoryDTO;
import com.pembroke.corgishopappbackend.dto.ItemDTO;
import com.pembroke.corgishopappbackend.entity.Category;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<ItemDTO> getAllItemsFromCategory(String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        return category.getItems().stream()
                .map(item -> modelMapper.map(item, ItemDTO.class))
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    //TODO: Delete this method when using a final Database
    public void save(Category category1) {
        Category category = modelMapper.map(category1, Category.class);
        Category savedCategory = categoryRepository.save(category);
        modelMapper.map(savedCategory, CategoryDTO.class);
    }

    public Category findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

}
