package com.project.name.service.page.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.name.service.auth.dto.AuthUserListDTO;
import lombok.Data;

import java.util.List;

@Data
public class PageDTO<T> {
    private List<T> records;
    /**
     * 一页的大小
     */
    private Long pageSize;

    /**
     * 当前页面的页码
     */
    private Long currentPageNumber;

    /**
     * 所有数据条数
     */
    private Long totalRecordSize;

    /**
     * 总页大小
     */
    private Long totalPageSize;

    /**
     * 是否存在上一页
     */
    private boolean hasPrev;

    /**
     * 是否存在下一个
     */
    private boolean hasNext;

    private PageDTO(Page<T> page){
        this.records = page.getRecords();
        this.pageSize = page.getSize();
        this.currentPageNumber = page.getCurrent();
        this.totalRecordSize = page.getTotal();
        this.totalPageSize = page.getPages();
        this.hasNext = page.hasNext();
        this.hasPrev = page.hasPrevious();
    }

    public static <T> PageDTO<T> getResult(Page<T> page) {
        return new PageDTO<T>(page);
    }
}
