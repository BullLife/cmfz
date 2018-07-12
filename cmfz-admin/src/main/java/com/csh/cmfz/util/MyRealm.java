package com.csh.cmfz.util;

import com.csh.cmfz.entity.Manager;
import com.csh.cmfz.entity.Permission;
import com.csh.cmfz.entity.Role;
import com.csh.cmfz.service.ManagerService;
import com.csh.cmfz.service.PermissionService;
import com.csh.cmfz.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @Description 自定义数据源
 * @Author 程少华
 * @Date 2018/7/12 9:05
 **/
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    /**
     * 授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        List<Role> roles = roleService.queryRoleByManagerName(username);
        for (Role role : roles) {
            info.addRole(role.getRoleTag());
        }

        List<Permission> permissions = permissionService.queryPermissionByManagerName(username);
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getPermissionTag());
        }
        return info;
    }

    /**
     * 认证方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException 用户不存在 或者密码不正确
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        Manager manager = managerService.queryManagerByName(username);
        System.out.println("-------------------------------");
        System.out.println(manager.getMgrSalt());
        if(manager != null){
            return  new SimpleAuthenticationInfo(
                    manager.getMgrName(),
                    manager.getMgrPwd(),
                    ByteSource.Util.bytes(manager.getMgrSalt()),
                    UUID.randomUUID().toString().replace("-",""));
            /*return new SimpleAuthenticationInfo("ls","a4c5125ecc33bb776ff79cbd04ceb866",
                    ByteSource.Util.bytes("xyz"),
                    UUID.randomUUID().toString().replace("-",""));*/
        }
        return null;
    }
}
