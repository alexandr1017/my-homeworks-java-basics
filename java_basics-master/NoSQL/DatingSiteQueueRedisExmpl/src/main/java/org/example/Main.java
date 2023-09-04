package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class Main {
    // Запуск докер-контейнера:
    // docker run --rm --name skill-redis -p 127.0.0.1:6379:6379/tcp -d redis

    // всего на сайт заходило 20 различных пользователей
    private static final int USERS = 20;

    // добавим задержку между посещениями
    private static final int SLEEP = 1; // 1 миллисекунда


    public static void main(String[] args) throws InterruptedException {

        RedisStorage redisStorage = new RedisStorage();
        redisStorage.init();

        // заполним сайт знакомств пользователями
        initUsersOnSite(redisStorage);

        Random rnd = new Random();
        String userId;
        List<String> repeatsList = new ArrayList<>();
        boolean flag;

        while (true) {

            for (String user : redisStorage.getUsersList()) {
                flag = false;
                if (rnd.nextInt(100) < 10) {
                    userId =String.valueOf(rnd.nextInt(USERS) + 1);
                    redisStorage.printRaiseUpUser(userId);
                    log(userId);

                    repeatsList.add(userId);
                    Thread.sleep(1000);
                }

                if (repeatsList.contains(user)) flag = true;
                if (flag) continue;

                log(user);
                Thread.sleep(1000);
            }
            repeatsList.clear();
            out.println("=============================================");

        }
    }

    private static void initUsersOnSite(RedisStorage redisStorage) throws InterruptedException {
        for (int usersCount = 1; usersCount <= USERS; usersCount++) {
            redisStorage.logUserVisit(usersCount);
            Thread.sleep(SLEEP);
        }
    }

    private static void log(String userId) {
        String log = String.format("-На главной странице показываем пользователя: %s", userId);
        out.println(log);
    }
}
