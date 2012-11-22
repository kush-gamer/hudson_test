/**
 * This annotation is to map the client events (messages) and their parameters
 * to the action handlers on the server side. 
 * @author Sanjeev
 *
 */
package com.mango.games.rummy.logic.actions;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface AEvent 
{
    String msg();
}
