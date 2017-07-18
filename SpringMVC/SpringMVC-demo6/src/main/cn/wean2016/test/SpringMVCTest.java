package main.cn.wean2016.test;

import main.cn.wean2016.crud.dao.EmployeeDao;
import main.cn.wean2016.crud.entitis.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hasee on 2017/7/18.
 */
@Controller
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/testConversionServiceConverer")
    public String testConverter(@RequestParam Employee employee){
        System.out.println("save :  " + employee);
        employeeDao.save(employee);
        return "redirect:emps";
    }

}
