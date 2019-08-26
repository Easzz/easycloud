/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.findshen.modules.bz.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 学生表
 */
@Data
@Builder
@TableName("bz_student")
public class Student extends Model<Student> {

    /**
     * @TableId和@TableField 不能同时使用，如果数据库中主键名称是id，实体属性是userId，你可以这样映射@TableId("id")
     * 主键策略6种：
     * AUTO(0),
     * NONE(1),
     * INPUT(2),
     * ID_WORKER(3),
     * UUID(4),
     * ID_WORKER_STR(5);
     */

    @TableId
    private Long id;
    @NotBlank(message = "参数名不能为空")
    private String studentName;
    private Integer age;

    @TableLogic
    private Boolean valid;
    private Date gmtCreate;
    private Date gmtModified;

    /**
     * 排除非表字段的三种方式
     * 1、private transient String remark; 无法序列化
     * 2、private static String remark; 实例无法独有一份
     * 3、@TableField(exist=false)
     */
    @TableField(exist = false)
    private String remark;

}
