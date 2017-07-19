package main.cn.wean2016.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hasee on 2017/7/19.
 */

@ResponseStatus(reason = "用户名和密码不匹配", value = HttpStatus.NOT_FOUND)
public class UserNameNotMatchPasswordException extends RuntimeException {
}
