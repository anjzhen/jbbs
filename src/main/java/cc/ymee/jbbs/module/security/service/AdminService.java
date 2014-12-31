package cc.ymee.jbbs.module.security.service;

import cc.ymee.jbbs.module.security.mapper.SecurityAdminMapper;
import cc.ymee.jbbs.module.security.pojo.SecurityAdmin;
import cc.ymee.jbbs.module.security.pojo.SecurityAdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Transactional
@Service
public class AdminService {
    @Autowired
    private SecurityAdminMapper securityAdminMapper;




    public List<SecurityAdmin> selectAll() {
        SecurityAdminExample example = new SecurityAdminExample();
        return securityAdminMapper.selectByExample(example);
    }

    public SecurityAdmin save(SecurityAdmin securityAdmin, Integer role[]) {
        securityAdminMapper.insert(securityAdmin);
        Map<String, Integer> params = null;
        if (role != null) {
            for (Integer roleId : role) {
                params = new HashMap<String, Integer>();
                params.put("adminId", securityAdmin.getId());
                params.put("roleId", roleId);
                securityAdminMapper.insertAdminRole(params);
            }
        }

        return securityAdmin;
    }

    public boolean delete(Integer id) {
        int num = securityAdminMapper.deleteByPrimaryKey(id);
        return num > 1 ? true : false;

    }

    public SecurityAdmin login(String username) {
        SecurityAdminExample example = new SecurityAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        return securityAdminMapper.login(example);
    }

    public SecurityAdmin selectById(Integer id) {
        return securityAdminMapper.selectByPrimaryKey(id);
    }

    public void update(Integer adminId, Integer[] role) {
        securityAdminMapper.deleteAdminRoles(adminId);
        Map<String, Integer> params = null;
        if (role != null) {
            for (Integer roleId : role) {
                params = new HashMap<String, Integer>();
                params.put("adminId", adminId);
                params.put("roleId", roleId);
                securityAdminMapper.insertAdminRole(params);
            }
        }
    }

    public int updatePwdById(Integer id, String newPwd) {
        SecurityAdmin record = securityAdminMapper.selectByPrimaryKey(id);
        record.setPassword(newPwd);
        return securityAdminMapper.updateByPrimaryKey(record);
    }
}
