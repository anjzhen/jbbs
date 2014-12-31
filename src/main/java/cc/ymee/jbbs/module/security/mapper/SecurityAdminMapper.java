package cc.ymee.jbbs.module.security.mapper;

import cc.ymee.jbbs.module.security.pojo.SecurityAdmin;
import cc.ymee.jbbs.module.security.pojo.SecurityAdminExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface SecurityAdminMapper {
    int countByExample(SecurityAdminExample example);

    int deleteByExample(SecurityAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecurityAdmin record);

    int insertSelective(SecurityAdmin record);

    List<SecurityAdmin> selectByExampleWithRowbounds(SecurityAdminExample example, RowBounds rowBounds);

    List<SecurityAdmin> selectByExample(SecurityAdminExample example);

    SecurityAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecurityAdmin record, @Param("example") SecurityAdminExample example);

    int updateByExample(@Param("record") SecurityAdmin record, @Param("example") SecurityAdminExample example);

    int updateByPrimaryKeySelective(SecurityAdmin record);

    int updateByPrimaryKey(SecurityAdmin record);

    SecurityAdmin login(SecurityAdminExample example);

    int deleteAdminRoles(Integer adminId);

    int insertAdminRole(Map<String, Integer> adminRoles);

}