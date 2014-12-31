package cc.ymee.jbbs.module.record.mapper;

import cc.ymee.jbbs.module.record.pojo.AdminLogin;
import cc.ymee.jbbs.module.record.pojo.AdminLoginExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface AdminLoginMapper {
    int countByExample(AdminLoginExample example);

    int deleteByExample(AdminLoginExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminLogin record);

    int insertSelective(AdminLogin record);

    List<AdminLogin> selectByExampleWithRowbounds(AdminLoginExample example, RowBounds rowBounds);

    List<AdminLogin> selectByExample(AdminLoginExample example);

    AdminLogin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminLogin record, @Param("example") AdminLoginExample example);

    int updateByExample(@Param("record") AdminLogin record, @Param("example") AdminLoginExample example);

    int updateByPrimaryKeySelective(AdminLogin record);

    int updateByPrimaryKey(AdminLogin record);
}