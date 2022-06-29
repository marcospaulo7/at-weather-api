package com.br.currentweather.utils;

import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
public class logUtils {

    private logUtils() {
        throw new IllegalStateException("Classe de utilidade para manipulação de paginas, não é necessario criar uma instancia");
    }

    public static void printHour(String previous, LocalDateTime time) {
        log.info(previous + ": " + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
    }

    public static void printTime(String previous, LocalDateTime time) {
        log.info(previous + ": " + time.getHour() + " Hour(s) " + time.getMinute() + " minute(s) " + time.getSecond() + " second(s)");
    }


}
