package com.hzh.moneyrecord.controller;


import com.alibaba.fastjson.JSON;
import com.hzh.moneyrecord.enmus.ConstantAttribute;
import com.hzh.moneyrecord.enmus.Status;
import com.hzh.moneyrecord.entity.Result;
import com.hzh.moneyrecord.service.IConsumerRecordService;
import com.hzh.moneyrecord.vo.ConsumerRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2022-02-09
 */
@RestController
@RequestMapping("/record")
public class ConsumerRecordController extends BaseController {

    @Autowired
    private IConsumerRecordService consumerRecordService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Result testHttp(){
        Map<String, Object> result = new HashMap<>(12);
        result.put(ConstantAttribute.STATUS, Status.SUCCESS);
        result.put(ConstantAttribute.DATA_LIST,"testResult");
        return returnDataList(result);
    }

    @RequestMapping(value = "/put",method = RequestMethod.POST)
    public Result putRecord(@RequestBody ConsumerRecordVO recordVO){
        logInfo("put a consumer record, request body : "+ JSON.toJSONString(recordVO));
        Map<String,Object> result = consumerRecordService.putRecord(recordVO);
        return returnDataList(result);
    }
}
