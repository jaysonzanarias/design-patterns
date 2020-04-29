package creational_patterns.abstract_factory.factories;

import creational_patterns.abstract_factory.buttons.Button;
import creational_patterns.abstract_factory.checkboxes.Checkbox;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
