package com.offcn.service;

import com.offcn.dao.UserDao;
import com.offcn.po.Movie;
import com.offcn.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RestTemplate restTemplate;

    public User getUserById(Integer id) {
        User user = userDao.getUser(id);
        return user;
    }

    public Map<String, Object> buyMovie(Integer id) {
        Map<String, Object> result = new HashMap<>();
        //1.查询用户信息
        User user = this.getUserById(id);
        result.put("user", user);
        //2.查到最新电影票
        Movie movie = restTemplate.getForObject("http://PROVIDERMOVIE/movie",Movie.class);
        result.put("movie", movie);
        return result;
    }
}
