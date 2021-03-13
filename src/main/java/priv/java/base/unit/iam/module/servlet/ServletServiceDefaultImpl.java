package priv.java.base.unit.iam.module.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.java.base.unit.iam.common.exception.TokenException;

/**
 * sa-token 对SaTokenServlet接口默认实现类
 * 
 * @author kong
 *
 */
public class ServletServiceDefaultImpl implements ServletService {

	/**
	 * 获取当前请求的Request对象
	 */
	@Override
	public HttpServletRequest getRequest() {
		throw new TokenException("请实现SaTokenServlet接口后进行Servlet相关操作");
	}

	/**
	 * 获取当前请求的Response对象
	 */
	@Override
	public HttpServletResponse getResponse() {
		throw new TokenException("请实现SaTokenServlet接口后进行Servlet相关操作");
	}

}
