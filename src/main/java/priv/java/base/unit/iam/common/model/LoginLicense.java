package priv.java.base.unit.iam.common.model;

import priv.java.base.unit.iam.IAMComponentFactory;
import priv.java.base.unit.iam.core.config.TokenConfig;
import priv.java.base.unit.iam.common.util.AppConst;

/**
 * 登录许可证
 * 调用 `StpUtil.setLogin()` 时的 [配置参数 Model ]
 * @author kong
 *
 */
public class LoginLicense {

	
	/**
	 * 此次登录的客户端设备标识 
	 */
	public String device;
	
	/**
	 * 指定此次登录token的有效期, 单位:秒 （如未指定，自动取全局配置的timeout值）
	 */
	public Long timeout;

	/**
	 * 是否为临时Cookie（临时Cookie会在浏览器关闭时自动删除）
	 */
	public Boolean isTempCookie;

	
	/**
	 * @return device
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * @param device 要设置的 device
	 * @return 对象自身
	 */
	public LoginLicense setDevice(String device) {
		this.device = device;
		return this;
	}

	/**
	 * @return timeout
	 */
	public Long getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout 要设置的 timeout
	 * @return 对象自身
	 */
	public LoginLicense setTimeout(long timeout) {
		this.timeout = timeout;
		return this;
	}

	/**
	 * @return isTempCookie
	 */
	public Boolean getIsTempCookie() {
		return isTempCookie;
	}

	/**
	 * @param isTempCookie 要设置的 isTempCookie
	 * @return 对象自身
	 */
	public LoginLicense setIsTempCookie(Boolean isTempCookie) {
		this.isTempCookie = isTempCookie;
		return this;
	}

	/**
	 * 构建对象，初始化默认值 
	 * @return 对象自身
	 */
	public LoginLicense build() {
		return build(IAMComponentFactory.getConfig());
	}
	
	/**
	 * 构建对象，初始化默认值 
	 * @param config 配置对象 
	 * @return 对象自身
	 */
	public LoginLicense build(TokenConfig config) {
		if(device == null) {
			device = AppConst.DEFAULT_LOGIN_DEVICE;
		}
		if(timeout == null) {
			timeout = config.getTimeout();
		}
		if(isTempCookie == null) {
			isTempCookie = false;
		}
		return this;
	}
	
	
	/**
	 * 静态方法获取一个 SaLoginModel 对象
	 * @return SaLoginModel 对象 
	 */
	public static LoginLicense create() {
		return new LoginLicense();
	}

	
}
