package main.cn.wean2016.converters;

import main.cn.wean2016.crud.dao.DepartmentDao;
import main.cn.wean2016.crud.entitis.Department;
import main.cn.wean2016.crud.entitis.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by hasee on 2017/7/18.
 */
@Component
public class EmployeeConverter implements Converter<String, Employee> {

    @Autowired
    private DepartmentDao departmentDao;

    public Employee convert(String s) {
        if (s != null) {
            String[] vals = s.split("-");
            // GG-gg@wean2016.cn-0-105
            if (vals != null && vals.length == 4) {
                String lastname = vals[0];
                String email = vals[1];
                Integer gender = Integer.parseInt(vals[2]);
                Department department = departmentDao.getDepartment(Integer.parseInt(vals[3]));
                Employee employee = new Employee(null, lastname, email, gender, department);
                System.out.println(s + "--convert--" + employee);
                return employee;
            }
        }
        return null;
    }
}
