package com.manager.mapper;

import basemapper.BaseMapper;
import com.manager.domain.TbUser;
import com.manager.domaindto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
*@author sunli
* @date 2020/3/24 0:49
*/
@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {

    public List<TbUser> selectOneUserByUserName(String username) throws Exception;


    /**
     * 查询用户信息包括角色
     * @param username 用户名
     * @return 用户信息
     * @throws Exception
     */
    public UserDto getUserInfoByUserName(@Param("username")String username)throws Exception;

    /**
     * 查询用户信息
     * @param username 用户名
     * @return 用户信息
     * @throws Exception
     */
    public UserDto selectOneByUserName(@Param("username") String username)throws Exception;

    /**
     * 查询所有用户信息
     * @return 用户信息集合
     * @throws Exception
     */
    public List<UserDto> selectAllUserInfo() throws Exception;

    /**
     * 删除单个用户信息
     * @param id id
     * @return 是否删除成功
     * @throws Exception
     */
    public Boolean deleteOneUserInfo(Integer id) throws Exception;


    /**
     * 添加新用户
     * @param userDto 用户对象
     * @return 是否添加成功
     * @throws Exception
     */
    public Boolean insertOneUserInfo(UserDto userDto) throws Exception;

    /**
     * 给用户添加角色
     * @param userDto 用户对象
     * @return 是否添加成功
     * @throws Exception
     */
    public Boolean insertRoleAndUser(UserDto userDto) throws Exception;

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 用户集合
     * @throws Exception
     */
    public List<UserDto> selectUserInfoByUserName(String username) throws Exception;

    /**
     * 更新用户信息
     * @param userDto 更新对象
     * @return 是否更新成功
     * @throws Exception
     */
    public Boolean updateUserInfo(UserDto userDto) throws Exception;

    /**
     * 更新用户角色
     * @param userDto 更新对象
     * @return 是否更新成功
     * @throws Exception
     */
    public Boolean updateUserRole(UserDto userDto) throws Exception;

    /**
     * 更新密码
     * @param id id
     * @param password 密码
     * @return 是否更新成功
     * @throws Exception
     */
    public Boolean updateUserPass(@Param("id") Long id,@Param("password") String password) throws Exception;

    /**
     * 更新用户头像
     * @param img 头像地址
     * @return 是否更新成功
     * @throws Exception
     */
    public Boolean updateUserImg(@Param("id") Long id,@Param("img") String img)throws Exception;


}