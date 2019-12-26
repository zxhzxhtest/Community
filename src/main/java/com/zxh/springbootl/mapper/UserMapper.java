package com.zxh.springbootl.mapper;


import com.zxh.springbootl.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

//    @Select("select * from user where id=#{id}")



    @Insert("insert into User (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insertUser(User user);

}
