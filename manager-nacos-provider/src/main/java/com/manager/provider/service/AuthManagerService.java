package com.manager.provider.service;

import com.manager.domain.TbUser;
import com.manager.domaindto.UserDto;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/5/12 3:19
 */
public interface AuthManagerService {

    /**
     * 查询所有用户信息
     * @return 用户信息集合
     * @throws Exception
     */
    public List<UserDto> selectAllUserInfo() throws Exception;

    /**
     * 分页查询所有数据
     * @param ids 页数
     * @return 用户集合
     */
    public Map<String, Object> pagingAllUserInfo(Integer ids);

    /**
     * 删除单个用户信息
     * @param id id
     * @return 是否删除成功
     * @throws Exception
     */
    public Boolean deleteOneUserInfo(Integer id) throws Exception;

    /**
     * 单个删除服务
     * @param id id
     * @return 是否删除成功
     */
    public Boolean deleteOneService(Integer id);

    /**
     * 删除多个服务
     * @param idList id集合
     * @return 是否删除成功
     */
    public Boolean deleteSomeService(List<Integer> idList);

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
     * 添加新用户
     * 并且赋予角色
     * @param userDto 用户对象
     * @return 是否添加成功
     * @throws Exception
     */
    public Boolean insertUserInfoService(UserDto userDto);


    /**
     * 查看用户名是否存在
     * @param userName 用户名
     * @return 集合
     * @throws Exception
     */
    public Integer checkUserName(String userName);

    /**
     * 查看手机号是否存在
     * @param phone 手机号
     * @return 集合
     * @throws Exception
     */
    public Integer checkPhone(String phone);

    /**
     * 查看邮箱是否存在
     * @param email 邮箱
     * @return 集合
     * @throws Exception
     */
    public Integer checkEmail(String email);

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
     * 更新用户信息服务
     * @param userDto 更新对象
     * @return 是否更新成功
     */
    public Boolean updateUserInfoService(UserDto userDto);

    /**
     * 更新用户手机号或者邮箱
     * @param userDto 更新对象
     * @return 是否更新成功
     */
    public Boolean updateUserPhoneOrEmailService(UserDto userDto);

    /**
     * 修改密码
     * @param id id
     * @param old 原密码
     * @param newSe 现密码
     * @param reNewSe 再次输入
     * @return 是否更新成功
     */
    public Boolean changeUserSecretService(Long id, String old, String newSe,String reNewSe);

    /**
     * 密码
     * @param id id
     * @param pass 密码
     * @return 是否匹配
     */
    public Boolean checkPassInfo(Long id, String pass);

    /**
     * 更新密码
     * @param pass 密码
     * @return 更新密码
     */
    public Boolean updatePassInfo(Long id,String pass);

    /**
     * 更新用户头像
     * @param id 用户id
     * @param imgUrl 用户图片地址
     * @return 是否更新成功
     */
    public Boolean updateUserHeaderImgService(Long id,String imgUrl);
}
