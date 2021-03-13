package priv.java.base.access.module.user.service;

import priv.java.base.common.bean.entity.UserDO;
import priv.java.base.access.module.user.model.AddUserForm;
import priv.java.base.access.module.user.model.ListUserForm;
import priv.java.base.common.bean.model.PageVO;
import priv.java.base.common.bean.model.UserVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author huangxunhui
 * @date Created in 2020/3/6 4:51 下午
 * Utils: Intellij Idea
 * Description: 用户服务类
 */
public interface IUserService extends IService<UserDO> {

    /**
     * 添加用户
     * @param userForm 表单数据
     * @return true 或者 false
     */
    boolean addUser(AddUserForm userForm);

    /**
     * 获取用户列表
     * @param listUserForm 表单数据
     * @return 用户列表
     */
    PageVO<UserVO> listUser(ListUserForm listUserForm);

    /**
     * 删除用户
     * @param id id
     */
    void deleteUser(String id);

}
