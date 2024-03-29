package priv.java.base.unit.iam.common.action;

import java.util.UUID;

import priv.java.base.unit.iam.IAMComponentFactory;
import priv.java.base.unit.iam.module.session.Session;
import priv.java.base.unit.iam.common.util.AppConst;
import priv.java.base.unit.iam.common.util.SaTokenInsideUtil;

/**
 * 对 SaTokenAction 接口的默认实现 
 * @author kong
 *
 */
public class SaTokenActionDefaultImpl implements SaTokenAction {

	
	/**
	 * 根据一定的算法生成一个token 
	 */
	@Override
	public String createToken(Object loginId, String loginKey) {
		// 根据配置的tokenStyle生成不同风格的token 
		String tokenStyle = IAMComponentFactory.getConfig().getTokenStyle();
		// uuid 
		if(AppConst.TOKEN_STYLE_UUID.equals(tokenStyle)) {
			return UUID.randomUUID().toString();
		}
		// 简单uuid (不带下划线)
		if(AppConst.TOKEN_STYLE_SIMPLE_UUID.equals(tokenStyle)) {
			return UUID.randomUUID().toString().replaceAll("-", "");
		}
		// 32位随机字符串
		if(AppConst.TOKEN_STYLE_RANDOM_32.equals(tokenStyle)) {
			return SaTokenInsideUtil.getRandomString(32);
		}
		// 64位随机字符串
		if(AppConst.TOKEN_STYLE_RANDOM_64.equals(tokenStyle)) {
			return SaTokenInsideUtil.getRandomString(64);
		}
		// 128位随机字符串
		if(AppConst.TOKEN_STYLE_RANDOM_128.equals(tokenStyle)) {
			return SaTokenInsideUtil.getRandomString(128);
		}
		// tik风格 (2_14_16)
		if(AppConst.TOKEN_STYLE_RANDOM_TIK.equals(tokenStyle)) {
			return SaTokenInsideUtil.getRandomString(2) + "_" + SaTokenInsideUtil.getRandomString(14) + "_" + SaTokenInsideUtil.getRandomString(16) + "__";
		}
		// 默认，还是uuid 
		return UUID.randomUUID().toString();
	}

	
	/**
	 * 根据 SessionId 创建一个 Session 
	 */
	@Override
	public Session createSession(String sessionId) {
		return new Session(sessionId);
	}
	
}
