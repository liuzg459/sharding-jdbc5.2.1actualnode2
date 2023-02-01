package com.example.shardingjdbcactualnode;

/*import org.mybatis.spring.annotation.MapperScan;*/
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.example.shardingjdbcactualnode.mapper")
public class ShardingJdbcActualnodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcActualnodeApplication.class, args);
    }

}
