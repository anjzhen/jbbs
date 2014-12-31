package cc.ymee.jbbs.module.security.core;

import cc.ymee.common.utils.IpUtil;
import cc.ymee.jbbs.module.record.pojo.AdminLogin;
import cc.ymee.jbbs.module.record.service.RecordService;
import cc.ymee.jbbs.module.security.pojo.SecurityAdmin;
import cc.ymee.jbbs.module.security.pojo.SecurityAuth;
import cc.ymee.jbbs.module.security.service.AdminService;
import cc.ymee.jbbs.module.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AuthService authService;

    @Resource
    private RecordService recordService;

    @Resource
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        SecurityAdmin admin;
        Collection<GrantedAuthority> auths;
        admin = adminService.login(username);
        if (admin != null) {
            List<SecurityAuth> adminAuths = authService.selectByAdmin(admin.getId());
            auths = new ArrayList<GrantedAuthority>();
            for (SecurityAuth auth : adminAuths) {
                GrantedAuthority ga = new SimpleGrantedAuthority(auth.getName());
                auths.add(ga);
            }


            AdminLogin adminLogin = new AdminLogin();

            String ipAddress = IpUtil.getIpAddr(request);

            adminLogin.setUrl("");
            adminLogin.setInTime(new Date());
            adminLogin.setIpAddress(ipAddress == null ? "" : ipAddress);
            adminLogin.setBrower(request.getHeader("User-Agent"));
            adminLogin.setAdminId(admin.getId());
            recordService.insert(adminLogin);
            return new User(username, admin.getPassword(), true, true, true, true, auths);
        } else {
            throw new UsernameNotFoundException("admin:" + username + " do not exist!!");
        }

    }

}
