package com.npee.eip.controller.v1;

import com.npee.eip.config.response.ListResult;
import com.npee.eip.config.response.ResponseService;
import com.npee.eip.config.response.SingleResult;
import com.npee.eip.model.entity.Item;
import com.npee.eip.service.ItemServiceImpl;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"4. Item"})
@RestController
@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"})
@RequestMapping("/v1/items")
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ResponseService responseService;
    private final ItemServiceImpl itemService;

    @GetMapping
    public ListResult<Item> getItemList() {
        return responseService.getListResult(itemService.selectItemSets());
    }

    @GetMapping("/{itemId}")
    public SingleResult<Item> getSelectedItem(@PathVariable Long itemId) {
        // return responseService.getSingleResult(itemService.selectAItemSet(itemId));
        return null;
    }

    @PostMapping
    public SingleResult<Item> setItem() {
        // return responseService.getSingleResult(itemService.insertItemSet());
        return null;
    }

    @PutMapping("/{itemId}")
    public SingleResult<Item> updateItem() {
        return null;
    }

    @DeleteMapping("/{itemId}")
    public SingleResult<Item> deleteItem() {
        return null;
    }

}
