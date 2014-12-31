package cc.ymee.common.core;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * weishop
 *
 * @author :anjero
 * @version :1.0
 * @Title :ApplicationConstants
 * @Description:
 * @Datetime : 14/8/19 下午3:38
 * @Copyright :Copyright (c) 2012
 *
 */
public class ApplicationConstants {


    public static final String LOCAL = "local";


    static Properties properties;

    static String project_path;

    public static String getValue(String key) {
        try {
            if (properties == null) {
                //如果配置文件在classpath目录下可以使用ClassPathResource对象
                Resource resource = new ClassPathResource("/conf.properties");
                properties = PropertiesLoaderUtils.loadProperties(resource);
            }
            //根URL
            return new String(properties.get(key).toString().getBytes("ISO8859-1"),"utf-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 是否为本机测试环境
     *
     * @return
     */
    public static final boolean isLocal() {
        String mode = getValue("base.mode");
        if (!StringUtils.isEmpty(mode) && mode.equals(LOCAL)) {
            return true;
        }

        return false;
    }

    public static String baseUrl() {
        return getValue("base.url");
    }

    public static String staticPath() {
//        return getValue("base.upload.path");
        if (project_path == null) {
            return "/var/conf";
        }
        return project_path;
    }

    public static void setProjectPath(String path) {
        project_path = path;
    }

    public static String staticUrl() {
        return getValue("base.static.url");
    }


    public static String staticVersion() {
        return getValue("static.version");
    }

    public static String mailDev() {return getValue("dev.mail");
    }
}
