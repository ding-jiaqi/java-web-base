package priv.java.base.unit.iam.module.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * sa-token 对cookie的相关操作 接口实现类
 * 
 * @author kong
 *
 */
public class HTTPCookieServiceDefaultImpl implements HTTPCookieService {

	/**
	 * 获取指定cookie
	 */
	@Override
	public Cookie getCookie(HttpServletRequest request, String cookieName) {
		return HTTPCookieDao.getCookie(request, cookieName);
	}

	/**
	 * 添加cookie
	 */
	@Override
	public void addCookie(HttpServletResponse response, String name, String value, String path, String domain, int timeout) {
		HTTPCookieDao.addCookie(response, name, value, path, domain, timeout);
	}

	/**
	 * 删除cookie
	 */
	@Override
	public void delCookie(HttpServletRequest request, HttpServletResponse response, String name) {
		HTTPCookieDao.delCookie(request, response, name);
	}

	/**
	 * 修改cookie的value值
	 */
	@Override
	public void updateCookie(HttpServletRequest request, HttpServletResponse response, String name, String value) {
		HTTPCookieDao.updateCookie(request, response, name, value);
	}

}
