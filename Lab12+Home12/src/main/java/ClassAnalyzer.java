import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ClassAnalyzer {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Pune in edit config \"C://storage//java//Lab12+Home12\" si in VM -ea");
            return;
        }

        File file = new File(args[0]);
        List<Class<?>> classes = new ArrayList<>();

        try {
            if (file.isDirectory()) {
                loadClassesFromDirectory(file, classes);
            } else if (file.getName().endsWith(".jar")) {
                loadClassesFromJar(file, classes);
            } else if (file.getName().endsWith(".class")) {
                classes.add(loadClassFromFile(file));
            }

            analyzeAndTestClasses(classes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadClassesFromDirectory(File directory, List<Class<?>> classes) throws Exception {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                loadClassesFromDirectory(file, classes);
            } else if (file.getName().endsWith(".class")) {
                classes.add(loadClassFromFile(file));
            }
        }
    }

    private static void loadClassesFromJar(File jarFile, List<Class<?>> classes) throws IOException, ClassNotFoundException {
        try (JarInputStream jarInputStream = new JarInputStream(new FileInputStream(jarFile))) {
            JarEntry entry;
            while ((entry = jarInputStream.getNextJarEntry()) != null) {
                if (entry.getName().endsWith(".class")) {
                    String className = entry.getName().replace('/', '.').replace(".class", "");
                    classes.add(Class.forName(className, true, getClassLoader(jarFile)));
                }
            }
        }
    }

    private static Class<?> loadClassFromFile(File classFile) throws IOException, ClassNotFoundException {
        String className = classFile.getName().replace(".class", "");
        return Class.forName(className, true, getClassLoader(classFile));
    }

    private static URLClassLoader getClassLoader(File file) throws IOException {
        URL[] urls = {file.toURI().toURL()};
        return new URLClassLoader(urls);
    }

    private static void analyzeAndTestClasses(List<Class<?>> classes) {
        int totalTests = 0;
        int passedTests = 0;
        int failedTests = 0;

        for (Class<?> cls : classes) {
            System.out.println('\n' + "Analyzing class: " + cls.getName());
            for (Method method : cls.getDeclaredMethods()) {
                System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getName() + " " + method.getName() + "()");

                if (method.isAnnotationPresent(Test.class)) {
                    totalTests++;
                    try {
                        if (Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 0) {
                            method.invoke(null);
                        } else if (method.getParameterCount() > 0) {
                            Object[] mockParams = generateMockParameters(method.getParameterTypes());
                            method.invoke(cls.getDeclaredConstructor().newInstance(), mockParams);
                        } else {
                            method.invoke(cls.getDeclaredConstructor().newInstance());
                        }
                        passedTests++;
                    } catch (Exception e) {
                        System.err.println("Test failed: " + cls.getName() + "->" + method.getName());
                        failedTests++;
                    }
                }
            }
        }

        System.out.println("\nTest Execution Statistics:");
        System.out.println("Total tests: " + totalTests);
        System.out.println("Passed tests: " + passedTests);
        System.out.println("Failed tests: " + failedTests);
    }

    private static Object[] generateMockParameters(Class<?>[] parameterTypes) {
        Object[] params = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i] == int.class) {
                params[i] = 0;
            } else if (parameterTypes[i] == String.class) {
                params[i] = "";
            } else {
                params[i] = null;
            }
        }
        return params;
    }
}
