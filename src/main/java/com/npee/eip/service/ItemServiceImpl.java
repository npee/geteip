package com.npee.eip.service;

import com.npee.eip.advice.exception.CustomItemNotExistsException;
import com.npee.eip.advice.exception.CustomItemTableEmptyException;
import com.npee.eip.model.entity.Item;
import com.npee.eip.model.request.RequestItemDto;
import com.npee.eip.model.request.RequestQuizDto;
import com.npee.eip.repository.ItemJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemJpaRepository itemJpaRepository;

    @Override
    public Item insertItemSet(RequestItemDto itemDto) {
        return save(itemDto);
    }

    @Override
    public List<Item> selectItemSets() {
        List<Item> items = itemJpaRepository.findAll();
        if (items.isEmpty()) {
            throw new CustomItemTableEmptyException();
        } else {
            return items;
        }
    }

    @Override
    public Item selectAItemSet(Long itemId) {
        return itemJpaRepository.findById(itemId).orElseThrow(CustomItemNotExistsException::new);
    }

    @Override
    public Item updateItemSet(Long itemId, RequestQuizDto quizDto) {
        return null;
    }

    @Override
    public void deleteItemSet(Long itemId) {

    }

    private Item save(RequestItemDto itemDto) {
        return update(null, itemDto);
    }

    private Item update(Long itemId, RequestItemDto itemDto) {
        return itemJpaRepository.save(Item.builder()
                .itemId(itemId)
                .choice(itemDto.getChoice())
                .isAnswer(itemDto.getIsAnswer())
                .build());
    }
}
