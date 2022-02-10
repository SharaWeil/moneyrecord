package com.hzh.moneyrecord.controller;

import com.hzh.moneyrecord.enmus.ConstantAttribute;
import com.hzh.moneyrecord.enmus.Status;
import com.hzh.moneyrecord.entity.Result;
import com.hzh.moneyrecord.util.BaseLogging;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author hzh
 * @ClassName BaseController.java
 * @createTime 2022年02月09日 13:36:00
 */
public class BaseController extends BaseLogging {
    /**
     * return data list
     *
     * @param result result code
     * @return result code
     */
    public Result returnDataList(Map<String, Object> result) {
        Status status = (Status) result.get(ConstantAttribute.STATUS);
        if (status == Status.SUCCESS) {
            String msg = (String) result.get(ConstantAttribute.MSG);
            if (StringUtils.isEmpty(msg)){
                msg =  Status.SUCCESS.getMsg();
            }
            Object datalist = result.get(ConstantAttribute.DATA_LIST);
            return success(msg, datalist);
        } else {
            Integer code = Status.ERROR.getCode();
            String msg = (String) result.get(ConstantAttribute.MSG);
            return error(code, msg);
        }
    }

    /**
     *  return error result
     * @param code errorCode
     * @param msg errorMsg
     * @return
     */
    private Result error(Integer code, String msg) {
        Result result = new Result();
        result.setMessage(msg);
        result.setStatusCode(code);
        return result;
    }

    /**
     *  return success result
     * @param msg successMsg
     * @param datalist data
     * @return
     */
    private Result success(String msg, Object datalist) {
        Result result = new Result();
        result.setMessage(msg);
        result.setStatusCode(Status.SUCCESS.getCode());
        result.setData(datalist);
        return result;
    }
}
