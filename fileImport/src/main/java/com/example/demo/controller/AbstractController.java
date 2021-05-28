//package com.example.demo.controller;
//
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.minxin.business.enums.ModuleEnum;
//import com.minxin.business.enums.OperationCodeEnum;
//import com.minxin.business.modules.sys.entity.OperationRecord;
//import com.minxin.business.modules.sys.entity.UserEntity;
//import com.minxin.business.modules.sys.service.OperationRecordService;
//import com.minxin.business.modules.sys.service.UserInfoService;
//import org.apache.shiro.SecurityUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//public abstract class AbstractController {
//
//    @Autowired
//    private UserInfoService userInfoService;
//
//    @Autowired
//    private OperationRecordService operationRecordService;
//
//    protected Logger logger = LoggerFactory.getLogger(getClass());
//
//    /**
//     * 当前用户信息
//     */
//    public String getUsername() {
//        return SecurityUtils.getUsername();
//    }
//
//    /**
//     * 当前用户Id
//     */
//    public Long getUserId() {
//        return getUserInfo().getUserId();
//    }
//
//    /**
//     * 当前用户机构Code
//     */
//    public String getOrgCode() {
//        return getUserInfo().getOrgCode();
//    }
//
//
//    /**
//     * 当前用户部门Id
//     */
//    public Long getDeptId() {
//        return getUserInfo().getDeptId();
//    }
//
//
//    public String getDeptCode() {
//        return getUserInfo().getDeptCode();
//    }
//
//    /**
//     * 当前用户部门名称
//     */
//    public String getDeptName() {
//        return getUserInfo().getDeptName();
//    }
//
//    /**
//     * 当前用户真实姓名
//     */
//    public String getRealName() {
//        return getUserInfo().getRealName();
//    }
//
//    /**
//     * 当前用户角色名称
//     */
//    public String getRoleNames() {
//        return getUserInfo().getRoleNames();
//    }
//
//    /**
//     * 获取角色列表
//     * @return
//     */
//    public String getRoleCodes() {
//        return getUserInfo().getRoleCodes();
//    }
//
//
//    /**
//     * 根据用户名获取用户资料
//     *
//     * @return
//     */
//    public UserEntity getUserInfo(String username) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("username", username);
//        return userInfoService.getUserInfo(map);
//    }
//
//    /**
//     * 根据用户Id 获取用户资料
//     *
//     * @param userId
//     * @return
//     */
//    public UserEntity getUserInfo(Long userId) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("userId", userId);
//        return userInfoService.getUserInfo(map);
//    }
//
//    /**
//     * 当前登陆用户详细信息
//     *
//     * @return
//     */
//    public UserEntity getUserInfo() {
//        return getUserInfo(SecurityUtils.getUsername());
//    }
//
//
//    /**
//     * 当前登陆用户详细信息
//     *
//     * @return
//     */
//    public List<UserEntity> getUserByRoleName(String orgCode, String roleName) {
//        return userInfoService.selectList(new EntityWrapper<UserEntity>().eq("u.org_code", orgCode).eq("r.role_name", roleName));
//    }
//
//
//    /**
//     * 设置当前用户操作记录
//     *
//     * @param projectNumber        档案号
//     * @param moduleCode           模块编码
//     * @param moduleName           模块名称
//     * @param operationCode        操作编码
//     * @param operationDescription 操作描述
//     */
//    public void setOperationRecord(String projectNumber, String moduleCode, String moduleName,
//                                   String operationCode, String operationDescription) {
//        OperationRecord or = new OperationRecord();
//        or.setOperatorId(getUserId());
//        or.setOperatorName(getRealName());
//        if (getUserInfo().getRoleNames() != null) {
//            or.setOperatorRole(getUserInfo().getRoleNames());
//        } else {
//            or.setOperatorRole("admin");
//        }
//        or.setOperatorDepartment(getDeptName());
//        or.setOperatorCompany(getUserInfo().getOrgName());
//
//        or.setProjectNumber(projectNumber);
//        or.setModuleName(moduleName);
//        or.setModuleCode(moduleCode);
//        or.setOperationCode(operationCode);
//        or.setOperationDescription(operationDescription);
//        operationRecordService.insert(or);
//    }
//
//    /**
//     * 设置当前用户操作记录
//     *
//     * @param projectNumber     档案号
//     * @param moduleEnum        模块枚举
//     * @param operationCodeEnum 操作枚举
//     */
//    public void setOperationRecord(String projectNumber, ModuleEnum moduleEnum,
//                                   OperationCodeEnum operationCodeEnum) {
//        setOperationRecord(projectNumber, moduleEnum.name(), moduleEnum.getDescription(),
//                operationCodeEnum.name(), operationCodeEnum.getDescription());
//    }
//}
