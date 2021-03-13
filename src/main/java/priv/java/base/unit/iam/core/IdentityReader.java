package priv.java.base.unit.iam.core;

import java.util.List;

/**
 * 身份读取器接口
 * 权限认证接口，实现此接口即可集成权限认证功能
 * 
 * @author kong
 */
public interface IdentityReader {

	/**
	 * 返回指定 LoginId 所拥有的权限码集合 
	 * 
	 * @param loginId  账号id
	 * @param loginKey 账号体系标识
	 * @return 该账号id具有的权限码集合
	 */
	public List<String> getPermissionList(Object loginId, String loginKey);

	/**
	 * 返回指定loginId所拥有的角色标识集合 
	 * 
	 * @param loginId  账号id
	 * @param loginKey 账号体系标识
	 * @return 该账号id具有的角色标识集合
	 */
	public List<String> getRoleList(Object loginId, String loginKey);

}
