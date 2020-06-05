package com.jk.shiro;

import com.jk.model.SysUser;
import com.jk.service.HelloService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

public class MyRealm extends AuthorizingRealm {


    /**
     * 授权（用户所属权限集）
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 1. 获取当前用户
        SysUser user = (SysUser)principalCollection.getPrimaryPrincipal();

        // 2. 根据当前用户，查询数据库权限表，获取当前用户所属的权限字有哪些返回List<String>集合
        HelloService helloService = SpringBeanFactoryUtils.getBean("helloService", HelloService.class);
        List<String> perCodeList = helloService.selectPerCodeList(user.getId());

        // 3. 将权限字集合放入到授权器中
        SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo();
        sai.addStringPermissions(perCodeList);

        return sai;
    }

    /**
     * 认证（登录）
     * @param authenticationToken 存放用户信息
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 完成用户登录功能
        // 1. 获取用户在登录页面输入的用户名
        String userName = authenticationToken.getPrincipal().toString();


        // 2. 带着用户名到数据库查询当前用户是否存在
        HelloService helloService = SpringBeanFactoryUtils.getBean("helloService", HelloService.class);
        SysUser user = helloService.selectUserByCode(userName);

        // 3. 判断用户对象是否有值
        if (user == null) {
            // 3.1 用户对象没有值，账号输入错误，返回账号不存在异常
            throw new UnknownAccountException();
        }



        //   获取盐值, 用户盐值必须唯一
        ByteSource saltByte = ByteSource.Util.bytes(user.getSalt());
        // 4. 验证密码 参数传递(用户对象, 用户密码, 盐值, 当前realm对象名称)
        SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(user, user.getPassword(), saltByte, this.getName());
        return sai;
    }
}
