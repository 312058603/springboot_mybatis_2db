package com.wpx.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
@Transactional
public class StudentService implements IStudentService {

    @Resource
    private com.wpx.dao.test1.StudentDao studentDao1;

    @Resource
    private com.wpx.dao.test2.StudentDao studentDao2;

    @Override
    public List<Map<String, Object>> selectAllStudent() {
        return studentDao1.selectAllStudent();
    }

    @Override
    public Integer insertStudent(Map<String, Object> student) {
        int count1 = studentDao1.insertStudent(student);
        return count1;
    }

    /**
     * 测试Transactional事务执行成功
     */
    @Override
    public Integer deleteStudentById(Map<String, Object> studentId) {
        int count1 = studentDao1.deleteStudentById(studentId);
        log.info("count1="+count1);
        int a = 1 / 0;
        int count2 = studentDao2.deleteStudentById(studentId);
        return count1 + count2;
    }

    @Override
    public Integer deleteStudentByIds(Map<String, Object> studentIds) {
        return studentDao1.deleteStudentByIds(studentIds);
    }

    @Override
    public Integer updateStudentById(Map<String, Object> student) {
        return studentDao1.updateStudentById(student);
    }

    @Override
    public List<Map<String, Object>> selectStudentByPageIndex(Map<String, Object> pargrams) {
        return studentDao1.selectStudentByPageIndex(pargrams);
    }

    @Override
    public Integer selectStudentCount() {
        return studentDao1.selectStudentCount();
    }

}
