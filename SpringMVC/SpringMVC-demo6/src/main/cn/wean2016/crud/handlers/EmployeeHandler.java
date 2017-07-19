package main.cn.wean2016.crud.handlers;

import main.cn.wean2016.crud.dao.DepartmentDao;
import main.cn.wean2016.crud.dao.EmployeeDao;
import main.cn.wean2016.crud.entitis.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * Created by hasee on 2017/7/17.
 */
@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    // 文件上传
    @RequestMapping("/testFileUpload")
    private String testFileUpload(@RequestParam("desc") String desc,
                                  @RequestParam("file")MultipartFile file) throws IOException {
        System.out.println("desc:   " + desc);
        System.out.println("OriginalFilename:   "+ file.getOriginalFilename());
        System.out.println("InputStream:   " + file.getInputStream());

        return "success";
    }

    // 下载
    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("/files/pom.xml");
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=pom.xml");

        HttpStatus status = HttpStatus.OK;

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body,headers,status);

        return responseEntity;
    }


    // 获得文件
    @ResponseBody
    @RequestMapping("testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body){
        System.out.println(body);
        return "hello world" + new Date();
    }



    // 输出 JSON
    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson(){
        return employeeDao.getAll();
    }

    @ModelAttribute
    public void getEmployee(@RequestParam(value="id",required=false) Integer id,
                            Map<String, Object> map){
        if(id != null){
            map.put("employee", employeeDao.get(id));
        }
    }

    @RequestMapping(value="/emp", method=RequestMethod.PUT)
    public String update(Employee employee){
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id, Map<String, Object> map, BindingResult bindingResult){

        if (bindingResult.getErrorCount() > 0){
            System.out.println("出错了");
            for (FieldError error : bindingResult.getFieldErrors()){
                System.out.println(error.getField() + "    " + error.getDefaultMessage());
            }
        }

        System.out.println("get\n");
        map.put("employee", employeeDao.get(id));
        map.put("departments", departmentDao.getDepartments());
        return "input";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        System.out.println("delete\n");
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(@Valid Employee employee){
        System.out.println("post\n");
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String input(Map<String, Object> map){

        map.put("departments", departmentDao.getDepartments());
        map.put("employee", new Employee());
        return "input";
    }

    @RequestMapping("/emps")
    public String list(Map<String, Object> map) {

        map.put("employees", employeeDao.getAll());

        return "list";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("lastName");
    }
}
