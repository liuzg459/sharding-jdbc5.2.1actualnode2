package com.example.shardingjdbcactualnode.mapper;

import com.example.shardingjdbcactualnode.domain.TOrder;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【t_order】的数据库操作Mapper
* @createDate 2023-01-30 23:46:49
* @Entity com.example.shardingjdbcactualnode.domain.TOrder
*/

public interface TOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Long id);

    int selectByPrimaryKeyCount0(Long id);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);

}
