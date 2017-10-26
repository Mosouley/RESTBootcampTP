
package com.bootcamp.rest;

import com.bootcamp.rest.controllers.BailleurRestController;
import com.bootcamp.rest.controllers.ProgrammeRestController;
import com.bootcamp.rest.controllers.ProjetRestController;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author soul
 */
//@ApplicationPath("/rest")
public class HateoasApp extends Application {
 public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(BailleurRestController.class
        ,ProgrammeRestController.class,
        ProjetRestController.class));
    }
}
