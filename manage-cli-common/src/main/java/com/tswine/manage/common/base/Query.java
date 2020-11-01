package com.tswine.manage.common.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 查询条件
 *
 * @Author: tswine
 * @Date: 2020/10/25 10:08
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Query<T> {

    /**
     * 当前页码
     */
    private int currentPage = 1;
    /**
     * 分页大小
     */
    private int pageSize = 20;
}
