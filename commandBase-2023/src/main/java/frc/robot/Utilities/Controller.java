package frc.robot.Utilities;

import java.util.HashMap;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;

public class Controller {
    ControllerType controllerType;

    CommandXboxController xboxController;
    CommandPS4Controller ps5Controller;

    HashMap<Buttons, Trigger> XboxButtonMap = new HashMap<Buttons, Trigger>();
    HashMap<Buttons, Trigger> PS5ButtonMap = new HashMap<Buttons, Trigger>();
    HashMap<Axes, DoubleSupplier> XboxAxesMap = new HashMap<Axes, DoubleSupplier>();
    HashMap<Axes, DoubleSupplier> PS5AxesMap = new HashMap<Axes, DoubleSupplier>();

    public Controller(ControllerType controllerType, int port) {
        this.controllerType = controllerType;

        xboxController = new CommandXboxController(port);
        ps5Controller = new CommandPS4Controller(port);

        XboxButtonMap.put(Buttons.leftBumper, xboxController.leftBumper());
        XboxButtonMap.put(Buttons.rightBumper, xboxController.rightBumper());
        XboxButtonMap.put(Buttons.leftStick, xboxController.leftStick());
        XboxButtonMap.put(Buttons.rightStick, xboxController.rightStick());
        XboxButtonMap.put(Buttons.triangleOrY, xboxController.y());
        XboxButtonMap.put(Buttons.squareOrX, xboxController.x());
        XboxButtonMap.put(Buttons.crossOrA,xboxController.a());
        XboxButtonMap.put(Buttons.circleOrB, xboxController.b());
        XboxButtonMap.put(Buttons.leftTrigger, xboxController.leftTrigger(Constants.TRIGGER_DEADZONE));
        XboxButtonMap.put(Buttons.rightTrigger, xboxController.rightTrigger(Constants.TRIGGER_DEADZONE));
        XboxButtonMap.put(Buttons.povUp, xboxController.povUp());
        XboxButtonMap.put(Buttons.povDown, xboxController.povDown());
        XboxButtonMap.put(Buttons.povRight, xboxController.povRight());
        XboxButtonMap.put(Buttons.povLeft, xboxController.povLeft());
        XboxButtonMap.put(Buttons.optionsOrStart, xboxController.start());

        XboxAxesMap.put(Axes.leftX, () -> xboxController.getLeftX());
        XboxAxesMap.put(Axes.rightX, () ->  xboxController.getRightX());
        XboxAxesMap.put(Axes.leftY, () ->  xboxController.getLeftY());
        XboxAxesMap.put(Axes.rightY, () ->  xboxController.getRightY());
        XboxAxesMap.put(Axes.leftTrigger, () ->  xboxController.getLeftTriggerAxis());
        XboxAxesMap.put(Axes.rightTrigger, () ->  xboxController.getRightTriggerAxis());

        PS5ButtonMap.put(Buttons.leftBumper, ps5Controller.L1());
        PS5ButtonMap.put(Buttons.rightBumper, ps5Controller.R1());
        PS5ButtonMap.put(Buttons.leftStick, ps5Controller.L3());
        PS5ButtonMap.put(Buttons.rightStick, ps5Controller.R3());
        PS5ButtonMap.put(Buttons.triangleOrY, ps5Controller.triangle());
        PS5ButtonMap.put(Buttons.squareOrX, ps5Controller.square());
        PS5ButtonMap.put(Buttons.crossOrA, ps5Controller.cross());
        PS5ButtonMap.put(Buttons.circleOrB, ps5Controller.circle());
        PS5ButtonMap.put(Buttons.leftTrigger, ps5Controller.axisGreaterThan(PS4Controller.Axis.kL2.value, -0.85));
        PS5ButtonMap.put(Buttons.rightTrigger, ps5Controller.axisGreaterThan(PS4Controller.Axis.kR2.value, -0.85));
        PS5ButtonMap.put(Buttons.povUp, ps5Controller.povUp());
        PS5ButtonMap.put(Buttons.povDown, ps5Controller.povDown());
        PS5ButtonMap.put(Buttons.povRight, ps5Controller.povRight());
        PS5ButtonMap.put(Buttons.povLeft, ps5Controller.povLeft());
        PS5ButtonMap.put(Buttons.optionsOrStart, ps5Controller.options());
        
        PS5AxesMap.put(Axes.leftX, () ->  ps5Controller.getLeftX());
        PS5AxesMap.put(Axes.rightX, () ->  ps5Controller.getRightX());
        PS5AxesMap.put(Axes.leftY, () ->  ps5Controller.getLeftY());
        PS5AxesMap.put(Axes.rightY, () ->  ps5Controller.getRightY());
        PS5AxesMap.put(Axes.leftTrigger, () ->  ps5Controller.getL2Axis());
        PS5AxesMap.put(Axes.rightTrigger, () ->  ps5Controller.getR2Axis());
    }

    public Trigger getButton(Buttons button) {
        return controllerType == ControllerType.XboxController ? 
            XboxButtonMap.get(button) : PS5ButtonMap.get(button);
    }

    public DoubleSupplier getAxis(Axes axis) {
        return controllerType == ControllerType.XboxController ?
            XboxAxesMap.get(axis) : PS5AxesMap.get(axis);
    }

    public enum Buttons {
        leftBumper,
        rightBumper,
        leftStick,
        rightStick,
        triangleOrY,
        squareOrX,
        crossOrA,
        circleOrB,
        leftTrigger,
        rightTrigger,
        povUp,
        povDown,
        povRight,
        povLeft,
        optionsOrStart
    }

    public enum Axes {
        leftX,
        rightX,
        leftY,
        rightY,
        leftTrigger,
        rightTrigger
    }

    public enum ControllerType {
        XboxController,
        PS5Controller
    }
}
