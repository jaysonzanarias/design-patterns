package creational_patterns.factory_method.factory;

import creational_patterns.factory_method.buttons.Button;
import creational_patterns.factory_method.buttons.HtmlButton;

/**
 * HTML Dialog will produce HTML buttons.
 */
public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
