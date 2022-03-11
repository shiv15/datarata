package com.datarata.datagenerator.api;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;


/**
 * Annotation interface to support API Versions.
 *
 * @author Shivendu Amale
 * @since March 07, 2022
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE} )
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiVersion {

    public double from() default Double.MIN_VALUE;
    public double to() default Double.MAX_VALUE;

}