package com.sawcunha.controlerelatorio.redis.repository;

import com.google.gson.Gson;
import com.sawcunha.controlerelatorio.redis.model.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AuthTokenRepository {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private ValueOperations<String, Object> valueOperations;

    private Gson gson;

    @Value("${spring.redis.expiretime}")
    private Long expireTime;

    @PostConstruct
    private void intializeHashOperations() {
        redisTemplate.setEnableTransactionSupport(true);
        valueOperations = redisTemplate.opsForValue();
        gson = new Gson();
    }

    public void saveToken(UUID uuid, AuthToken authToken){
        valueOperations.set(uuid.toString(), gson.toJson(authToken));
        redisTemplate.expire(uuid.toString(), Duration.ofSeconds(expireTime));
    }

    public AuthToken get(String uuid){
        Optional<String> authOp = Optional.ofNullable((String)valueOperations.get(uuid));
        return authOp.map(s -> gson.fromJson(s, AuthToken.class)).orElse(null);
    }
}
