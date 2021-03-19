package priv.java.base.unit.iam.module.login;

import java.util.List;

import priv.java.base.unit.iam.common.model.LoginLicense;
import priv.java.base.unit.iam.common.model.TokenCard;
import priv.java.base.unit.iam.module.session.Session;

/**
 * 登录管理器
 * userId: 用户标识
 * 一个默认的实现 
 * @author kong 
 */
public class LoginManager {

	/**
	 * 底层的 StpLogic 对象  
	 */
	public static LoginUnit loginUnit = new LoginUnit("login");

	
	/**
	 * 获取当前StpLogin的loginKey 
	 * @return 当前StpLogin的loginKey
	 */
	public static String getLoginKey(){
		return loginUnit.getLoginKey();
	}

	
	// =================== 获取token 相关 ===================

	/**
	 * 返回token名称 
	 * @return 此StpLogic的token名称
	 */
	public static String getTokenName() {
 		return loginUnit.getTokenName();
 	}

	/**
	 * 获取当前tokenValue
	 * @return 当前tokenValue
	 */
	public static String getTokenValue() {
		return loginUnit.getTokenValue();
	}

	/**
	 * 获取当前会话的token信息 
	 * @return token信息 
	 */
	public static TokenCard getTokenInfo() {
		return loginUnit.getTokenInfo();
	}

	
	// =================== 登录相关操作 ===================

	/**
	 * 保持登录状态，包含用户ID
	 * 在当前会话上登录id 
	 * @param loginId 登录id，建议的类型：（long | int | String）
	 */
	public static void staySignedIn(Object loginId) {
		loginUnit.setLoginId(loginId);
	}

	/**
	 * 保持登录状态，包含用户ID+设备
	 * 在当前会话上登录id, 并指定登录设备 
	 * @param loginId 登录id，建议的类型：（long | int | String）
	 * @param device 设备标识 
	 */
	public static void staySignedIn(Object loginId, String device) {
		loginUnit.setLoginId(loginId, device);
	}

	/**
	 * 保持登录状态，包含用户ID，临时的
	 * 在当前会话上登录id, 并指定登录设备 
	 * @param loginId 登录id，建议的类型：（long | int | String）
	 * @param isTempCookie 是否为临时Cookie 
	 */
	public void staySignedIn(Object loginId, boolean isTempCookie) {
		loginUnit.setLoginId(loginId, isTempCookie);
	}
	
	/**
	 * 保持登录状态，包含用户ID+自定义信息
	 * 在当前会话上登录id, 并指定所有登录参数Model 
	 * @param loginId 登录id，建议的类型：（long | int | String）
	 * @param loginModel 此次登录的参数Model 
	 */
	public static void staySignedIn(Object loginId, LoginLicense loginModel) {
		loginUnit.setLoginId(loginId, loginModel);
	}
	
	/** 
	 * 注销当前会话
	 */
	public static void logoutCurrentSession() {
		loginUnit.logout();
	}

	/**
	 * 指定token的会话注销登录 
	 * @param tokenValue 指定token
	 */
	public static void logoutByTokenValue(String tokenValue) {
		loginUnit.logoutByTokenValue(tokenValue);
	}
	
	/**
	 * 指定loginId的会话注销登录（踢人下线）
	 * <p> 当对方再次访问系统时，会抛出NotLoginException异常，场景值=-2
	 * @param loginId 账号id 
	 */
	public static void logoutByUserId(Object loginId) {
		loginUnit.logoutByLoginId(loginId);
	}

	/**
	 * 指定loginId指定设备的会话注销登录（踢人下线）
	 * <p> 当对方再次访问系统时，会抛出NotLoginException异常，场景值=-2
	 * @param loginId 账号id 
	 * @param device 设备标识 
	 */
	public static void logoutByUserId(Object loginId, String device) {
		loginUnit.logoutByLoginId(loginId, device);
	}
	
	
	// 查询相关

 	/** 
 	 * 获取当前会话是否已经登录 
 	 * @return 是否已登录 
 	 */
	public static boolean isLogin() {
		return loginUnit.isLogin();
	}

 	/** 
 	 * 检验当前会话是否已经登录，如未登录，则抛出异常 
 	 */
 	public static void checkLogin() {
 		loginUnit.checkLogin();
 	}

 	/** 
 	 * 获取当前会话账号id, 如果未登录，则抛出异常 
 	 * @return 账号id
 	 */
	public static Object getUserId() {
		return loginUnit.getLoginId();
	}

	/** 
	 * 获取当前会话登录id, 如果未登录，则返回默认值 
	 * @param <T> 返回类型 
	 * @param defaultValue 默认值
	 * @return 登录id 
	 */
	public static <T> T getUserId(T defaultValue) {
		return loginUnit.getLoginId(defaultValue);
	}

	/** 
	 * 获取当前会话登录id, 如果未登录，则返回null 
	 * @return 账号id 
	 */
	public static Object getUserIdDefaultNull() {
		return loginUnit.getLoginIdDefaultNull();
 	}

	/** 
	 * 获取当前会话登录id, 并转换为String
	 * @return 账号id 
	 */
	public static String getUserIdAsString() {
		return loginUnit.getLoginIdAsString();
	}

	/** 
	 * 获取当前会话登录id, 并转换为int
	 * @return 账号id 
	 */
	public static int getUserIdAsInt() {
		return loginUnit.getLoginIdAsInt();
	}

	/**
	 * 获取当前会话登录id, 并转换为long
	 * @return 账号id 
	 */
	public static long getUserIdAsLong() {
		return loginUnit.getLoginIdAsLong();
	}

 	/** 
 	 * 获取指定token对应的登录id，如果未登录，则返回 null 
 	 * @param tokenValue token
 	 * @return 登录id
 	 */
 	public static Object getUserIdByToken(String tokenValue) {
 		return loginUnit.getLoginIdByToken(tokenValue);
 	}
	
 	
	// =================== session相关 ===================

	/** 
	 * 获取指定loginId的session, 如果session尚未创建，isCreate=是否新建并返回
	 * @param loginId 账号id
	 * @param isCreate 是否新建
	 * @return SaSession
	 */
	public static Session getSessionByLoginId(Object loginId, boolean isCreate) {
		return loginUnit.getSessionByLoginId(loginId, isCreate);
	}

	/** 
	 * 获取指定key的session, 如果session尚未创建，则返回null
	 * @param sessionId sessionId
	 * @return session对象 
	 */
	public static Session getSessionBySessionId(String sessionId) {
		return loginUnit.getSessionBySessionId(sessionId);
	}

	/** 
	 * 获取指定loginId的session，如果session尚未创建，则新建并返回 
	 * @param loginId 账号id 
	 * @return session会话 
	 */
	public static Session getSessionByUserId(Object loginId) {
		return loginUnit.getSessionByLoginId(loginId);
	}

	/** 
	 * 获取当前会话的session, 如果session尚未创建，isCreate=是否新建并返回 
	 * @param isCreate 是否新建 
	 * @return 当前会话的session 
	 */
	public static Session getSession(boolean isCreate) {
		return loginUnit.getSession(isCreate);
	}

	/** 
	 * 获取当前会话的session，如果session尚未创建，则新建并返回 
	 * @return 当前会话的session 
	 */
	public static Session getSession() {
		return loginUnit.getSession();
	}

	
	// =================== token专属session ===================  
	
	/** 
	 * 获取指定token的专属session，如果session尚未创建，则新建并返回 
	 * @param tokenValue token值
	 * @return session会话 
	 */
	public static Session getTokenSessionByToken(String tokenValue) {
		return loginUnit.getTokenSessionByToken(tokenValue);
	}
	
	/** 
	 * 获取当前token的专属-session，如果session尚未创建，则新建并返回 
	 * @return session会话 
	 */
	public static Session getTokenSession() {
		return loginUnit.getTokenSession();
	}


	// =================== [临时过期] 验证相关 ===================  

 	/**
 	 * 检查当前token 是否已经[临时过期]，如果已经过期则抛出异常  
 	 */
 	public static void checkActivityTimeout() {
 		loginUnit.checkActivityTimeout();
 	}

 	/**
 	 * 续签当前token：(将 [最后操作时间] 更新为当前时间戳) 
 	 * <h1>请注意: 即时token已经 [临时过期] 也可续签成功，
 	 * 如果此场景下需要提示续签失败，可在此之前调用 checkActivityTimeout() 强制检查是否过期即可 </h1>
 	 */
 	public static void updateLastActivityToNow() {
 		loginUnit.updateLastActivityToNow();
 	}
 	

	// =================== 过期时间相关 ===================  

 	/**
 	 * 获取当前登录者的token剩余有效时间 (单位: 秒)
 	 * @return token剩余有效时间
 	 */
 	public static long getTokenTimeout() {
 		return loginUnit.getTokenTimeout();
 	}
 	
 	/**
 	 * 获取当前登录者的Session剩余有效时间 (单位: 秒)
 	 * @return token剩余有效时间
 	 */
 	public static long getSessionTimeout() {
 		return loginUnit.getSessionTimeout();
 	}

 	/**
 	 * 获取当前token的专属Session剩余有效时间 (单位: 秒) 
 	 * @return token剩余有效时间
 	 */
 	public static long getTokenSessionTimeout() {
 		return loginUnit.getTokenSessionTimeout();
 	}
 	
 	/**
 	 * 获取当前token[临时过期]剩余有效时间 (单位: 秒)
 	 * @return token[临时过期]剩余有效时间
 	 */
 	public static long getTokenActivityTimeout() {
 		return loginUnit.getTokenActivityTimeout();
 	}
 	

 	
	// =================== 角色验证操作 ===================  

 	/** 
 	 * 指定账号id是否含有角色标识, 返回true或false  
 	 * @param loginId 账号id
 	 * @param role 角色标识
 	 * @return 是否含有指定角色标识
 	 */
 	public static boolean hasRole(Object loginId, String role) {
 		return loginUnit.hasRole(loginId, role);
 	}
 	
 	/** 
 	 * 当前账号是否含有指定角色标识, 返回true或false 
 	 * @param role 角色标识
 	 * @return 是否含有指定角色标识
 	 */
 	public static boolean hasRole(String role) {
 		return loginUnit.hasRole(role);
 	}
	
 	/** 
 	 * 当前账号是否含有指定角色标识, 如果验证未通过，则抛出异常: NotRoleException 
 	 * @param role 角色标识
 	 */
 	public static void checkRole(String role) {
 		loginUnit.checkRole(role);
 	}

 	/** 
 	 * 当前账号是否含有指定角色标识 [指定多个，必须全部验证通过] 
 	 * @param roleArray 角色标识数组
 	 */
 	public static void checkRolesInAnd(String... roleArray){
 		loginUnit.checkRoleAnd(roleArray);
 	}

 	/** 
 	 * 当前账号是否含有指定角色标识 [指定多个，只要其一验证通过即可] 
 	 * @param roleArray 角色标识数组
 	 */
 	public static void checkRolesInOr(String... roleArray){
 		loginUnit.checkRoleOr(roleArray);
 	}
 	
	
	// =================== 权限验证操作 ===================

 	/** 
 	 * 指定账号id是否含有指定权限, 返回true或false 
 	 * @param loginId 账号id
 	 * @param permission 权限码
 	 * @return 是否含有指定权限
 	 */
	public static boolean hasPermission(Object loginId, String permission) {
		return loginUnit.hasPermission(loginId, permission);
	}

 	/** 
 	 * 当前账号是否含有指定权限, 返回true或false 
 	 * @param permission 权限码
 	 * @return 是否含有指定权限
 	 */
	public static boolean hasPermission(String permission) {
		return loginUnit.hasPermission(permission);
	}

 	/** 
 	 * 当前账号是否含有指定权限, 如果验证未通过，则抛出异常: NotPermissionException 
 	 * @param permission 权限码
 	 */
	public static void checkPermission(String permission) {
		loginUnit.checkPermission(permission);
	}

 	/** 
 	 * 当前账号是否含有指定权限 [指定多个，必须全部验证通过] 
 	 * @param permissionArray 权限码数组
 	 */
	public static void checkPermissionAnd(String... permissionArray) {
		loginUnit.checkPermissionAnd(permissionArray);
	}

 	/** 
 	 * 当前账号是否含有指定权限 [指定多个，只要其一验证通过即可] 
 	 * @param permissionArray 权限码数组
 	 */
	public static void checkPermissionOr(String... permissionArray) {
		loginUnit.checkPermissionOr(permissionArray);
	}


	// =================== id 反查token 相关操作 ===================  
	
	/** 
	 * 获取指定loginId的tokenValue 
	 * <p> 在配置为允许并发登录时，此方法只会返回队列的最后一个token，
	 * 如果你需要返回此账号id的所有token，请调用 getTokenValueListByLoginId 
	 * @param loginId 账号id
	 * @return token值 
	 */
	public static String getTokenValueByLoginId(Object loginId) {
		return loginUnit.getTokenValueByLoginId(loginId);
	}

	/** 
	 * 获取指定loginId指定设备端的tokenValue  
	 * <p> 在配置为允许并发登录时，此方法只会返回队列的最后一个token，
	 * 如果你需要返回此账号id的所有token，请调用 getTokenValueListByLoginId 
	 * @param loginId 账号id
	 * @param device 设备标识 
	 * @return token值 
	 */
	public static String getTokenValueByLoginId(Object loginId, String device) {
		return loginUnit.getTokenValueByLoginId(loginId, device);
	}
	
 	/** 
	 * 获取指定loginId的tokenValue集合 
	 * @param loginId 账号id 
	 * @return 此loginId的所有相关token 
 	 */
	public static List<String> getTokenValueListByLoginId(Object loginId) {
		return loginUnit.getTokenValueListByLoginId(loginId);
	}

 	/** 
	 * 获取指定loginId指定设备端的tokenValue集合 
	 * @param loginId 账号id 
	 * @param device 设备标识 
	 * @return 此loginId的所有相关token 
 	 */
	public static List<String> getTokenValueListByLoginId(Object loginId, String device) {
		return loginUnit.getTokenValueListByLoginId(loginId, device);
	}
	
	/**
	 * 返回当前token的登录设备 
	 * @return 当前令牌的登录设备 
	 */
	public static String getLoginDevice() {
		return loginUnit.getLoginDevice();
	}

	
	// =================== 会话管理 ===================  

	/**
	 * 根据条件查询token 
	 * @param keyword 关键字 
	 * @param start 开始处索引 (-1代表查询所有) 
	 * @param size 获取数量 
	 * @return token集合 
	 */
	public static List<String> searchTokenValue(String keyword, int start, int size) {
		return loginUnit.searchTokenValue(keyword, start, size);
	}
	
	/**
	 * 根据条件查询SessionId 
	 * @param keyword 关键字 
	 * @param start 开始处索引 (-1代表查询所有) 
	 * @param size 获取数量 
	 * @return sessionId集合 
	 */
	public static List<String> searchSessionId(String keyword, int start, int size) {
		return loginUnit.searchSessionId(keyword, start, size);
	}

	/**
	 * 根据条件查询token专属Session的Id 
	 * @param keyword 关键字 
	 * @param start 开始处索引 (-1代表查询所有) 
	 * @param size 获取数量 
	 * @return sessionId集合 
	 */
	public static List<String> searchTokenSessionId(String keyword, int start, int size) {
		return loginUnit.searchTokenSessionId(keyword, start, size);
	}
	

	// =================== 身份切换 ===================  

	/**
	 * 临时切换身份为指定loginId 
	 * @param loginId 指定loginId 
	 */
	public static void switchTo(Object loginId) {
		loginUnit.switchTo(loginId);
	}
	
	/**
	 * 结束临时切换身份
	 */
	public static void endSwitch() {
		loginUnit.endSwitch();
	}

	/**
	 * 当前是否正处于[身份临时切换]中 
	 * @return 是否正处于[身份临时切换]中 
	 */
	public static boolean isSwitch() {
		return loginUnit.isSwitch();
	}

	/**
	 * 在一个代码段里方法内，临时切换身份为指定loginId
	 * @param loginId 指定loginId 
	 * @param function 要执行的方法 
	 */
	public static void switchTo(Object loginId, Runnable function) {
		loginUnit.switchTo(loginId, function);
	}
	
	
}
