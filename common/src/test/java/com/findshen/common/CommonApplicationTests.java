package com.findshen.common;

import com.findshen.modules.bz.entity.StudentEntity;
import com.findshen.modules.bz.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonApplicationTests {


    @Autowired
    private StudentService studentService;

    @Test
    public void contextLoads() {
        StudentEntity entity=new StudentEntity();
        entity.setAge(1);
        entity.setStudentName("123213");
        studentService.save(entity);
    }

}
