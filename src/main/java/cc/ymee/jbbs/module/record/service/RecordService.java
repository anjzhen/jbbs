package cc.ymee.jbbs.module.record.service;

import cc.ymee.jbbs.module.record.core.RecordLogContext;
import cc.ymee.jbbs.module.record.mapper.AdminLoginMapper;
import cc.ymee.jbbs.module.record.mapper.AdminRecordMapper;
import cc.ymee.jbbs.module.record.pojo.AdminLogin;
import cc.ymee.jbbs.module.record.pojo.AdminLoginExample;
import cc.ymee.jbbs.module.record.pojo.AdminRecord;
import cc.ymee.jbbs.module.record.pojo.AdminRecordWithBLOBs;
import cc.ymee.third.mybaits.Page;
import cc.ymee.third.mybaits.ParsePagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>Create by 14/11/17 下午1:53</p>
 *
 * @author :anjero by
 * @version :1.0
 */

@Service
public class RecordService {

    @Resource
    private AdminLoginMapper adminLoginMapper;

    @Resource
    private AdminRecordMapper recordMapper;


    public AdminLogin insert(AdminLogin adminLogin) {

        int num = adminLoginMapper.insert(adminLogin);
        return num > 0 ? adminLogin : null;
    }

    /**
     * 分页查询
     *
     * @return
     */
    public Page page() {
        return page(null);
    }

    public Page page(Integer adminId) {
        ParsePagination parsePagination = new ParsePagination();
        int pageNo = parsePagination.getPageNo();
        int pageSize = parsePagination.getPageSize();
        AdminLoginExample example = new AdminLoginExample();
        AdminLoginExample.Criteria criteria = example.createCriteria();
        if (adminId != null) {
            criteria.andAdminIdEqualTo(adminId);
        }
        example.setOrderByClause("in_time desc");
        int count = adminLoginMapper.countByExample(example);
        example.setLimitStart((pageNo - 1) * pageSize);
        example.setLimitEnd(pageSize);
        List<AdminLogin> list = adminLoginMapper.selectByExample(example);
        Page page = new Page(count, pageNo, pageSize, list);
        return page;
    }

    /**
     * 只查询最后五条登录记录
     *
     * @param adminId 管理员ID
     * @return
     */
    public Page lastLogin(Integer adminId) {
//        ParsePagination parsePagination = new ParsePagination();
        int pageNo = 1;
        int pageSize = 5;
        AdminLoginExample example = new AdminLoginExample();
        AdminLoginExample.Criteria criteria = example.createCriteria();
        if (adminId != null) {
            criteria.andAdminIdEqualTo(adminId);
        }
        example.setOrderByClause("in_time desc");
        int count = adminLoginMapper.countByExample(example);
        example.setLimitStart((pageNo - 1) * pageSize);
        example.setLimitEnd(pageSize);
        List<AdminLogin> list = adminLoginMapper.selectByExample(example);
        Page page = new Page(count, pageNo, pageSize, list);
        return page;
    }

    /**
     * 保存操作记录
     *
     * @param adminId  管理员ID
     * @param key      操作key,见record.properties
     * @param srcData  源数据
     * @param destData 操作后数据
     * @return
     */
    public AdminRecord insert(Integer adminId, String key, String srcData, String destData) {
        AdminRecordWithBLOBs record = new AdminRecordWithBLOBs();
        record.setInTime(new Date());
        record.setEndData(destData);
        record.setSourceData(srcData);
        record.setRecordKey(key);
        record.setAdminId(adminId);
        record.setRecordContent(RecordLogContext.getValue(key));
        int num = recordMapper.insert(record);
        return num > 0 ? record : null;
    }
}
