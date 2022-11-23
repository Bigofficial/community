package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;

@Mapper
public interface DiscussPostMapper {
    //动态sql 有id就拼
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit, int orderMode);

    //查询有多少数据 动态sql 动态拼接条件，且这个方法只有一个参数，那么必须加上@Param Param取别名
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    //增加评论数量
    int updateCommentCount(int id, int commentCount);

    int updateType(int id, int type);

    int updateStatus(int id, int status);
    int updateScore(int id, double score);

}
