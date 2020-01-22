package br.com.curso.web.spring.devdojo.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSouceAop {
    @Pointcut("@annotation(br.com.curso.web.spring.devdojo.config.MySQL) " +
            "|| execution(* br.com.curso.web.spring.devdojo.service..*.insert*(..)) " +
            "|| execution(* br.com.curso.web.spring.devdojo.service..*.add*(..)) " +
            "|| execution(* br.com.curso.web.spring.devdojo.service..*.update*(..)) " +
            "|| execution(* br.com.curso.web.spring.devdojo.service..*.edit*(..)) " +
            "|| execution(* br.com.curso.web.spring.devdojo.service..*.delete*(..)) " +
            "|| execution(* br.com.curso.web.spring.devdojo.service..*.remove*(..))")
    public void writePointcut() {
    }

    @Pointcut("!@annotation(br.com.curso.web.spring.devdojo.config.MySQL) " +
            "&& (execution(* br.com.curso.web.spring.devdojo.service..*.select*(..)) " +
            "|| execution(* br.com.curso.web.spring.devdojo.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Before("writePointcut()")
    public void write() {
        DBContext.mySQL();
    }

    @Before("readPointcut()")
    public void read() {
        DBContext.mySQLSlave();
    }
}
