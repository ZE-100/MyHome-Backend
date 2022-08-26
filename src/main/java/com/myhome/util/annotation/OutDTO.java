package com.myhome.util.annotation;

import java.lang.annotation.*;

/**
 * If an interface or abstract class is annotated with {@code OutDTO}, then
 * any class, extending this abstract class or implementing this interface
 * also is of type {@code OutDTO}.
 *
 * {@code OutDTO} is an annotation entirely designed for documentation purposes.
 *
 * Any class, interface or abstract class annotated with {@code OutDTO}
 * should only be used as a generic response for a request sent to the API.
 *
 * @author  Z-100
 * @since 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OutDTO {}
