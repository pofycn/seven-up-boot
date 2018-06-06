package com.pofy.chqty.entity;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * function - Result entity
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    /**
     * result code
     */
    private String code;

    /**
     * result message
     */
    private String message;

    /**
     * result body
     */
    private T body;


    /**
     * current time
     */
    private Date time;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
