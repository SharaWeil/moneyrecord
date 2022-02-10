package com.hzh.moneyrecord.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author hzh
 * @ClassName TestVO.java
 * @createTime 2022年02月08日 18:22:00
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ConsumerRecordVO {

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
}
