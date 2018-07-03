package com.codegym.basic.controller;

import com.codegym.basic.model.Employee;
import com.codegym.basic.model.GroupEmployee;
import com.codegym.basic.service.EmployeeService;
import com.codegym.basic.service.GroupEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private GroupEmployeeService groupEmployeeService;
    private EmployeeService employeeService;

    public EmployeeController(GroupEmployeeService groupEmployeeService, EmployeeService employeeService){
        this.employeeService = employeeService;
        this.groupEmployeeService = groupEmployeeService;
    }
    @ModelAttribute("groupEmployees")
    public Iterable<GroupEmployee> groupEmployees (){
        return groupEmployeeService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateEmployee(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createEmployee(@ModelAttribute("employee") Employee employee){
        GroupEmployee groupEmployee = new GroupEmployee();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/employee/create");
        employeeService.save(employee);

        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("groupEmployee", groupEmployee);
        modelAndView.addObject("message","create employee successfully");
        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView getAllEmployee(){
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Employee> employees = employeeService.findAll();
        modelAndView.setViewName("/employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView();
        Employee employee = employeeService.findById(id);
        if(employee!= null){
            modelAndView.setViewName("/employee/edit");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        }else {
         modelAndView.setViewName("/error-404");
         return modelAndView;
        }
    }

    @PostMapping("/{id}/edit")
    public ModelAndView editEmployee(@ModelAttribute("employee") Employee employee){
        ModelAndView modelAndView = new ModelAndView();
        employeeService.save(employee);
        modelAndView.setViewName("/employee/edit");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("message", "update successfully");
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showFormDeleteEmploy(@PathVariable("id") Long id){

        ModelAndView modelAndView = new ModelAndView();
        Employee employee = employeeService.findById(id);
        if(employee != null){
            modelAndView.setViewName("/employee/delete");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        }else {
            modelAndView.setViewName("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/{id}/delete")
    public String deletePlayer(@PathVariable("id")Long id){
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
