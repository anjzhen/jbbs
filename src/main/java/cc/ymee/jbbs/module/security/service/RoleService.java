package cc.ymee.jbbs.module.security.service;

import cc.ymee.jbbs.module.security.mapper.SecurityRoleMapper;
import cc.ymee.jbbs.module.security.pojo.SecurityRole;
import cc.ymee.jbbs.module.security.pojo.SecurityRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RoleService {
    @Autowired
    private SecurityRoleMapper securityRoleMapper;

    public List<SecurityRole> selectAll() {
        SecurityRoleExample example = new SecurityRoleExample();
        return securityRoleMapper.selectByExample(example);
    }

    public boolean save(SecurityRole role, Integer auth[]) {
        int num = securityRoleMapper.insert(role);
        Map<String, Integer> params = null;
        if (auth != null) {
            for (Integer authId : auth) {
                params = new HashMap<String, Integer>();
                params.put("roleId", role.getId());
                params.put("authId", authId);
                securityRoleMapper.insertRoleAuth(params);
            }
        }
        return num > 1 ? true : false;
    }

    public boolean delete(int id) {
        int num = securityRoleMapper.deleteByPrimaryKey(id);
        return num > 1 ? true : false;
    }

    public List<SecurityRole> selectByAdmin(Integer adminId) {
        return securityRoleMapper.selectByAdmin(adminId);
    }

    public SecurityRole selectById(Integer id) {
        return securityRoleMapper.selectByPrimaryKey(id);
    }

    public boolean update(SecurityRole role, Integer auth[]) {
        int num = securityRoleMapper.updateByPrimaryKey(role);
        securityRoleMapper.deleteRoleAuths(role.getId());
        Map<String, Integer> params = null;
        if (auth != null) {
            for (Integer authId : auth) {
                params = new HashMap<String, Integer>();
                params.put("roleId", role.getId());
                params.put("authId", authId);
                securityRoleMapper.insertRoleAuth(params);
            }
        }
        return num > 1 ? true : false;
    }
}
