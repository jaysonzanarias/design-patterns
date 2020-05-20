package behavioral_patterns.mediator;

import behavioral_patterns.mediator.components.AddButton;
import behavioral_patterns.mediator.components.DeleteButton;
import behavioral_patterns.mediator.components.Filter;
import behavioral_patterns.mediator.components.List;
import behavioral_patterns.mediator.components.SaveButton;
import behavioral_patterns.mediator.components.TextBox;
import behavioral_patterns.mediator.components.Title;
import behavioral_patterns.mediator.mediator.Editor;
import behavioral_patterns.mediator.mediator.Mediator;

import javax.swing.*;

/**
 * Demo class. Everything comes together here.
 *
 * https://refactoring.guru/design-patterns/mediator/java/example
 */
public class Demo {
    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}