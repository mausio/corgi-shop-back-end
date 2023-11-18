package com.pembroke.corgishopappbackend.service;

import com.pembroke.corgishopappbackend.dao.ItemRepository;
import com.pembroke.corgishopappbackend.dto.ItemDTO;
import com.pembroke.corgishopappbackend.entity.Item;
import com.pembroke.corgishopappbackend.service.CategoryService; // Ensure you import CategoryService
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    @Autowired
    public ItemService(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    public List<ItemDTO> findAll() {
        return itemRepository.findAll().stream()
                .map(item -> modelMapper.map(item, ItemDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    public List<ItemDTO> findByCategoryId(int categoryId) {
        return itemRepository.findByCategory_Id(categoryId).stream()
                .map(item -> modelMapper.map(item, ItemDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    public ItemDTO save(ItemDTO itemDTO, String categoryName) {
        Item item = modelMapper.map(itemDTO, Item.class);

        // Assuming you have a method like findByName in CategoryService
        CategoryDTO category = categoryService.findByName(categoryName);
        Category categoryEntity = modelMapper.map(category, Category.class);

        item.setCategory(categoryEntity);

        return modelMapper.map(itemRepository.save(item), ItemDTO.class);
    }
}
