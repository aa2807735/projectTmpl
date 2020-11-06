package com.project.name.service.page.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.name.service.auth.dto.AuthUserListDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "分页结果DTO")
public class PageDTO<T> {

    @ApiModelProperty("查询结果集")
    private List<T> records;

    @ApiModelProperty("一页的大小")
    private Long pageSize;

    @ApiModelProperty("当前页面的页码")
    private Long currentPageNumber;

    @ApiModelProperty("所有数据条数")
    private Long totalRecordSize;

    @ApiModelProperty("总页大小")
    private Long totalPageSize;

    @ApiModelProperty("是否存在上一页")
    private boolean hasPrev;

    @ApiModelProperty("是否存在下一个")
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
