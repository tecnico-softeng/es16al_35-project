package pt.tecnico.mydrive;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import pt.tecnico.mydrive.domain.*;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;

import java.util.Set;

/**
 * Hello world!
 *
 */

public class MyDriveApplication {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SetupDomain.populateDomain();
    }
}
