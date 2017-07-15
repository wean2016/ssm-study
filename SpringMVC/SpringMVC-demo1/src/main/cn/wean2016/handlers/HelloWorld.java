package main.cn.wean2016.handlers;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hasee on 2017/7/15.
 */
@Controller
public class HelloWorld {
    /**
     * 1. 使用 @RequestMapping 注解来映射请求的 URL
     * 2. 返回值会通过解析器解析为实际的物理视图，对于 InternalResourceViewResoler 视图解析器，会有如下的解析：
     *      通过 prefix + returnVal + suffix 这样的方式得到实际的物理视图，然后做转发操作
     *      /WEB-INF/views/success.jsp
     * @return
     */
    @RequestMapping("/helloworld")
    public String hello(){
        System.out.println("Hello World");
        return "success";
    }
}
