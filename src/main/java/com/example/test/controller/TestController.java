package com.example.test.controller;

import com.example.test.base64.Base64Method;
import com.example.test.dao.TestRepository;
import com.example.test.model.TestBean;
import com.example.test.rowmapper.TestRowMapper;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class TestController {

    Base64Method base64Method = new Base64Method();
//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    @GetMapping("/search")
//    public String showAllMsg(Model model){
//
//        String sql = "select idx, c_aes256, c_base64 from table1";
//
//        Map<String , Object> map = new HashMap<>();
//        List<TestBean> list = namedParameterJdbcTemplate.query(sql, map, new TestRowMapper());
//        System.out.println(list.get(0));
//
//        model.addAttribute("list", list);
//        return "search";
//    }

    @Autowired
    private TestRepository repository;

    public Base64Method getBase64Method() {
        return base64Method;
    }

    @GetMapping("/search")
    public String showByAll(Model model){
        List<TestBean> testBeanList = repository.findAll();
        model.addAttribute("testBeanList",testBeanList);
        return "search";
    }

    @GetMapping("/home")
    public String homePage(){
        return "index";
    }

    @GetMapping("/insert")
    public String insert(){
        return "insert";
    }

    @PostMapping("/test/insert")
    public String insertTest(@RequestParam("key") String key
                            ,@RequestParam("value") String value
                            ,Model model){

        TestBean testBean = new TestBean();
        byte[] bytes1 = key.getBytes();
        byte[] bytes2 = value.getBytes();

        testBean.setcBase64(base64Method.encoder(bytes1));
        testBean.setcBase64(base64Method.encoder(bytes2));
        repository.save(testBean);
        List<TestBean> testBeans = repository.findAll();
        model.addAttribute("testBeans",testBeans);
        return "index";
    }
}
