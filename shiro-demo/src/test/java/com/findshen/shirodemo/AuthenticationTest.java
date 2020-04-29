package com.findshen.shirodemo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {

	SimpleAccountRealm simpleAccountRealm=new SimpleAccountRealm();
	@Before
	public void addAccount(){
		simpleAccountRealm.addAccount("mike","111");
	}

    @Test
    public void contextLoads() {
        //1.构建securityManager环境
        DefaultSecurityManager manager = new DefaultSecurityManager();
		manager.setRealm(simpleAccountRealm);

        //2.主体提交认证请求
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token=new UsernamePasswordToken("mike","111");
		subject.login(token);

		System.out.println(subject.isAuthenticated());

		subject.logout();
		System.out.println(subject.isAuthenticated());

	}

}
