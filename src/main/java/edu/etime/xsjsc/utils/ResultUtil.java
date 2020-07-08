package edu.etime.xsjsc.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

//封装返回结果
@JsonInclude(JsonInclude.Include.NON_NULL)  //非空才会序列化
@Data
public class ResultUtil {
    private Integer code;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    private Object info;
    /**
     * 返回一个info为空对象的成功消息的json
     */
    public static ResultUtil success() {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(EnumCode.OK.getValue());
        resultUtil.setMsg(EnumCode.OK.getText());
        return resultUtil;
    }

    /**
     * 返回一个返回码为200的成功消息的
     */
    public static ResultUtil success(Object data) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(EnumCode.OK.getValue());
        resultUtil.setMsg(EnumCode.OK.getText());
        resultUtil.setData(data);
        return resultUtil;
    }

    /**
     * 返回错误信息
     */
    public static ResultUtil error(EnumCode errorEnum) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(errorEnum.getValue());
        resultUtil.setMsg(errorEnum.getText());
        return resultUtil;
    }
    /**
     * 带有错误消息的错误信息
     */
    public static ResultUtil error(EnumCode errorEnum,Object info) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(errorEnum.getValue());
        resultUtil.setMsg(errorEnum.getText());
        resultUtil.setInfo(info);
        return resultUtil;
    }
}
