package priv.java.base.unit.iam.common.exception;

/**
 * sa-token框架内部逻辑发生错误抛出的异常 
 * (自定义此异常可方便开发者在做全局异常处理时分辨异常类型)
 * 
 * @author kong
 *
 */
public class TokenException extends RuntimeException {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 6806129545290130132L;

	/**
	 * 构建一个异常
	 * 
	 * @param message 异常描述信息
	 */
	public TokenException(String message) {
		super(message);
	}

	/**
	 * 构建一个异常
	 * 
	 * @param cause 异常对象
	 */
	public TokenException(Throwable cause) {
		super(cause);
	}

	/**
	 * 构建一个异常
	 * 
	 * @param message 异常信息
	 * @param cause 异常对象
	 */
	public TokenException(String message, Throwable cause) {
		super(message, cause);
	}

}
