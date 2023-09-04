package org.example;

import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Collection;

public class RedisStorage {
    private RedissonClient redisson;
    private RKeys rKeys;
    private RScoredSortedSet<String> onlineUsers;
    private final static String KEY = "ONLINE_USERS";

    private long getTs() {
        return System.currentTimeMillis();
    }

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException ex) {
            System.out.println("Не удалось подключиться к Redis");
            System.out.println(ex.getMessage());
        }
        rKeys = redisson.getKeys();
        onlineUsers = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void logUserVisit(int userId) {
        //ZADD ONLINE_USERS
        onlineUsers.add(getTs(), String.valueOf(userId));
    }

    void shutdown() {
        redisson.shutdown();
    }

    void printRaiseUpUser(String userId) {
        System.out.printf(" > Пользователь %s оплатил платную услугу!\n", userId);
    }

    public Collection<String> getUsersList() {
        return onlineUsers.valueRange(0, -1);
    }


}
