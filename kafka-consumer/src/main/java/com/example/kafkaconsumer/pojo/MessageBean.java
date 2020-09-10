package com.example.kafkaconsumer.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shenliang
 * @since 2020-09-09
 */
@Data
public class MessageBean implements Serializable{
    /** uuid */
    private String uuid;

    /** 时间  */
    private Date date;
}
