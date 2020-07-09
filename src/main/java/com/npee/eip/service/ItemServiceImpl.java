package com.npee.eip.service;

import com.npee.eip.advice.exception.CustomItemNotExistsException;
import com.npee.eip.model.entity.Item;
import com.npee.eip.model.request.RequestQuizDto;
import com.npee.eip.repository.ItemJpaRepository;
import com.npee.eip.repository.QuizJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService{

    private final ItemJpaRepository itemJpaRepository;

    @Override
    public Item insertItemSet(RequestQuizDto quizDto) {
        return null;
    }

    @Override
    public List<Item> selectItemSets() {
        return itemJpaRepository.findAll();
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

//    public Item builder(RequestQuizDto quizDto, int index) {
//        Item item = Item.builder()
//                .choice(quizDto.getItemList().get(index).getChoice())
//                .isAnswer(quizDto.getItemList().get(index).getIsAnswer())
//                .build();
//
//        log.debug(index + " -th " + quizDto.getItemList().get(index).getChoice() + " item is created");
//        itemJpaRepository.save(item);
//        return item;
//    }
}
