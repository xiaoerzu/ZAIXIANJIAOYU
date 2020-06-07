package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HelloMapper {


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
            "courseimg=#{courseimg},authername=#{authername},courseprice=#{courseprice}, " +
            "coursecontext=#{coursecontext}  WHERE courseid =#{courseid}")
    void editKeChengBean(CourseEntity course);

    @Select("select * from sys_user")
    List<SysUser> inityongHuTable();

    @Select("select * from sys_role")
    List<Role> initjueseTable();

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

    /*@Select("select * from t_tree where pid = #{id}")
    List<Tree> selectTree(Integer id);

    @Select("<script>SELECT t1.id,mecname,t3.name as meclevelname,t2.AREANAME as provincename,peopled,t1.name,status from t_info t1,t_area t2,t_level t3 where t1.provinceid = t2.AREAID and t1.meclevel = t3.id <if test='mecname != null and mecname.length >0'> and LOWER(mecname) like concat('%',#{mecname},'%')</if> limit #{page},#{rows} </script>")
    List<Information> selectList(Integer page, Integer rows,String mecname);

    @Delete("delete from t_info where id= #{id}")
    void deleteInfo(Integer id);

    @Select("<script> select count(1) from t_info where 1=1 <if test='mecname != null and mecname.length >0'> and LOWER(mecname) like concat('%',#{mecname},'%')</if></script>")
    Long selectTotal(String mecname);

    @Select("select * from t_info where id = #{id}")
    Information updateInfoById(Integer id);

    @Select("select t1.goods_id as goodsId,t1.goods_name as goodsName,t1.goods_img as goodsImg,t1.goods_price as goodsPrice\n" +
            ",t2.brand_name as brandName,t1.goods_property as goodsProperty,t1.goods_num as goodsNum, t1.`status`\n" +
            "\n" +
            " from t_goods t1,t_brand t2 where t1.goods_brand = t2.brand_id limit #{page},#{rows}")
    List<Goods> selectGoodsList(Integer page, Integer rows);

    @Select("select count(1) from t_goods where 1=1")
    Long selectGoodsTotal();*/
}
