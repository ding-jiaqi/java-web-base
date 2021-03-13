package priv.java.base.unit.iam.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 对StpInterface接口默认的实现类
 * <p>
 * 如果开发者没有实现StpInterface接口，则使用此默认实现
 * 
 * @author kong
 */
public class IdentityReaderDefaultImpl implements IdentityReader {

	@Override
	public List<String> getPermissionList(Object loginId, String loginKey) {
		return new ArrayList<String>();
	}

	@Override
	public List<String> getRoleList(Object loginId, String loginKey) {
		return new ArrayList<String>();
	}

}
