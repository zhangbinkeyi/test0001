package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService service;

    // 注册学生
    @RequestMapping(value = "/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv = new ModelAndView();
        String tips="注册失败";
        // 调用service处理student
        int nums = service.addStudent(student);
        if(nums > 0){
            // 注册成功
            tips="学生（" + student.getName() + ")注册成功";
        }
        // 添加数据
        mv.addObject("tips",tips);
        // 指定结果页面
        mv.setViewName("result");
        return mv;
    }
}
