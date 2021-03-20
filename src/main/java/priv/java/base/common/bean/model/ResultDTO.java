package priv.java.base.common.bean.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author huangxunhui
 * Date: Created in 2018-12-17 11:05
 * Utils: Intellij Idea
 * Description: 固定返回格式
 */
@Data
@ApiModel("固定返回格式")
public class ResultDTO<T> {

    /**
     * 错误码
     */
    @ApiModelProperty("状态码")
    private Integer code;

    /**
     * 提示信息
     */
    @ApiModelProperty("消息")
    private String message;

    /**
     * 具体的内容
     */
    @ApiModelProperty("数据")
    private T data;

}
