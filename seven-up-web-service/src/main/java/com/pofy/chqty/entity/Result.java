package com.pofy.chqty.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Result<T> {

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
}
