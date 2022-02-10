package com.hzh.moneyrecord.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.MyServiceImpl;
import com.hzh.moneyrecord.enmus.ConstantAttribute;
import com.hzh.moneyrecord.enmus.Status;
import com.hzh.moneyrecord.entity.ConsumerRecord;
import com.hzh.moneyrecord.mapper.ConsumerRecordMapper;
import com.hzh.moneyrecord.service.IConsumerRecordService;
import com.hzh.moneyrecord.vo.ConsumerRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2022-02-09
 */
@Service
public class ConsumerRecordServiceImpl extends MyServiceImpl<ConsumerRecordMapper, ConsumerRecord> implements IConsumerRecordService {

    @Autowired
    private ConsumerRecordMapper mapper;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Map<String, Object> putRecord(ConsumerRecordVO recordVO) {
        Map<String, Object> result = new HashMap<>();
        ConsumerRecord record = ConsumerRecord.builder()
                .userId(recordVO.getUserId())
                .type(recordVO.getType())
                .consumerType(recordVO.getConsumerType())
                .consumerApp(recordVO.getConsumerApp())
                .count(recordVO.getCount())
                .createTime(LocalDateTime.now())
                .build();
        int insert = mapper.insert(record);
        if (insert == 1){
            result.put(ConstantAttribute.STATUS, Status.SUCCESS);
        }
        return result;
    }
}
