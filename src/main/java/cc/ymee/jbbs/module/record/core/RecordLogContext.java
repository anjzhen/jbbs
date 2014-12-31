package cc.ymee.jbbs.module.record.core;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * <p>Create by 14/11/17 下午6:40</p>
 *
 * @author :anjero by
 * @version :1.0
 */
public class RecordLogContext {

    static Properties messageLogProperties;

    public static String getValue(String key) {
        if (messageLogProperties == null) {
            Resource resource2 = new ClassPathResource("/message_log/record_zh.properties");
            try {
                messageLogProperties = PropertiesLoaderUtils.loadProperties(resource2);
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
        return messageLogProperties.get(key).toString();
    }
}
