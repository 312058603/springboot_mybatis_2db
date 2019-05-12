package com.wpx.dao.test1;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by GM-KF007 on 2018/12/24.
 */
@Repository("studentDao1")
public interface StudentDao {

    List<Map<String, Object>> selectAllStudent();

    Integer insertStudent(Map<String, Object> student);

    Integer deleteStudentById(Map<String, Object> studentId);

    Integer deleteStudentByIds(Map<String, Object> studentIds);

    Integer updateStudentById(Map<String, Object> student);

    List<Map<String, Object>> selectStudentByPageIndex(Map<String, Object> pargrams);

    Integer selectStudentCount();

}
