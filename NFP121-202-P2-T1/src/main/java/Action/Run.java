/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import GraphicInterface.MyGui;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 *
 * @author Cynthia
 */
public class Run {
    
    private static String MAIN_CLASS_FILE = "mainCls.java";
    private static String MAIN_CLASS_NAME = "mainCls";
    
    public static void runJava(File classesDir) throws Exception, NoSuchMethodException, MalformedURLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
        try {
            ClassLoader classLoader = MyGui.class.getClassLoader();
            URLClassLoader urlClassLoader = new URLClassLoader(
                    new URL[]{classesDir.toURI().toURL()},
                    classLoader);
            Class<?> javaDemoClass = Class.forName(MAIN_CLASS_NAME, true, urlClassLoader);
            Method method = javaDemoClass.getMethod("main", String[].class);
            String[] params = null; // init params accordingly
            method.invoke(null, (Object) params); // null because this is a static method
        } catch (Exception e) {
            System.out.println("Cannot run main class");
        }
    }

    public static void compileJava(ArrayList<File> projFiles) throws IOException {
        try {
            if (projFiles == null || projFiles.isEmpty()) {
                return;
            }

            // Get the compiler
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            // Get the file system manager of the compiler
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
            // Create a compilation unit (files)
            Iterable<? extends JavaFileObject> compilationUnits
                    = fileManager.getJavaFileObjectsFromFiles(projFiles);
            // A feedback object (diagnostic) to get errors
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
            // Compilation unit can be created and called only once
            JavaCompiler.CompilationTask task = compiler.getTask(
                    null,
                    fileManager,
                    diagnostics,
                    null,
                    null,
                    compilationUnits
            );
            // The compile task is called
            task.call();
            // Printing of any compile problems
            diagnostics.getDiagnostics().forEach(diagnostic -> {
                System.out.format("Error on line %d in %s%n",
                        diagnostic.getLineNumber(),
                        diagnostic.getSource());
            });

            // Close the compile resources
            fileManager.close();
        } catch (Exception e) {
            System.out.println("Cannot run main class");
        }
    }

    public static List<Class> findClasses(File directory, String packageName) {
        try {
            List<Class> classes = new ArrayList<Class>();
            if (!directory.exists()) {
                return classes;
            }
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    assert !file.getName().contains(".");
                    classes.addAll(findClasses(file,
                            packageName + "." + file.getName()));
                } else if (file.getName().endsWith(".class")) {
                    classes.add(Class.forName(packageName
                            + '.'
                            + file.getName().substring(0,
                                    file.getName().length() - 6)));
                }
            }
            return classes;
        } catch (Exception e) {
            System.out.println("Cannot run main class");
        }
        return null;
    }

}


