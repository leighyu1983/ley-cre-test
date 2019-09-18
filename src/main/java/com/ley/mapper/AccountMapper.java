package com.ley.mapper;

import com.ley.entity.AccountEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper {
    @Insert("insert into account(id, name, address) values(#{id},#{name},#{address})")
    int insert(AccountEntity account);

    @Insert("")
    //@Lang(SelectInLangDriver.class)
    String insertWithXml();

    @Update("")
    void update();

    @Select("")
    void querySimple();

    @Select("")
    void queryJoin();

    @Select("")
    void queryPaging();

    @Select("")
    void queryIn();

    @Select("")
    void delete();
}
