package priv.java.base.core.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import priv.java.base.common.util.SnowFlakeFactory;
import priv.java.base.unit.iam.module.login.LoginManager;

import java.time.LocalDateTime;

/**
 * 实体基层
 * Created at 2021/3/20 14:33
 *
 * @version 1.0
 * @author: DingJiaQi
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaseEntity {

    // 唯一标识
    private String id;

    // 删除的
    private Boolean deleted;

    // 启用的
    private Boolean enabled;

    // 创建时间
    private LocalDateTime creationTime;

    // 修改时间
    private LocalDateTime revisionTime;

    // 删除时间
    private LocalDateTime deletionTime;

    // 创建人
    private String creator;

    // 修改人
    private String reviser;

    // 删除人
    private String destroyer;

    /**
     * 创建痕迹
     */
    protected void createMark() {
        this.setId(
                SnowFlakeFactory.generateID()
        );
        // 未删除
        this.setDeleted(false);
        // 已启用
        this.setEnabled(true);
        this.setCreationTime(LocalDateTime.now());
        // 当前用户
        this.setCreator(LoginManager.getUserId("-1"));
    }

    /**
     * 更新痕迹
     */
    protected void updateMark() {

        this.setRevisionTime(LocalDateTime.now());
        // 当前用户
        this.setReviser(LoginManager.getUserId("-1"));
    }

    /**
     * 逻辑删除
     */
    protected void deleteMark() {
        // 标记删除
        this.setDeleted(true);
        this.setDeletionTime(LocalDateTime.now());
        this.setDestroyer(LoginManager.getUserId("-1"));
    }
}
