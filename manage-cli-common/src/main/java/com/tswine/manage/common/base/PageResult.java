package com.tswine.manage.common.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 分页信息
 *
 * @Author: tswine
 * @Date: 2020/10/25 9:52
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    /**
     * 当前页码
     */
    private int currentPage = 1;

    /**
     * 每页显示的记录数
     */
    private int pageSize = 20;

    /**
     * 总记录数
     */
    private long totalRecord = 0;

    /**
     * 总页数
     */
    private long totalPage = 0;
    /**
     * 对应的当前页记录
     */
    private List<T> results;

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
        //在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
        int totalPage = (int) (totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1);
        this.setTotalPage(totalPage);
    }
}
