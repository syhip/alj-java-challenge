package jp.co.axa.apidemo.common;

/**
 * Constant Class
 */
public final class Const {
    private Const() {
    }

    public static final String LOG_POINTCUT_DIRECTORY = "execution(public * jp.co.axa.apidemo.controllers.EmployeeController.*(..))";
    public static final String LOG = "log()";
    public static final String START = "Start";
    public static final String END = "end";
    public static final String URL = "url={}";
    public static final String METHOD = "method={}";
    public static final String IP = "ip={}";
    public static final String CLASS_METHOD = "class_method={}";
    public static final String ARGS = "args={}";
    public static final String OBJECT = "object";
    public static final String RESPONSE = "response={}";
    public static final String H2_CONSOLE = "/h2-console/**";
    public static final String EMPLOYEEID = "employeeId";
    public static final String EMPLOYEE = "EMPLOYEE";
    public static final String EMPLOYEE_NAME = "EMPLOYEE_NAME";
    public static final String EMPLOYEE_SALARY = "EMPLOYEE_SALARY";
    public static final String SALARY_LESS_THAN_100 = "Salary less than 100";
    public static final String SALARY_IS_NOT_NULL = "Salary is not null";
    public static final String DEPARTMENT = "DEPARTMENT";
    public static final String SYSTEM_ERROR = "System Error";
    public static final String SYSTEM_ERROR_E = "【System Error】{}";
    public static final String SUCCESS = "Success";
    public static final String THE_DATA_DOES_NOT_EXIST = "The data does not exist";
    public static final String EMPLOYEECACHE = "employeeCache";
    public static final String ECACHE_KEY = "#p0";



}
