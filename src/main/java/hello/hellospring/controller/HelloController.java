package hello.hellospring.controller;

import hello.hellospring.person.PersonTest;
import jdk.jfr.Frequency;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model ){
        model.addAttribute("data","hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name" , required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    // 리스폰스 바디안에 return 값을 넣는다는 의미
    // return 값 자체를 내려준다.
    @ResponseBody
    // required = false ( 기본이 true인데 false일 경우 받을수도 안받을수도있다는 뜻)
    public String helloString(@RequestParam(value = "name" , required = false) String name){
        return "hell0 " + name ;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi (@RequestParam("name") String name ) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name ;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }




}
