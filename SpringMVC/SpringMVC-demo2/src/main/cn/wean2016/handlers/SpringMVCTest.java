package main.cn.wean2016.handlers;

import main.cn.wean2016.entitis.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by hasee on 2017/7/16.
 */
@RequestMapping(value = "/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";

    /**
     * @RequestParam 映射请求参数
     * value 请求参数的参数名
     * required 该参数是否必须，默认是 true
     * defaultValue 该参数的默认值
     * @return
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String username, @RequestParam(value = "age", required = false, defaultValue = "0") Integer age){
        System.out.println("username: " + username + "   age:  " + age);
        return SUCCESS;
    }

    /**
     * 使用 @RequestHeader 接收头参数，用法同 @RequestParam
     * @param al
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al){
        System.out.println("testRequestHeader, Accept-Language:  " + al);
        return SUCCESS;
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookieValue){
        System.out.println("testCookieValue    " + cookieValue);
        return SUCCESS;
    }

    @RequestMapping("/testPojo")
    public String testPojo(User user){
        System.out.println(user);
        return SUCCESS;
    }

    /**
     * 可以使用 Servlet 原生的 API 作为目标的方法参数
     * 具体支持以下类型
     * HttpServletRequest
     • HttpServletResponse
     • HttpSession
     • java.security.Principal
     • Locale
     • InputStream
     • OutputStream
     • Reader
     • Writer
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
        System.out.println("reqeust:  " + request + "  response:  " + response);
        out.write("hahahahah");
//        return SUCCESS;
    }
}
