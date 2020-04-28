package creational_patterns.factory_method.factory;

import creational_patterns.factory_method.buttons.Button;
import creational_patterns.factory_method.buttons.WindowsButton;

/**
 * Windows Dialog will produce Windows buttons.
 */
public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
