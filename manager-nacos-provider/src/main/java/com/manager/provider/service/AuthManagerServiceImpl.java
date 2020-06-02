package com.manager.provider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.commons.HttpStatus;
import com.manager.commons.TimeUtils;
import com.manager.commons.bCryptPasswordUtils;
import com.manager.domain.TbUser;
import com.manager.domaindto.UserDto;
import com.manager.exception.AuthException;
import com.manager.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunli
 * @date 2020/5/12 3:19
 */
@Service
public class AuthManagerServiceImpl implements AuthManagerService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public List<UserDto> selectAllUserInfo() throws Exception {
        return tbUserMapper.selectAllUserInfo();
    }

    @Override
    public Map<String, Object> pagingAllUserInfo(Integer ids) {
        Map<String,Object> map = null;
        List<UserDto> userDtoList = null;
        try {
            map = new HashMap<>();
            PageHelper.startPage(ids,12);
            userDtoList = this.selectAllUserInfo();
            PageInfo page = new PageInfo(userDtoList);
            // 当前请求第几页
            map.put("pageNum",page.getPageNum());
            // 总页数
            map.put("pageSize",page.getPageSize());
            // 首页页数
            map.put("isFirstPage",page.isIsFirstPage());
            // 尾页页数
            map.put("isLastPage",page.isIsLastPage());
            // 当前页数的数据
            map.put("stuList",userDtoList);
            // 查询所有数据的数量
            map.put("recordNum",page.getTotal());
            return map;
        } catch (Exception e) {
            throw new AuthException(HttpStatus.TP_FAILED,"分页失败");
        }
    }

    @Override
    public Boolean deleteOneUserInfo(Integer id) throws Exception {
        return tbUserMapper.deleteOneUserInfo(id);
    }

    @Override
    public Boolean deleteOneService(Integer id) {
        if (id != null) {
            try {
                return this.deleteOneUserInfo(id);
            } catch (Exception e) {
                throw new AuthException(HttpStatus.TP_FAILED,"删除失败");
            }
        }
        return false;
    }

    @Override
    public Boolean deleteSomeService(List<Integer> idList) {
        if (idList != null) {
            idList.forEach(this::deleteOneService);
            return true;
        }
        return false;
    }

    @Override
    public Boolean insertOneUserInfo(UserDto userDto) throws Exception {
        return tbUserMapper.insertOneUserInfo(userDto);
    }

    @Override
    public Boolean insertRoleAndUser(UserDto userDto) throws Exception {
        return tbUserMapper.insertRoleAndUser(userDto);
    }

    @Override
    public Boolean insertUserInfoService(UserDto userDto){
        if (userDto != null) {
            if (checkUserName(userDto.getUsername()) <= 0) {
                if (checkPhone(userDto.getPhone()) <= 0) {
                    if (checkEmail(userDto.getEmail()) <= 0) {
                        try {
                            // 给密码加密
                            userDto.setPassword(bCryptPasswordUtils.encode(userDto.getPassword()));
                            // 默认图片地址
                            userDto.setImge("http://qa17s84ln.bkt.clouddn.com/1.png");
                            if (insertOneUserInfo(userDto)) {
                                if (insertRoleAndUser(userDto)){
                                    return true;
                                }
                            }
                        } catch (Exception e) {
                            throw new AuthException(HttpStatus.TP_FAILED,"添加失败");
                        }
                    } else {
                        throw new AuthException(HttpStatus.TP_FAILED,"邮箱已经存在");
                    }
                } else {
                    throw new AuthException(HttpStatus.TP_FAILED,"手机号已经存在");
                }
            } else {
                throw new AuthException(HttpStatus.TP_FAILED,"用户名已经存在");
            }
        }
        return false;
    }

    @Override
    public Integer checkUserName(String userName) {
        Example e = new Example(TbUser.class);
        e.createCriteria().andEqualTo("username",userName);
        return tbUserMapper.selectCountByExample(e);
    }

    @Override
    public Integer checkPhone(String phone) {
        Example e = new Example(TbUser.class);
        e.createCriteria().andEqualTo("phone",phone);
        return tbUserMapper.selectCountByExample(e);
    }

    @Override
    public Integer checkEmail(String email) {
        Example e = new Example(TbUser.class);
        e.createCriteria().andEqualTo("email",email);
        return tbUserMapper.selectCountByExample(e);
    }

    @Override
    public Boolean updateUserInfo(UserDto userDto) throws Exception {
        return tbUserMapper.updateUserInfo(userDto);
    }

    @Override
    public Boolean updateUserRole(UserDto userDto) throws Exception {
        return tbUserMapper.updateUserRole(userDto);
    }

    @Override
    public Boolean updateUserInfoService(UserDto userDto) {
        if (userDto.getId() != null) {
            try {
                if (!"".equals(userDto.getUsername())) {
                    if (checkUserName(userDto.getUsername()) >= 1) {
                        throw new AuthException(HttpStatus.TP_FAILED,"用户名已经存在");
                    }
                }
                if (!"".equals(userDto.getPhone())) {
                    if (checkPhone(userDto.getPhone()) >= 1) {
                        throw new AuthException(HttpStatus.TP_FAILED,"手机号已经存在");
                    }
                }
                if (!"".equals(userDto.getEmail())) {
                    if (checkEmail(userDto.getEmail()) >= 1) {
                        throw new AuthException(HttpStatus.TP_FAILED,"邮箱已经存在");
                    }
                }
                if (!"".equals(userDto.getPassword())) {
                    String newPass = bCryptPasswordUtils.encode(userDto.getPassword());
                    userDto.setPassword(newPass);
                }
                if (!"".equals(userDto.getName())) {
                    if (this.updateUserInfo(userDto)) {
                        return this.updateUserRole(userDto);
                    }
                }
                return this.updateUserInfo(userDto);
            } catch (Exception e) {
                throw new AuthException(HttpStatus.TP_FAILED,"更新失败");
            }
        }
        return false;
    }

    @Override
    public Boolean updateUserPhoneOrEmailService(UserDto userDto) {
        if (userDto != null) {
            try {
                if (userDto.getPhone() != null) {
                    if (checkPhone(userDto.getPhone()) > 1) {
                        throw new AuthException(HttpStatus.TP_FAILED, "手机号已经存在");
                    }
                }
                if (userDto.getEmail() != null) {
                    if (checkEmail(userDto.getPhone()) > 1) {
                        throw new AuthException(HttpStatus.TP_FAILED, "邮箱已经存在");
                    }
                }
                return this.updateUserInfo(userDto);
            } catch (Exception e) {
                throw new AuthException(HttpStatus.TP_FAILED,"更新失败");
            }
        }
        throw new AuthException(HttpStatus.TP_FAILED,"更新失败");
    }



    @Override
    public Boolean changeUserSecretService(Long id,String old, String newSe, String reNewSe) {
        if (old != null) {
            if (newSe != null) {
                if (reNewSe != null) {
                    if (reNewSe.equals(newSe)) {
                        if (this.checkPassInfo(id, old)) {
                            return this.updatePassInfo(id,reNewSe);
                        } else {
                            throw new AuthException(HttpStatus.TP_FAILED,"原密码输入不正确");
                        }
                    } else {
                        throw new AuthException(HttpStatus.TP_FAILED,"两次输入密码不相同");
                    }
                } else {
                    throw new AuthException(HttpStatus.TP_FAILED,"重新输入不能为空");
                }
            } else {
                throw new AuthException(HttpStatus.TP_FAILED,"现密码不能为空");
            }
        } else {
            throw new AuthException(HttpStatus.TP_FAILED,"原密码不能为空");
        }
    }

    @Override
    public Boolean checkPassInfo(Long id, String pass) {
        Example e = new Example(TbUser.class);
        e.createCriteria().andEqualTo("id", id);
        TbUser tbUser = tbUserMapper.selectOneByExample(e);
        return bCryptPasswordUtils.matchers(pass,tbUser.getPassword());
    }

    @Override
    public Boolean updatePassInfo(Long id,String pass) {
        String newPass = bCryptPasswordUtils.encode(pass);
        try {
            return tbUserMapper.updateUserPass(id, newPass);
        } catch (Exception e) {
            throw new AuthException(HttpStatus.TP_FAILED,"网路错误");
        }
    }

    @Override
    public Boolean updateUserHeaderImgService(Long id,String imgUrl) {
        try {
            return tbUserMapper.updateUserImg(id,imgUrl);
        } catch (Exception e) {
            throw new AuthException(HttpStatus.TP_FAILED,"上传失败");
        }
    }
}
