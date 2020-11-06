package com.project.name.page;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "分页参数通用超类")
public class PageParam<T> {
    @ApiModelProperty(value = "每页显示条数")
    private Integer pageSize;

    @ApiModelProperty(value = "当前页面")
    private Integer currentPageNumber;

    @ApiModelProperty(value = "SQL 排序 ASC 数组")
    private String[] ascs;

    @ApiModelProperty(value = "SQL 排序 DESC 数组")
    private String[] descs;

    @ApiModelProperty(value = "查询实体参数")
    private T queryParam;

    public Page<T> getPage() {
        return new Page<>(currentPageNumber, pageSize);
    }
}
