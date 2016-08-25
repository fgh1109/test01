import com.wowoohr.api.saas.dto.EmployeeDto;
import com.wowoohr.api.saas.dto.EmployeeSearchDto;
import com.wowoohr.api.saas.dto.common.Page;
import com.wowoohr.biz.saas.service.EmployeeService;
import com.wowoohr.biz.saas.service.impl.EmployeeServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2016/8/14.
 */
@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations = "classpath:META-INF/spring/spring-config.xml") // 加载配置
@Transactional
public class Test01 {
    @Autowired
    private EmployeeService employeeService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void fun(){
        EmployeeSearchDto employeeSearchDto=new EmployeeSearchDto();
        employeeSearchDto.setEmployeeID(123);
        //EmployeeFacadeImpl employeeFacade=new EmployeeFacadeImpl();
     //      EmployeeServiceImpl employeeService=new EmployeeServiceImpl();
        Page<EmployeeDto> page1= employeeService.getEmployeeList(employeeSearchDto,1,10);

        Assert.assertNotNull(page1.getResult());
        List<EmployeeDto> dtoList1=page1.getResult();
        System.out.println("len = "+dtoList1.size());
        System.out.println("hel");
        dtoList1 = page1.getResult();
        for (EmployeeDto dto : dtoList1){
            System.out.print(dto.getCompanyFullName());
        }
    }
}
