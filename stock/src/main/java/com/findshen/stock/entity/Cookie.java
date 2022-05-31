package com.findshen.stock.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("bz_cookie")
public class Cookie {

    @TableId
    private Integer id;
    private String cookie;
    private Date gmtCreate;

}
