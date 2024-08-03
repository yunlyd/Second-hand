package com.yunyd.mapper;

import com.yunyd.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作Comment相关数据接口
 * @lyd
 * @date 2024/8/1
*/
public interface CommentMapper {

    /**
     * 新增
     */
    int insert(Comment comment);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Comment comment);

    /**
     * 根据ID查询
     */
    Comment selectById(Integer id);

    /**
     * 查询所有
     */
    List<Comment> selectAll(Comment comment);

    /**
     * 查询评论树形列表
     */
    List<Comment> selectTree(@Param("fid") Integer fid, @Param("module") String module);

    /**
     * 查询根节点一样的消息评论
     */
    List<Comment> selectByRootId(Integer rootId);

    /**
     * 查询评论数量
     */
    @Select("select count(*) from comment where fid = #{fid} and module = #{module}")
    Integer selectCount(@Param("fid") Integer fid, @Param("module") String module);

    /**
     * 根据pid找出所有子集评论
     */
    @Select("select * from comment where pid = #{pid}")
    List<Comment> selectByPid(Integer pid);
}




