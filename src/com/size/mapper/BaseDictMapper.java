package com.size.mapper;

import java.util.List;

import com.size.pojo.BaseDict;

public interface BaseDictMapper {
    List<BaseDict> findDictByCode(String typeCode);
}