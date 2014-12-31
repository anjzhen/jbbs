package cc.ymee.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class AgentUtil {


	/**
	 * 检测浏览器UA
	 * 
	 * @return
	 */
	public static String getAgent() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String agent = request.getHeader("USER-AGENT").toLowerCase();
		if (agent == null || agent.equals("")) {
			return "web";
		} else {
			if (agent.indexOf("iphone") > 0) {
				return "iphone";
			} else if (agent.indexOf("ipad") > 0) {
				return "ipad";
			} else if (agent.indexOf("android") > 0) {
				return "android";
			}
		}
		return "web";
	}
}
