package cc.ymee.jbbs.module.record.core;

/**
 * 记录配置Key 。
 * <p>Create by 14/12/12 下午6:57</p>
 *
 * @author :anjero by
 * @version :1.0
 */
public class RecordConstants {


    //==================此处为修改开始===================

    /**
     * 消息处理模块
     */
    public static final String MODULE_MESSAGE = "message";


    //==================此处为修改结束===================

    /*
    下列方法为系统不动
     */

    /**
     * 连接后缀
     */
    private static final String APPEN_SUFFIX = ".";
    /**
     * 非管理帐号登录操作时，为默认操作ID
     */
    public static final int ADMIN_SYSTEM = -1;
    /**
     * 空字符串
     */
    public static final String DATA_EMPTY = "";

    public static final String INSERT = "insert";
    public static final String DELETE = "delete";
    public static final String UPDATE = "update";


    /**
     * 添加操作
     *
     * @param module 所属模块，如:MODULE_MESSAGE
     * @return
     */
    public static String insert(String module) {
        StringBuilder builder = new StringBuilder(module);
        return builder.append(APPEN_SUFFIX).append(INSERT).toString();
    }

    /**
     * 更新操作
     *
     * @param module 所属模块，如:MODULE_MESSAGE
     * @return
     */
    public static String update(String module) {
        StringBuilder builder = new StringBuilder(module);
        return builder.append(APPEN_SUFFIX).append(UPDATE).toString();
    }

    /**
     * 删除操作
     *
     * @param module 所属模块，如:MODULE_MESSAGE
     * @return
     */
    public static String delete(String module) {
        StringBuilder builder = new StringBuilder(module);
        return builder.append(APPEN_SUFFIX).append(DELETE).toString();
    }


}
