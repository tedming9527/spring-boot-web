package org.example.springbootweb.service.impl;

import org.example.springbootweb.entity.User;
import org.example.springbootweb.mapper.UserMapper;
import org.example.springbootweb.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ted
 * @since 2025-12-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
