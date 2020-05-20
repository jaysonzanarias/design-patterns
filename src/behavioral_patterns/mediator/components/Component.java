package behavioral_patterns.mediator.components;

import behavioral_patterns.mediator.mediator.Mediator;

/**
 * Common component interface.
 */
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
