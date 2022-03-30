package com.findshen.stock.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("xueqiu")
public class XueQiuVo {

    @TableId
    private Integer id;
    private Long created_at;
    private String text;

}
