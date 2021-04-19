package cn.it1995.Response;

import lombok.Data;

@Data
public class PageResp<T> {

    private Integer totalPages;
    private Integer currentPage;
    private Long totalElements;
    private T data;
}
