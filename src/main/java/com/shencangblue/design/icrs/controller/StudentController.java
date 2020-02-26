package com.shencangblue.design.icrs.controller;

import com.shencangblue.design.icrs.model.Student;
import com.shencangblue.design.icrs.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class StudentController {

    @CrossOrigin
    @PostMapping(value = "api/stu")
    @ResponseBody
    public Result login(@RequestBody Student requestStudent){
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestStudent.getStudentIdName();
        username = HtmlUtils.htmlEscape(username);

        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestStudent.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            return new Result(200);
        }
    }


}
