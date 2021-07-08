package com.tensquare.gathering.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author chenjiafeng
 * @create 2021-06-07 16:26
 * @desc 分页组件
 **/
@Data
@AllArgsConstructor
public class PageResult<T> {
    private Long total;
    private List<T> rows;

}

