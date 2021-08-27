/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import BuilderPattern.ToolBar;
import GraphicInterface.MyGui;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.tools.Diagnostic;
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

    private static URLClassLoader urlClassLoader;
    private static String nameMainClas;

    public static void runJava(File classesDir) throws Exception, NoSuchMethodException, MalformedURLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
        try {
            ClassLoader classLoader = MyGui.class.getClassLoader();
            urlClassLoader = new URLClassLoader(
                    new URL[]{ToolBar.getDirectory().toURI().toURL()},
                    classLoader);

            FileFilter fileFilterm = new FileFilter() {
                //Override accept method
                public boolean accept(File file) {
                    //if the file is not a directory and the file extension is .java return true, else false
                    if (!file.isDirectory() && file.getName()
                            .endsWith(".class")) {
                        return true;
                    }
                    return false;
                }
            };

            ArrayList<File> projectFilesm = new ArrayList<>(Arrays.asList(ToolBar.getDirectory().listFiles(fileFilterm)));

            for (File fil : projectFilesm) {

                Class cls = Class.forName(fil.getName().substring(0,
                        fil.getName().length() - 6), true, urlClassLoader);
                Method[] methods = cls.getMethods();
                for (Method m : methods) {
                    if (m.getName().equals("main")) {
                        nameMainClas = cls.getName();
                        m = cls.getMethod("main", String[].class);
                        String[] params = null; // init params accordingly

                        if (Run.getExists() == false) {
                            m.invoke(null, (Object) params);
                        }
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("Cannot run main class");
        }
    }
    private static Boolean exists = false;

    public static Boolean getExists() {
        return exists;
    }

    public static void compileJava(ArrayList<File> projFiles) throws IOException {
        try {
            if (projFiles == null || projFiles.isEmpty()) {
                return;
            }
            // Set up compiler
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            // Get the file system manager of the compiler
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
            // Create a compilation unit (project files)
            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(projFiles);
            // A feedback object (diagnostic) to get errors
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
            // Get compile task
            JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits);
            // The compile task is called
            task.call();
            //check if we have any error
            exists = false;
            for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
                System.out.format("Error on line %d in %s%n",
                        diagnostic.getLineNumber(),
                        diagnostic.getSource());
                exists = true;
            }
            // Close the compile resources
            fileManager.close();
        } catch (Exception e) {

        }
    }

    public static void compile(File f) throws IOException {
        // set up compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        try (// Get the file system manager of the compiler and create a compilation unit (project files)
                StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null)) {
            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(Arrays
                    .asList(f));
            // Get compile task
            compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits).call();

            // check we don't have any compilation errors
            for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
                System.out.format("Error on line %d in %s%n",
                        diagnostic.getLineNumber(),
                        diagnostic.getSource());
            }
        }
    }

}
