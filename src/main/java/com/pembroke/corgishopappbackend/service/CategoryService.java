package com.pembroke.corgishopappbackend.service;

import com.pembroke.corgishopappbackend.dao.CategoryRepository;
import com.pembroke.corgishopappbackend.dto.CategoryDTO;
import com.pembroke.corgishopappbackend.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        return modelMapper.map(categoryRepository.save(category), CategoryDTO.class);
    }

    public CategoryDTO findByName(String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        return modelMapper.map(category, CategoryDTO.class);
    }
}
