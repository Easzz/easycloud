package com.example.caseProject.entity;

import lombok.Data;

@Data
public class AuditVo {
    private Long[] deviceIds;
    private Long userId;

    private Long[] recordIds;
    private String remark;


    private Integer agree;
    private Boolean isDamage;
}
