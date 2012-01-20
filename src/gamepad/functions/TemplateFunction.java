
package gamepad.functions;

import gamepad.common.AbstractComponentFunction;
import net.java.games.input.Component;


public class TemplateFunction extends AbstractComponentFunction {

    @Override
    public String evaluateFunction() {
        String valueString;
        float readValue = mComponent.getPollData();


        //Create your custom function here
        float calculatedValue = readValue * 100;
        valueString = Float.toString(calculatedValue);


        return valueString;
    }

    @Override
    public void setComponent(Component c) {
        this.mComponent = c;
    }

}
