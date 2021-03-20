package priv.java.base.access.module.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import priv.java.base.access.module.user.dao.UserMapper;
import priv.java.base.common.bean.entity.UserDO;
import priv.java.base.common.constant.ResultEnum;
import priv.java.base.access.module.user.model.AddUserForm;
import priv.java.base.access.module.user.model.ListUserForm;
import priv.java.base.access.module.user.service.IUserService;
import priv.java.base.common.util.MethodUtil;
import priv.java.base.common.bean.model.PageVO;
import priv.java.base.common.bean.model.UserVO;
import priv.java.base.common.exception.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author huangxunhui
 * @date Created in 2020/3/6 4:50 下午
 * Utils: Intellij Idea
 * Description: 用户服务实现类
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements IUserService {

    private final UserMapper userMapper;

    /**
     * 添加用户
     * @param userForm 表单数据
     * @return true 或者 false
     */
    @Override
    public boolean addUser(AddUserForm userForm) {
        return save(userForm.buildEntity());
    }

    /**
     * 获取用户列表
     * @param listUserForm 表单数据
     * @return 用户列表
     */
    @Override
    public PageVO<UserVO> listUser(ListUserForm listUserForm) {
        PageVO<UserVO> pageVo = new PageVO<UserVO>().setCurrentAndSize(listUserForm);
        pageVo.setTotal(countUser(listUserForm.getStatus()));
        pageVo.setRecords(userMapper.listUser(listUserForm.calcCurrent()));
        return pageVo;
    }

    /**
     * 删除用户
     * @param id id
     */
    @Override
    public void deleteUser(String id) {
        // 如果删除失败抛出异常。 -- 演示而已不推荐这样干
        if(!removeById(id)){
            throw new CustomException(ResultEnum.DELETE_ERROR, MethodUtil.getLineInfo());
        }
    }

    /**
     * 获取用户数量
     * @param status 状态
     * @return 用户数量
     */
    private Integer countUser(String status){
        return count(new QueryWrapper<UserDO>().eq("status",status));
    }

}
