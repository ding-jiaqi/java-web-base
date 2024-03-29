package priv.java.base.unit.iam.common.exception;

import priv.java.base.unit.iam.module.login.LoginManager;

/**
 * 没有指定权限码，抛出的异常 
 * 
 * @author kong
 *
 */
public class NotPermissionException extends TokenException {

	/**
	 * 序列化版本号 
	 */
	private static final long serialVersionUID = 6806129545290130142L;

	/** 权限码 */
	private String code;

	/**
	 * @return 获得权限码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * loginKey
	 */
	private String loginKey;

	/**
	 * 获得loginKey
	 * 
	 * @return loginKey
	 */
	public String getLoginKey() {
		return loginKey;
	}

	public NotPermissionException(String code) {
		this(code, LoginManager.loginUnit.loginKey);
	}

	public NotPermissionException(String code, String loginKey) {
		super("无此权限：" + code);
		this.code = code;
		this.loginKey = loginKey;
	}

}
