package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.common.Const;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.entities.Result;
import jp.co.axa.apidemo.enums.ResultEnum;
import jp.co.axa.apidemo.exception.UserException;
import jp.co.axa.apidemo.services.EmployeeService;
import jp.co.axa.apidemo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeService.retrieveEmployees();
        return employees;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable(name = Const.EMPLOYEEID) Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/employees")
    public Object saveEmployee(@Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(employeeService.saveEmployee(employee),ResultEnum.SUCCESS);
    }

    @DeleteMapping("/employees/{employeeId}")
    public Result deleteEmployee(@PathVariable(name = Const.EMPLOYEEID) Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResultUtil.success(ResultEnum.SUCCESS);
    }

    @PutMapping("/employees/{employeeId}")
    public Result updateEmployee(@Valid@RequestBody Employee employee,
                                 @PathVariable(name = Const.EMPLOYEEID) Long employeeId, BindingResult bindingResult) {
        // TODO MethodArgumentNotValidException
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }

        Employee emp = employeeService.getEmployee(employeeId);

        if (null == emp) {
            throw new UserException(ResultEnum.DATA_ERROR);
        }
        emp.setDepartment(employee.getDepartment());
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        return ResultUtil.success(employeeService.updateEmployee(emp),ResultEnum.SUCCESS);
    }
}
