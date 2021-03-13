package priv.java.base.unit.iam;

import priv.java.base.unit.iam.common.action.SaTokenAction;
import priv.java.base.unit.iam.common.action.SaTokenActionDefaultImpl;
import priv.java.base.unit.iam.core.config.TokenConfig;
import priv.java.base.unit.iam.core.config.TokenConfigFactory;
import priv.java.base.unit.iam.module.cookie.HTTPCookieService;
import priv.java.base.unit.iam.module.cookie.HTTPCookieServiceDefaultImpl;
import priv.java.base.unit.iam.module.token.TokenService;
import priv.java.base.unit.iam.module.token.TokenServiceDefaultImpl;
import priv.java.base.unit.iam.module.servlet.ServletService;
import priv.java.base.unit.iam.module.servlet.ServletServiceDefaultImpl;
import priv.java.base.unit.iam.core.IdentityReader;
import priv.java.base.unit.iam.core.IdentityReaderDefaultImpl;
import priv.java.base.unit.iam.common.util.SaTokenInsideUtil;

/**
 * 管理sa-token所有接口对象 
 * @author kong
 *
 */
public class IAMComponentFactory {

	
	/**
	 * 配置文件 Bean 
	 */
	private static TokenConfig config;
	public static TokenConfig getConfig() {
		if (config == null) {
			initConfig();
		}
		return config;
	}
	public static void setConfig(TokenConfig config) {
		IAMComponentFactory.config = config;
		if(config.getIsV()) {
			SaTokenInsideUtil.printSaToken();
		}
	}
	public synchronized static void initConfig() {
		if (config == null) {
			setConfig(TokenConfigFactory.createConfig());
		}
	}
	
	/**
	 * 持久化 Bean 
	 */
	public static TokenService tokenService;
	public static TokenService getSaTokenDao() {
		if (tokenService == null) {
			initSaTokenDao();
		}
		return tokenService;
	}
	public static void setSaTokenDao(TokenService tokenService) {
		if(IAMComponentFactory.tokenService != null && (IAMComponentFactory.tokenService instanceof TokenServiceDefaultImpl)) {
			((TokenServiceDefaultImpl) IAMComponentFactory.tokenService).endRefreshTimer();
		}
		IAMComponentFactory.tokenService = tokenService;
	}
	public synchronized static void initSaTokenDao() {
		if (tokenService == null) {
			setSaTokenDao(new TokenServiceDefaultImpl());
		}
	}
	
	/**
	 * 权限认证 Bean 
	 */
	public static IdentityReader identityReader;
	public static IdentityReader getStpInterface() {
		if (identityReader == null) {
			initStpInterface();
		}
		return identityReader;
	}
	public static void setStpInterface(IdentityReader identityReader) {
		IAMComponentFactory.identityReader = identityReader;
	}
	public synchronized static void initStpInterface() {
		if (identityReader == null) {
			setStpInterface(new IdentityReaderDefaultImpl());
		}
	}
	
	/**
	 * 框架行为 Bean 
	 */
	public static SaTokenAction saTokenAction;
	public static SaTokenAction getSaTokenAction() {
		if (saTokenAction == null) {
			initSaTokenAction();
		}
		return saTokenAction;
	}
	public static void setSaTokenAction(SaTokenAction saTokenAction) {
		IAMComponentFactory.saTokenAction = saTokenAction;
	}
	public synchronized static void initSaTokenAction() {
		if (saTokenAction == null) {
			setSaTokenAction(new SaTokenActionDefaultImpl());
		}
	}

	/**
	 * Cookie操作 Bean 
	 */
	public static HTTPCookieService HTTPCookieService;
	public static HTTPCookieService getSaTokenCookie() {
		if (HTTPCookieService == null) {
			initSaTokenCookie();
		}
		return HTTPCookieService;
	}
	public static void setSaTokenCookie(HTTPCookieService HTTPCookieService) {
		IAMComponentFactory.HTTPCookieService = HTTPCookieService;
	}
	public synchronized static void initSaTokenCookie() {
		if (HTTPCookieService == null) {
			setSaTokenCookie(new HTTPCookieServiceDefaultImpl());
		}
	}
	
	/**
	 * Servlet操作 Bean 
	 */
	public static ServletService servletService;
	public static ServletService getSaTokenServlet() {
		if (servletService == null) {
			initSaTokenServlet();
		}
		return servletService;
	}
	public static void setSaTokenServlet(ServletService servletService) {
		IAMComponentFactory.servletService = servletService;
	}
	public synchronized static void initSaTokenServlet() {
		if (servletService == null) {
			setSaTokenServlet(new ServletServiceDefaultImpl());
		}
	}
	
	
	
	
	
}
