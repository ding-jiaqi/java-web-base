package priv.java.base.unit.iam.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限校验：标注在一个方法上，当前会话必须具有指定权限才能进入该方法 
 * <p> 可标注在类上，其效果等同于标注在此类的所有方法上 
 * @author kong
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface ActionCheck {

	/**
	 * 需要校验的权限码
	 * @return 需要校验的权限码
	 */
	String [] value() default {};

	/**
	 * 验证模式：AND | OR，默认AND
	 * @return 验证模式
	 */
	CheckManner mode() default CheckManner.AND;
	
}