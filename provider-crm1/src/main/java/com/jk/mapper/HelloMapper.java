package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HelloMapper {

<<<<<<< HEAD
=======

>>>>>>> origin/master
    @Select("select sp.percode \n" +
            "from sys_user_role sur,\n" +
            "sys_role_permission srp,\n" +
            "sys_permission sp \n" +
            "where sur.sys_user_id=#{userId} and sur.sys_role_id=srp.sys_role_id \n" +
            "and srp.sys_permission_id=sp.id and sp.percode IS NOT NULL and sp.percode <> '' ")
    List<String> selectPerCodeList(Integer userId);


    @Select("select * from sys_user where usercode = #{userName}")
    SysUser selectUserByCode(String userName);


    @Select("select sp.id,sp.name as text, sp.url as href, sp.parentid as pid \n" +
            "from sys_user_role sur,\n" +
            "sys_role_permission srp,\n" +
            "sys_permission sp \n" +
            "where sur.sys_user_id=#{userId} and sur.sys_role_id=srp.sys_role_id \n" +
            "and srp.sys_permission_id=sp.id\n" +
            "and sp.parentid=#{id} and sp.type='menu'")
    List<Tree> queryTreeList(Integer id,Integer userId);


    @Select("<script> " +
            "SELECT * FROM `1908_course`" +
            " WHERE 1=1 " +
            "<if test='coursetitle != null and coursetitle.length > 0'> " +
            "and coursetitle like concat('%',#{coursetitle},'%') " +
            "</if>"  +
            "</script>")
    List<CourseEntity> initKeChengTable(CourseEntity course);

    @Delete("delete from 1908_course where courseid = #{id}")
    void deleteCourse(Integer id);

    @Select("select * from 1908_course where courseid = #{id}")
    CourseEntity compileById(Integer id);

    @Insert("INSERT INTO 1908_course " +
            "(coursetitle,coursetype,coursenumber,courseimg,authername,autherimg,courseprice,coursecontext) " +
            "VALUES (#{coursetitle},#{coursetype},0,#{courseimg}," +
            "#{authername},#{autherimg},#{courseprice},#{coursecontext})")
    @SelectKey( statement = "select last_insert_id()", keyProperty = "courseid", before = false, resultType = Integer.class)
    void addKeCheng(CourseEntity course);

    @Update("UPDATE 1908_course SET coursetitle=#{coursetitle},coursetype=#{coursetype}, " +
<<<<<<< HEAD
            "authername=#{authername},courseprice=#{courseprice}, " +
=======
            "courseimg=#{courseimg},authername=#{authername},courseprice=#{courseprice}, " +
>>>>>>> origin/master
            "coursecontext=#{coursecontext}  WHERE courseid =#{courseid}")
    void editKeChengBean(CourseEntity course);

    @Select("select * from sys_user")
    List<SysUser> inityongHuTable();

    @Select("select * from sys_role")
    List<Role> initjueseTable();

<<<<<<< HEAD



    @Select("SELECT SUM(advertising) advertising,\n" +
            "SUM(user) user,SUM(sales_volume) sales_volume \n" +
            "FROM t_statement  WHERE YEAR(date_time) = YEAR(NOW())\n" +
            "GROUP BY MONTH(date_time)")
    List<StatementBean> MyChart3();

    @Select("SELECT SUM(advertising) advertising, \n" +
            "SUM(user) user,\n" +
            "SUM(sales_volume) sales_volume \n" +
            "FROM t_statement WHERE MONTH(date_time)=  MONTH(NOW())")
    StatementBean initMyChart2();

    @Select("SELECT sales_volume FROM t_statement \n" +
            "WHERE YEARWEEK(date_format(date_time,'%Y-%m-%d')) = YEARWEEK(now())")
    List<StatementBean> initMyChart1();

    @Select("SELECT * FROM t_slideshow ORDER BY sort")
    List<SlideshowBean> initSlideshowTable();

    @Delete("DELETE FROM t_slideshow WHERE id in (${id})")
    void pishan1(@Param("id") String id);

    @Insert("INSERT INTO t_slideshow \n" +
            "\t\t\t(state,sort,start_time,end_time,img_age,operation) \n" +
            "\t\t\t VALUES (#{state},#{sort},now()," +
            "NOW()-7000000,#{img_age},#{operation})")
    void addSlideshow(SlideshowBean slideshow);

    @Select("SELECT * FROM t_slideshow  WHERE id = #{value}")
    SlideshowBean findInfoById(Integer id);

    @Select("<script>SELECT orderid,ordernumber,orderdate,ordertitle,orderprice,t2.username as username,status FROM t_order t1,t_user t2 WHERE t1.userid = t2.userid <if test='ordernumber != null and ordernumber.length > 0'> and ordernumber like concat('%',#{ordernumber},'%') </if></script>")
    List<Order> initOrderTable(Order order);

    @Delete("delete from t_order where orderid = #{id}")
    void deleteOrder(Integer id);

    @Select("SELECT * FROM `t_section`")
    List<SectionBean> initMuLuTable();

    @Delete("delete from t_section where id = #{id}")
    void deleteSection(Integer id);

    @Insert("insert into sys_user_role (sys_user_id,sys_role_id) values (#{userId},#{roleId})")
    void addJueSe(Integer roleId, Integer userId);

    @Select("select sys_user_id as sysuserid,sys_role_id as sysroleid from  sys_user_role where sys_user_id = #{userid}")
    List<UserRole> queryUserRole(Integer userid);

    @Delete("delete from sys_user_role where sys_user_id = #{userId}")
    void deleteJuese(Integer userId);

    @Select("select * from sys_role")
    List<Role> initJueSeTable();
=======
    @Insert("insert into sys_user_role (sys_user_id,sys_role_id) values (#{userId},#{roleId})")
    void addJueSe(Integer roleId, Integer userId);

    @Select("select sys_user_id as sysuserid,sys_role_id as sysroleid from  sys_user_role where sys_user_id = #{userid}")
    List<UserRole> queryUserRole(Integer userid);

    @Delete("delete from sys_user_role where sys_user_id = #{userId}")
    void deleteJuese(Integer userId);

    @Select("select * from sys_role")
    List<Role> initJueSeTable();

    @Select("select sys_permission_id as syspermissionid from sys_role_permission where sys_role_id = #{roleId}")
    List<Integer> queryTreeByRoleId(Integer roleId);

    @Select("select sp.id as id,sp.name as text, sp.url as href, sp.parentid as pid from sys_permission sp where parentid = #{pid}")
    List<Tree> queryAllTree(Integer pid);
>>>>>>> origin/master

    @Select("select sys_permission_id as syspermissionid from sys_role_permission where sys_role_id = #{roleId}")
    List<Integer> queryTreeByRoleId(Integer roleId);

    @Select("select sp.id as id,sp.name as text, sp.url as href, sp.parentid as pid from sys_permission sp where parentid = #{pid}")
    List<Tree> queryAllTree(Integer pid);

    @Insert("insert into sys_role (name) values (#{name})")
    void addJueSeList(Role role);

    @Delete("delete from sys_role where id = #{id}")
    void deleteRole(Integer id);

    @Insert("insert into sys_role_permission (sys_role_id ,sys_permission_id) values (#{roleId},#{permissionIds})")
    void addRolePer(Integer permissionIds, Integer roleId);

    @Delete("delete from sys_role_permission where sys_role_id = #{roleId}")
    void deleteRolePer(Integer roleId);

    @Insert("insert into t_section (sectionid ,sectionname,video,duration)" +
            " values (2,#{sectionname},#{video},50)")
    void addMuLu(SectionBean section);
}
