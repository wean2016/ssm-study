package main.cn.wean2016.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hasee on 2017/7/15.
 */
@Controller
@RequestMapping("/springmvc")
public class SpringMVCTest {

    private static final String SUCCESS = "success";



    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("testRequestMapping");
        return SUCCESS;
    }


    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return SUCCESS;
    }

    @RequestMapping(value = "testParamsAndHeaders", params = {"username", "age!=10"})
    public String testParamsAndHeaders(){
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    @RequestMapping(value = "/testAntPath/*/abc")
    public String testAntPath(){
        System.out.println("testAntPath");
        return SUCCESS;
    }

    /**
     * @PathVariable 可以映射 URL 中的占位符到目标方法的参数中
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("testPathVariable:   " + id);

        return SUCCESS;
    }

    /**
     * Rest 风格的 URL
     * 以 CRUD 为例：
     * 新增： /order POST
     * 修改： /order/1 PUT
     * 获取： /order/1 GET
     * 删除： /order/1 DELETE
     *
     * 如何发送 PUT 和 DELETE 请求
     * 1. 需要配置 HiddenHttpMethodFilter
     * 2. 需要发送 POST 请求
     * 3. 需要发送 POST 请求时携带一个 name="_method" 的隐藏域， 值为 DELETE 或 PUT
     *
     * 在 SpringMVC 的目标方法中如何得到 id 呢？
     * 使用 @PathVariable 注解
     * @return
     */
    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testRest(){
        System.out.println("testRest POST");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRest(@PathVariable Integer id){
        System.out.println("testRest GET :   " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id){
        System.out.println("testRest Delete :   " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id){
        System.out.println("testRest Put :   " + id);
        return SUCCESS;
    }

}
