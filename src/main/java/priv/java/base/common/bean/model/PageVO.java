package priv.java.base.common.bean.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import priv.java.base.core.base.PageForm;

import java.util.List;

/**
 * @author huangxunhui
 * Date: Created in 2019-03-18 21:49
 * Utils: Intellij Idea
 * Description: 分页视图对象
 */
@Data
public class PageVO<T> {
    /**
     * 分页数据
     */
    @ApiModelProperty(value = "页数据")
    private List<T> records;
    /**
     * 总条数
     */
    @ApiModelProperty(value = "总记录数")
    private Integer total;

    /**
     * 总页数
     */
    @ApiModelProperty(value = "页数")
    private Integer pages;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页码")
    private Integer current;

    /**
     * 查询数量
     */
    @ApiModelProperty(value = "查询数量")
    private Integer size;

    /**
     * 设置当前页和每页显示的数量
     * @param pageForm 分页表单
     * @return 返回分页信息
     */
    @ApiModelProperty(hidden = true)
    public PageVO<T> setCurrentAndSize(PageForm<?> pageForm){
        BeanUtils.copyProperties(pageForm,this);
        return this;
    }

    /**
     * 设置总记录数
     * @param total 总记录数
     */
    @ApiModelProperty(hidden = true)
    public void setTotal(Integer total) {
        this.total = total;
        this.setPages(this.total % this.size > 0 ? this.total / this.size + 1 : this.total / this.size);
    }
}
