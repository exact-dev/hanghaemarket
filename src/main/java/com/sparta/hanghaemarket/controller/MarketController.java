package com.sparta.hanghaemarket.controller;

import com.sparta.hanghaemarket.entity.Item;
import com.sparta.hanghaemarket.service.MarketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class MarketController {

    private final MarketService marketService;
    
    // 판매 게시글 작성
    @PostMapping
    public Item marketPost(@RequestBody Item item) {
        Item itemResult = marketService.postContent(item);
        return itemResult;
    }

    // 판매 게시글 전체 리스트 조회
    @GetMapping
    public List<Item> getAll() {
        List<Item> allList = marketService.getAllList();
        return allList;
    }

    // 판매 게시글 수정
    @PutMapping("/{id}")
    public Item put(@PathVariable Long id, @RequestBody Item item) {
        Item updateItem = marketService.putContent(id, item);
        return updateItem;
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        String result = marketService.removeContent(id);

        return result;
    }
}
