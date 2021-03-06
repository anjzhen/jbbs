package cc.ymee.jbbs.module.security.service;

import cc.ymee.jbbs.module.security.mapper.SecurityAuthMapper;
import cc.ymee.jbbs.module.security.pojo.SecurityAuth;
import cc.ymee.jbbs.module.security.pojo.SecurityAuthExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthService {
	
	@Autowired
	private SecurityAuthMapper securityAuthMapper;
	
	/**
	 * 查询权限列表
	 * @return
	 */
	public List<SecurityAuth> selectAll() {
		SecurityAuthExample example=new SecurityAuthExample();
		example.setOrderByClause(" display_index asc");
		return securityAuthMapper.selectByExample(example);
	}
	
	/**
	 * 查询子权限
	 * @param pid
	 * @return
	 */
	public List<SecurityAuth> selectByPid(int pid) {
		SecurityAuthExample example=new SecurityAuthExample();
		example.createCriteria().andPidEqualTo(pid);
		example.setOrderByClause(" display_index asc,id asc");
		return securityAuthMapper.selectByExample(example);
	}

	public boolean delete(Integer id) {
		int num = securityAuthMapper.deleteByPrimaryKey(id);
		return num > 1 ? true : false;
	}

	public SecurityAuth selectById(Integer id) {
		return securityAuthMapper.selectByPrimaryKey(id);
	}

	public boolean save(SecurityAuth securityAuth) {
		int num = securityAuthMapper.insert(securityAuth);
		return num > 1 ? true : false;
	}

	public List<SecurityAuth> selectByRole(Integer roleId) {
		return securityAuthMapper.selectByRole(roleId);
	}

	public boolean update(SecurityAuth auth) {
		int num = securityAuthMapper.updateByPrimaryKey(auth);
		return num > 1 ? true : false;
	}

	public List<SecurityAuth> selectByAdmin(Integer id) {
		return securityAuthMapper.selectByAdmin(id);
	}
	
}
