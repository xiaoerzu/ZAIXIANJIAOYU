package com.jk.mapper;

import com.jk.model.SysUser;
import com.jk.model.Tree;
import com.jk.model.UserEntity;
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

    @Select("select * from  t_user")
    List<UserEntity> userList();


    @Select("select * from t_user where userid = #{value}")
    UserEntity toUserEdit(Integer userid);

    @Update("UPDATE t_user SET username=#{username},userpassword=#{userpassword} " +
            "WHERE userid = #{userid}")
    void editUserBean(UserEntity user);

    @Insert("INSERT INTO t_user (username,userpassword,userimage)" +
            "VALUES(#{username},#{userpassword},#{userimage})")
    @SelectKey( statement = "select last_insert_id()", keyProperty = "userid", before = false, resultType = Integer.class)
    void addUserBean(UserEntity user);

    @Delete("delete from t_user where userid = #{userid}")
    void delete(Integer userid);

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
