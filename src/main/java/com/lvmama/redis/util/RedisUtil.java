package com.lvmama.redis.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Service
public class RedisUtil {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     *  设置失效时间
     * @param key :主键
     * @param time:时间（秒）
     * @return
     */
    public boolean setExpire(String key,long time){
        try {
            if(time>0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取失效时间
     * @param key :主键
     * @return
     */
    public long getExpire(String key){
       return  redisTemplate.getExpire(key);
    }

    /**
     * 判断key是否存在
     * @param key:主键
     * @return
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * @param key:主键
     */
    public void delete(String...key){
      if(key != null && key.length>0){
          if(key.length == 1){
              redisTemplate.delete(key[0]);
          }else{
              redisTemplate.delete(Arrays.asList(key));
          }
      }
    }

    /**
     *  放入缓存
     * @param key
     * @param value
     * @return
     */
   public boolean set(String key,Object value){
       try {
            redisTemplate.opsForValue().set(key, value);
            return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
   }

    /**
     * 获取value
     * @param key
     */
   public void get(String key){
         redisTemplate.opsForValue().get(key);
   }


    //
}
