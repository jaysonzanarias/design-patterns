package creational_patterns.abstract_factory.factories;

import creational_patterns.abstract_factory.buttons.Button;
import creational_patterns.abstract_factory.buttons.WindowsButton;
import creational_patterns.abstract_factory.checkboxes.Checkbox;
import creational_patterns.abstract_factory.checkboxes.WindowsCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
