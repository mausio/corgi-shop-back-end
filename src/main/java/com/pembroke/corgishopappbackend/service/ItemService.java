package com.pembroke.corgishopappbackend.service;

import com.pembroke.corgishopappbackend.dao.ItemRepository;
import com.pembroke.corgishopappbackend.dto.ItemDTO;
import com.pembroke.corgishopappbackend.entity.Item;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
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

    public ItemDTO save(Item item) {
        return modelMapper.map(itemRepository.save(item), ItemDTO.class);
    }
}
