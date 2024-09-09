package com.sparta.hanghaemarket.service;

import com.sparta.hanghaemarket.entity.Item;
import com.sparta.hanghaemarket.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketService {

    private final MarketRepository marketRepository;

    // 판매 게시글 작성
    public Item postContent(Item item) {
        Item save = marketRepository.save(item);

        return save;
    }

    // 판매 게시글 전체 리스트 조회
    public List<Item> getAllList() {
        return marketRepository.findAll();
    }

    // 게시글 삭제
    public String removeContent(Long id) {
        Item item = marketRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 게시글이 존재하지 않습니다."));
        marketRepository.delete(item);
        return "삭제완료";
    }

    // 판매 게시글 수정
    @Transactional
    public Item putContent(Long id, Item item) {

        Item findItem = marketRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );

        Item updateItem = findItem.update(item);

        return updateItem;
    }
}
