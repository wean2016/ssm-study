package main.cn.wean2016.test;

import main.cn.wean2016.crud.dao.EmployeeDao;
import main.cn.wean2016.crud.entitis.Employee;
import main.cn.wean2016.exception.UserNameNotMatchPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hasee on 2017/7/18.
 */
@Controller
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;


    @ResponseStatus(reason="测试",value= HttpStatus.NOT_FOUND)
    @RequestMapping("/testResponseStatusExceptionResolver")
    public String testResponseStatusExceptionResolver(@RequestParam("i") int i) {
        if (i == 13) throw new UserNameNotMatchPasswordException();
        return "success";
    }

    @RequestMapping("/testConversionServiceConverer")
    public String testConverter(@RequestParam Employee employee){
        System.out.println("save :  " + employee);
        employeeDao.save(employee);
        return "redirect:emps";
    }

}
