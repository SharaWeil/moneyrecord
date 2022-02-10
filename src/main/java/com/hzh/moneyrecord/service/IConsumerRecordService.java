package com.hzh.moneyrecord.service;

import com.hzh.moneyrecord.entity.ConsumerRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hzh.moneyrecord.vo.ConsumerRecordVO;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2022-02-09
 */
public interface IConsumerRecordService extends IService<ConsumerRecord> {

    Map<String, Object> putRecord(ConsumerRecordVO recordVO);
}
