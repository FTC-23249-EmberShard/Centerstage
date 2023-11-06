package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class ArmControl {

    DcMotor motorArm;

    final double armSpeed = 0.5;
    final double armUpSpeed = armSpeed * -1;
    final double armDownSpeed = armSpeed * 2;

    private BooleanSupplier rightBumper;
    private DoubleSupplier rightTrigger;

    public ArmControl(DcMotor motorArm, BooleanSupplier rightBumper, DoubleSupplier rightTrigger){
        this.motorArm = motorArm;
        this.rightBumper = rightBumper;
        this.rightTrigger = rightTrigger;
    }
    public void controlArm(){
        if(rightBumper.getAsBoolean())
        {
            motorArm.setPower(armUpSpeed);
        }
        else if(rightTrigger.getAsDouble() > 0)
        {
            motorArm.setPower(armDownSpeed);
        }
        else
        {
            motorArm.setPower(0);
        }
    }


}
