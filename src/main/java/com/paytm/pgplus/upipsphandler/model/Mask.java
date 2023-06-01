package com.paytm.pgplus.upipsphandler.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by charu on 27/12/18.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Mask {

    int prefixNoMaskLen() default 0;

    int suffixNoMaskLen() default 0;

    String maskStr() default "*";
}
