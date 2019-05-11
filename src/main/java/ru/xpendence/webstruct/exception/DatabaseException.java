package ru.xpendence.webstruct.exception;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 21.09.18
 * Time: 9:25
 * e-mail: 2262288@gmail.com
 */
public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super(message);
    }
}
