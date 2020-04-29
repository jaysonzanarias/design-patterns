package creational_patterns.abstract_factory;

import creational_patterns.abstract_factory.app.Application;
import creational_patterns.abstract_factory.factories.GUIFactory;
import creational_patterns.abstract_factory.factories.MacOSFactory;
import creational_patterns.abstract_factory.factories.WindowsFactory;

/**
 * Demo class. Everything comes together here.
 * https://refactoring.guru/design-patterns/abstract-factory/java/example
 */
public class Demo {

    /**
     * Application picks the factory type and creates it in run time (usually at
     * initialization stage), depending on the configuration or environment
     * variables.
     */
    public static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
            app = new Application(factory);
        } else {
            factory = new WindowsFactory();
            app = new Application((factory));
        }
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
