package com.zaurtregulov.spring.mvc_hibernate_aop.controller;

import com.zaurtregulov.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Employee;
import com.zaurtregulov.spring.mvc_hibernate_aop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MyController {

    private EmployeeService empService;

    public MyController(EmployeeService empService) {
        this.empService = empService;
    }

    @RequestMapping("/hello")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = empService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";

    }

    @GetMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("emp", employee);
        return "employee-info";
    }

    @PostMapping("/saveEmp")
    public String saveEmployee(@ModelAttribute("emp") Employee e) {
        empService.saveEmployee(e);
        return "redirect:/hello";//передаем ссылку на маппинг метода
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee e = empService.getEmployeeById(id);
        model.addAttribute("emp",e);//атрибут называем так же, как и в методе addNewEmployee
        // т.к. возвращаем то же самое представление
        return "employee-info";
    }
    @RequestMapping("/deleteEmp")
    public String deleteEmployee(@RequestParam("empId") int id, Model model){
        empService.removeEmp(id);
        List<Employee> allEmployees = empService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

}
