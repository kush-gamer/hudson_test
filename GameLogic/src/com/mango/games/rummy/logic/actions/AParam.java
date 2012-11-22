/**
 * This annotation is to map the client event params to respective parameters in the methods.
 * This is to help call the event handlers using reflection, and avoid error prone message mapping. 
 * @author Sanjeev
 *
 */

package com.mango.games.rummy.logic.actions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)

public @interface AParam 
{
    String name();
    String type() default "not-used";
    //Type can be extracted from method signature.
}
