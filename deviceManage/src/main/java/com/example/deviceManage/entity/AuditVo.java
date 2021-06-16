package com.example.deviceManage.entity;

import lombok.Data;

@Data
public class AuditVo {
    private Long[] deviceIds;
    private Long userId;

    private Long[] recordIds;
}
