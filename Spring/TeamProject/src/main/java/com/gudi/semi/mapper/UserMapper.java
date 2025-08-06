package com.gudi.semi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Update("UPDATE user SET point = point + #{amount} WHERE user_id = #{userId}")
    void chargePoint(@Param("userId") String userId, @Param("amount") int amount);
}
