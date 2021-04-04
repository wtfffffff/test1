package dao;

import doMain.Student;
import org.apache.ibatis.annotations.Param;
import vo.QueryParam;
import vo.ViewStudent;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    Student selectStudentById(Integer i);
    List<Student> selectMulitParam(@Param("myname") String name,@Param("myage") Integer age);
    List<Student> selectMultiObject(QueryParam param);
    List<Student> selectMultiPosition(String name,Integer age);
    List<Student> selectMultiByMap(Map<String,Object> map);
    ViewStudent selectStudenyReturnViewStudent(@Param("sid") Integer id);
    int countStudent();
    Map<Object,Object> selectMapById(Integer id);
    List<Student> selectAllStudent();
    List<Student> selectLikeOne(String name);
    List<Student> selectLikeTwo(String name);
    List<Student> selectStudentIf(Student student);
    List<Student> selectStudentwhere(Student student);
    List<Student> selectForeachOne(List<Integer> idlist);
    List<Student> selectForeachTwo(List<Student> stulist);
    List<Student> selectAll();
}
