package com.ls.cloud.bookservice.entity.rep;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/** 返回值
 * @author liang
 */
@ApiModel(description = "响应对象")
@Data
public class DataResponse<T> implements Serializable {

    private DataResponse(){}

    public DataResponse(Code code) {
        this.code = code;
    }

    private static final DataResponse SUCCESS=new DataResponse(Code.SUCCESS);

    @ApiModelProperty(value = "响应码", name = "code", required = true, example = "0")
    private Code code;
    private int count;
    private int currentPage;
    private int pageSize;
    private List<T> data;

    private Object entity;
    private Map<String, Object> dataMap;
    private String msg="";

    public static DataResponse of(List list) {
        DataResponse dataResponse = new DataResponse<>();
        dataResponse.setCode(Code.SUCCESS);
        dataResponse.setData(list);
        return dataResponse;
    }

    public static DataResponse of(Code code, Map<String, Object> map) {
        DataResponse dataResponse = new DataResponse<>();
        dataResponse.setCode(code);
        dataResponse.setDataMap(map);
        return dataResponse;
    }

    public static DataResponse of(Code code, Object entity, String msg) {
        DataResponse dataResponse = new DataResponse<>();
        dataResponse.setCode(code);
        dataResponse.setEntity(entity);
        dataResponse.setMsg(msg);
        return dataResponse;
    }

    public static DataResponse of(Code code, String msg) {
        DataResponse dataResponse = new DataResponse<>();
        dataResponse.setCode(code);
        dataResponse.setMsg(msg);
        return dataResponse;
    }

    public static DataResponse SUCCESS() {
        return SUCCESS;
    }

}
