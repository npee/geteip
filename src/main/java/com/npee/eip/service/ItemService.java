package com.npee.eip.service;

import com.npee.eip.model.entity.Item;
import com.npee.eip.model.request.RequestItemDto;
import com.npee.eip.model.request.RequestQuizDto;

import java.util.List;

public interface ItemService {
    Item insertItemSet(RequestItemDto quizDto);
    List<Item> selectItemSets();
    Item selectAItemSet(Long itemId);
    Item updateItemSet(Long itemId, RequestQuizDto quizDto);
    void deleteItemSet(Long itemId);
}
