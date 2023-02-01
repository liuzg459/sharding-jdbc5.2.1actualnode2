package com.example.shardingjdbcactualnode;

//import com.example.shardingjdbcactualnode.mapper.TOrderMapper;

import com.example.shardingjdbcactualnode.mapper.TOrderMapper;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootTest(classes = ShardingJdbcActualnodeApplication.class)
@RunWith(SpringRunner.class)
public class ShardingJdbcActualnodeApplicationTests {
    @Autowired
    DataSource dataSource;

    @Resource
    TOrderMapper tOrderMapper;


    @Test
    public void test(){
        tOrderMapper.selectByPrimaryKey(1L);
        tOrderMapper.selectByPrimaryKeyCount0(1L);
    }

}
