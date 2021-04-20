/*
 * Copyright (c) eHealth
 */
package be.jeremy.pascal.ci.backend;

import be.jeremy.pascal.ci.backend.compiler.CodeGenerator;
import be.jeremy.pascal.ci.backend.interpreter.Executor;

/**
 * @author Jeremy Vanpe (eh056)
 */
public class BackendFactory {

    public static Backend createBackend(String operation) throws Exception {
        if (operation.equalsIgnoreCase("compile")) {
            return new CodeGenerator();
        } else if (operation.equalsIgnoreCase("execute")) {
            return new Executor();
        } else {
            throw new Exception("Backend factory: Invalid operation '" + operation + "'");
        }
    }

}
