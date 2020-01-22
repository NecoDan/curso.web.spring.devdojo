package br.com.curso.web.spring.devdojo.config;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class DBContext {

    private static final ThreadLocal<DBTypeEnum> dbContext = new ThreadLocal<>();

    private static final AtomicInteger contador = new AtomicInteger(-1);

    public static void setDbContext(DBTypeEnum dbTypeEnum) {
        dbContext.set(dbTypeEnum);
    }

    public static DBTypeEnum getDbContext() {
        return dbContext.get();
    }

    public static void mySQL() {
        setDbContext(DBTypeEnum.MYSQL_MASTER);
        log.info("alterado para o banco master MYSQL");
    }

    public static void mySQLSlave() {
        int i = contador.getAndIncrement() % 2;
        log.info("slave Number of Threads for Library Access==>{}", contador.get());

        if (i == 0) {
            setDbContext(DBTypeEnum.MYSQL_SLAVE);
            log.info("switch to slave1 library");
        } else {
            setDbContext(DBTypeEnum.MYSQL_SLAVE2);
            log.info("switch to slave2 library");
        }
    }
}
