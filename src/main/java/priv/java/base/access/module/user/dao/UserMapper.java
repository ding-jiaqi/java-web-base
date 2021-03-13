package priv.java.base.access.module.user.dao;

import priv.java.base.common.bean.entity.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import priv.java.base.access.module.user.model.ListUserForm;
import priv.java.base.common.bean.model.UserVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huangxunhui
 * @date Created in 2020/3/7 2:21 下午
 * Utils: Intellij Idea
 * Description: 数据库资源操作类
 */
@Repository
public interface UserMapper extends BaseMapper<UserDO> {

    /**
     * 获取用户列表
     * @param listUserForm 表单数据
     * @return 用户列表
     */
    @Select("SELECT id,nickname,username,birthday FROM `user` WHERE `status`= #{status} LIMIT #{current},#{size}")
    List<UserVO> listUser(ListUserForm listUserForm);

}
