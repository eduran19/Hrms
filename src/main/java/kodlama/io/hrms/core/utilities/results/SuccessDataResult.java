package  kodlama.io.hrms.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {
	public SuccessDataResult(T data,String message) {
		super(true, message, data);
		// TODO Auto-generated constructor stub
	}
	public SuccessDataResult(T data) {
		super(true, data);
		// TODO Auto-generated constructor stub
	}
}
