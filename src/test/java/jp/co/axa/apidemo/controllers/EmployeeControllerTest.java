package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.ApiDemoApplication;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.slf4j.Logger;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class)
public class EmployeeControllerTest {

    private static Logger logger = LoggerFactory.getLogger(EmployeeControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;
    //private ConfigurableApplicationContext context;
    // TODO springSecurity   Because security authentication requires login

//    @Before
//    public void Set(){
//        context = SpringApplication.run(ApiDemoApplication.class);
//    }

//    @After
//    public void tearDown() {
//        // close SpringBoot
//        context.close();
//    }

    @Test
    public void getEmployees() throws Exception{
        Employee employee = new Employee();
        employee.setId(1l);
        employee.setDepartment("HR");
        employee.setName("ton");
        employee.setSalary(1500);

        Mockito.when(employeeService.getEmployee(1l)).thenReturn(employee);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/employees/1");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"ton\",\n" +
                "  \"salary\": 1500,\n" +
                "  \"department\": \"HR\"\n" +
                "}";
        logger.info(result.getResponse().getContentAsString());
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }



//    @Test
//    public void getEmployees() throws Exception {
//        mockMvc.perform(get("/api/v1/employees"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }

    @Test
    public void getEmployee() throws Exception {
        mockMvc.perform(get("/api/v1/employees")
                .param("employeeId", String.valueOf(1)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void saveEmployee() throws Exception {
        mockMvc.perform(post("/api/v1/employees"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteEmployee() throws Exception {
        mockMvc.perform(delete("/api/v1/employees")
                .param("employeeId", String.valueOf(1)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateEmployee() throws Exception {
        mockMvc.perform(put("/api/v1/employees")
                .param("employeeId", String.valueOf(1)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}