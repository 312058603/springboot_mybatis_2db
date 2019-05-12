package com.wpx.service;

import java.util.List;
import java.util.Map;

public interface IStudentService {

    List<Map<String,Object>> selectAllStudent();

    Integer insertStudent(Map<String,Object> student);

    Integer deleteStudentById(Map<String,Object> studentId);

    Integer deleteStudentByIds(Map<String,Object> studentIds);

    Integer updateStudentById(Map<String,Object> student);

    List<Map<String, Object>> selectStudentByPageIndex(Map<String,Object> pargrams);

    Integer selectStudentCount();

}
