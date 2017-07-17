package main.cn.wean2016.handlers;

import main.cn.wean2016.entitis.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Created by hasee on 2017/7/16.
 */
@RequestMapping(value = "/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";

    @RequestMapping("/testViewAndViewResolver")
    public String testViewAndViewResolver(){
        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }

    @RequestMapping("/testView")
    public String testView(){
        System.out.println("testView");
        return "helloView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect");
        return "redirect:index.jsp";
    }
    @RequestMapping("/testForward")
    public String testForward(){
        System.out.println("testForward");
        return "forward:testView";
    }
}
