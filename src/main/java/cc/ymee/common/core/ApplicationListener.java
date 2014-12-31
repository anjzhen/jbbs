package cc.ymee.common.core;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public final class ApplicationListener implements ServletContextListener {

    private static final Logger LOG = Logger.getLogger("system");

    private static String projectPath;


    public void contextDestroyed(ServletContextEvent event) {

    }


    public void contextInitialized(ServletContextEvent event) {

        WebApplicationContext wac = WebApplicationContextUtils
                .getRequiredWebApplicationContext(event.getServletContext());
        // 初始化系统环境变量
        this.projectPath = event.getServletContext().getRealPath("/");

        ApplicationConstants.setProjectPath(projectPath);
        LOG.info("start init system");

        // 初始化msgcode
        //MsgInitContext.init(wac.getServletContext().getRealPath("/"));
        LOG.info("=============System=================");
        LOG.info("inited system config...");
        LOG.info("ICHEFENG-DEALER WEBSERVER STARTED!!!");
        LOG.info("====================================");

    }

    /**
     * 得到工程绝对路径
     *
     * @return
     */
    public static String getProjectPath() {
        return projectPath;
    }

}
