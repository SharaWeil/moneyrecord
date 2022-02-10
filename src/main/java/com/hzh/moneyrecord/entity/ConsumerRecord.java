package com.hzh.moneyrecord.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2022-02-09
 */
@Data
public class ConsumerRecord{

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 类型，1-收入；-1-支出
     */
    private Integer type;

    /**
     * 消费类型，枚举类型
     */
    private String consumerType;

    /**
     * 金额
     */
    private Double count;

    /**
     * 通过那种app消费，枚举类型
     */
    private String consumerApp;

    private LocalDateTime createTime;


}
