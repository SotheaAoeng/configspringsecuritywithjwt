package com.merean.spring.boot3.security.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pagination {

    private boolean last;

    private boolean first;

    private Integer size;

    @JsonProperty("total_pages")
    private Integer totalPages;

    @JsonProperty("current_page")
    private Integer currentPage;

    @JsonProperty("current_total_elements")
    private Integer currentTotalElements;

    @JsonProperty("total_elements")
    private Long totalElements;

    private boolean empty;

    public Pagination(Page<?> page) {
        this.last = page.isLast();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.currentPage = page.getNumber();
        this.first = page.isFirst();
        this.size = page.getSize();
        this.empty = page.isEmpty();
        this.currentTotalElements = page.getNumberOfElements();
    }
}
