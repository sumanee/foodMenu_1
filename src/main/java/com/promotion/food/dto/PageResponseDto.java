package com.promotion.food.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDto<T> {  // ✅ ต้องใส่ <T>

    private List<T> content;
    private int page;
    private int size;
    private int totalPages;

    // ✅ Constructor ที่รับ Page<T>
    public PageResponseDto(Page<T> pageData) {
        this.content = pageData.getContent();
        this.page = pageData.getNumber();
        this.size = pageData.getSize();
        this.totalPages = pageData.getTotalPages();
    }
}
