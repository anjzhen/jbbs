package cc.ymee.jbbs.module.record.mapper;

import cc.ymee.jbbs.module.record.pojo.AdminRecord;
import cc.ymee.jbbs.module.record.pojo.AdminRecordExample;
import cc.ymee.jbbs.module.record.pojo.AdminRecordWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface AdminRecordMapper {
    int countByExample(AdminRecordExample example);

    int deleteByExample(AdminRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminRecordWithBLOBs record);

    int insertSelective(AdminRecordWithBLOBs record);

    List<AdminRecordWithBLOBs> selectByExampleWithBLOBsWithRowbounds(AdminRecordExample example, RowBounds rowBounds);

    List<AdminRecordWithBLOBs> selectByExampleWithBLOBs(AdminRecordExample example);

    List<AdminRecord> selectByExampleWithRowbounds(AdminRecordExample example, RowBounds rowBounds);

    List<AdminRecord> selectByExample(AdminRecordExample example);

    AdminRecordWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminRecordWithBLOBs record, @Param("example") AdminRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") AdminRecordWithBLOBs record, @Param("example") AdminRecordExample example);

    int updateByExample(@Param("record") AdminRecord record, @Param("example") AdminRecordExample example);

    int updateByPrimaryKeySelective(AdminRecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AdminRecordWithBLOBs record);

    int updateByPrimaryKey(AdminRecord record);
}