package com.project.name.page;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data

public class PageParam<T> {
    private Integer pageSize;
    private Integer currentPageNumber;
    /**
     * SQL 排序 ASC 数组
     */
    private String[] ascs;
    /**
     * SQL 排序 DESC 数组
     */
    private String[] descs;

    private T queryParam;

    public Page<T> getPage() {
        return new Page<>(currentPageNumber,pageSize);
    }
}
