package com.balancika.hrms.app.uploadtest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
	
	@RequestMapping(value = "/test1")
    public String Test1(Model model) {
        return "productForm";
    }
	
	@RequestMapping(value = "/test2")
    public String Test2(Model model) {
        return "uploadfile";
    }
	

}


