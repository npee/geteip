package com.npee.eip.service;

import com.npee.eip.model.entity.Item;
import com.npee.eip.model.request.RequestItemDto;

import java.util.List;

public interface ItemService {
    Item insertItemSet(RequestItemDto itemDto);
    List<Item> selectItemSets();
    Item selectAItemSet(Long itemId);
    Item updateItemSet(Long itemId, RequestItemDto itemDto);
    void deleteItemSet(Long itemId);
}
