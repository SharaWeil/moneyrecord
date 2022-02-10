package com.hzh.moneyrecord;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hanzhihua
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.hzh.moneyrecord.mapper"})
public class MoneyRecordApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoneyRecordApplication.class, args);
    }

}
