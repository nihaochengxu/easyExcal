package com.it.easyexcal.controller;

import com.it.easyexcal.entity.User;
import com.it.easyexcal.mapper.UserMapper;
import com.it.easyexcal.service.IUserService;
import com.it.easyexcal.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * <p>
 * 【会员模块】会员信息 前端控制器
 * </p>
 *
 * @author Brave
 * @date 2022-07-01
 * @version V1.0
 */
@RestController
@RequestMapping("/user")
@Api(value = "UserController", tags = {"【user模块】"})
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Resource
    private UserMapper userMapper;
    @GetMapping("list")
    @ApiOperation("查询用户列表")
    public Result selectUserList(){
        List<User> list = iUserService.list();
        for (User user : list) {
            String nickname = user.getNickname();
        }
        return Result.ok(list);
    }
    @GetMapping("getOne")
    @ApiOperation("查询用户列表")
    public Result getUser(String uuid){
        User user = userMapper.queryUserByid(uuid);
        return Result.ok(user);
    }
//    @PostMapping
//    public Result test(){
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
////        SqlSessionFactory sqlSessionFactory =
////        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties p=new Properties();
        p.load(new FileReader("my.properties"));
//        properties.load(new FileReader(Blog.class.getResource("/").getPath()+ File.separator+"myPro.properties"));
//        String myDir=properties.getProperty("myDir");
//        System.out.println(myDir);
    }
}
