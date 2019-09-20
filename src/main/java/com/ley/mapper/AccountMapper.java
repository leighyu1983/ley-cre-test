package com.ley.mapper;

import com.ley.entity.AccountEntity;
import com.ley.mapper.langdriver.MyLangDriver;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Mapper
@Repository
public interface AccountMapper {
    @Insert("insert into account(id, name, address) values(#{id},#{name},#{address})")
    int insert(AccountEntity account);

    @Update({"update account set name=#{name}, address=#{address} where id=#{id}"})
    int update(AccountEntity account);

    // (#{pIds, jdbcType=INTEGER})
    @Select({
        "<script>",
        "select * ",
        "from account ",
        "WHERE 1=1 ",
        "<if test='pName != null and pName != \"\"' >AND name LIKE concat(#{pName}, '%')</if> ",
        "<if test='pIds != null and pIds.size > 0' >AND id IN ( " +
            "<foreach item='guard' index='index' collection='pIds' separator=',' close=''> " +
            "  #{guard, jdbcType=INTEGER}" +
            "</foreach> ",
        " ) </if> ",
        "</script>"
    })
    List<AccountEntity> queryLikeIn(@Param("pName") String name, @Param("pIds")Set<Integer> inId);

    @Select("select * from account where id in (#{pIds})")
    @Lang(MyLangDriver.class)
    List<AccountEntity> queryLikeInXml(@Param("pIds")Set<String> inId);

    @Select("select * from account where name like concat(#{pName}, '%')")
    List<AccountEntity>  queryPaging(@Param("pName")String name);

    @Select("")
    void delete();
}
