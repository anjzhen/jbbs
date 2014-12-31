package cc.ymee.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookies
 */
public class CookieUtils {

	private static int cookiestime = 60 * 60 * 24 * 30;

	public static Cookie getCookie(String name) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equalsIgnoreCase(name)) {
					return c;
				}
			}
		}
		return null;
	}

	/**
	 * 检查cookies
	 */
	public static void setCookies(HttpServletResponse response, String key,
			String value) {
		// 保存信息到cookie中
		try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getRequest();
			Cookie userCookie = new Cookie(key, value);
			userCookie.setPath(request.getContextPath());
			userCookie.setMaxAge(cookiestime); // 保存30天
            response.addCookie(userCookie);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clearCookie(HttpServletResponse response, String name) {
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
}
