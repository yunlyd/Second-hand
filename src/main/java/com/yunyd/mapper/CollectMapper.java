package com.yunyd.mapper;

import com.yunyd.entity.Collect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 操作collect相关数据接口
 * @lyd
 * @date 2024/7/31
*/
public interface CollectMapper {

    @Insert("insert into collect (fid, user_id, module) values  (#{fid}, #{userId}, #{module})")
    void insert(Collect collect);

    @Delete("delete from collect where id = #{id}")
    void deleteById(Integer id);

    @Select("select * from collect where user_id = #{userId} and fid = #{fid}")
    Collect selectByUserIdAndFid(@Param("userId") Integer userId, @Param("fid") Integer fid);

    @Select("select count(*) from collect where fid = #{fid}")
    int selectCountByFid(Integer fid);
}




