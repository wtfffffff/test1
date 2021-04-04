package org.example;

import static org.junit.Assert.assertTrue;

import com.github.pagehelper.PageHelper;
import dao.StudentDao;
import doMain.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MyBatisUtils;
import vo.QueryParam;
import vo.ViewStudent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1001);
        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMulitParam("zs", 20);
        sqlSession.close();
    }
    @Test
    public void test3(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam queryParam = new QueryParam();
        queryParam.setParamAge(10);
        queryParam.setParamName("zs");
        List<Student> students = dao.selectMultiObject(queryParam);
        sqlSession.close();
    }
    @Test
    public void test4(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiPosition("ls",20);
        sqlSession.close();
    }
    @Test
    public void test5(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<String,Object> data=new HashMap<>();
        data.put("myname","zs");
        data.put("age",20);
        List<Student> students = dao.selectMultiByMap(data);
        sqlSession.close();
    }
    @Test
    public void test6(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        ViewStudent viewStudent = dao.selectStudenyReturnViewStudent(1001);
        System.out.println("\n\n"+viewStudent+"\n\n");
        sqlSession.close();
    }
    @Test
    public void test7(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int i = dao.countStudent();
        System.out.println("\n\n"+i+"\n\n");
        sqlSession.close();
    }
    @Test
    public void test8(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> objectObjectMap = dao.selectMapById(1001);
        System.out.println("\n\n"+objectObjectMap+"\n\n");
        sqlSession.close();
    }
    @Test
    public void test9(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllStudent();
        System.out.println("\n\n"+students+"\n\n");
        sqlSession.close();
    }
    @Test
    public void test10(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String n="%zs%";
        List<Student> students = dao.selectLikeOne(n);
        System.out.println("\n\n"+students+"\n\n");
        sqlSession.close();
    }
    @Test
    public void test11(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectLikeTwo("zs");
        System.out.println("\n\n"+students+"\n\n");
        sqlSession.close();
    }
    @Test
    public void test12(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("zs");
        student.setAge(20);
        List<Student> students = dao.selectStudentIf(student);
        System.out.println("\n\n"+students+"\n\n");
        sqlSession.close();
    }
    @Test
    public void test13(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("zs");
        student.setAge(20);
        List<Student> students = dao.selectStudentwhere(student);
        System.out.println("\n\n"+students+"\n\n");
        sqlSession.close();
    }
    @Test
    public void test14(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list=new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students = dao.selectForeachOne(list);
        System.out.println("\n\n"+students+"\n\n");
        sqlSession.close();
    }
    @Test
    public void test15(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> stulist=new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1001);
        Student s2 = new Student();
        s2.setId(1002);
        Student s3 = new Student();
        s3.setId(1003);
        stulist.add(s1);
        stulist.add(s2);
        stulist.add(s3);
        List<Student> students = dao.selectForeachTwo(stulist);
        System.out.println("\n\n"+students+"\n\n");
        sqlSession.close();
    }
    @Test
    public void test16(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        PageHelper.startPage(3,3);
        List<Student> students = dao.selectAll();
        System.out.println("\n\n"+students+"\n\n");
        sqlSession.close();
    }
}
