package com.codegym.controller;

import com.codegym.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneController {

    @GetMapping("/")
    public ModelAndView showForm(){
        return new ModelAndView("index","phonenumber",new PhoneNumber());
    }

    @PostMapping("/")
    public ModelAndView checkValidation(@Valid @ModelAttribute("phonenumber")PhoneNumber phoneNumber, BindingResult bindingResult){
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("index");
        }else {
            return new ModelAndView("result","phonenumber",phoneNumber.getNumber());
        }
    }
}
