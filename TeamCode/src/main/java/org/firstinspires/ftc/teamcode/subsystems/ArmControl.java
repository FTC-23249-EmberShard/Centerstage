package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class ArmControl {

    DcMotor motorLiftArm;
    DcMotor motorScoringArm;

    final double liftArmSpeed = 0.5;
    final double liftArmUpSpeed = liftArmSpeed * -1;
    final double liftArmDownSpeed = liftArmSpeed * 2;
    final double scoringArmSpeed = 0.5;
    final double scoringArmUpSpeed = scoringArmSpeed * 1;
    final double scoringArmDownSpeed = scoringArmSpeed * 1;

    private BooleanSupplier rightBumper;
    private DoubleSupplier rightTrigger;

    private BooleanSupplier leftBumper;
    private DoubleSupplier leftTrigger;

    public ArmControl(DcMotor motorLiftArm, /*DcMotor motorScoringArm,*/ BooleanSupplier rightBumper, DoubleSupplier rightTrigger /*,
                      BooleanSupplier leftBumper, DoubleSupplier leftTrigger*/){
        this.motorLiftArm = motorLiftArm;
        // this.motorScoringArm = motorScoringArm;
        this.rightBumper = rightBumper;
        this.rightTrigger = rightTrigger;
        // this.leftBumper = leftBumper;
        // this.leftTrigger = leftTrigger;
    }
    public void controlLiftArm(){
        if(rightBumper.getAsBoolean())
        {
            motorLiftArm.setPower(liftArmUpSpeed);
        }
        else if(rightTrigger.getAsDouble() > 0)
        {
            motorLiftArm.setPower(liftArmDownSpeed);
        }
        else
        {
            motorLiftArm.setPower(0);
        }
    }

//    public void controlScoringArm(){
//        if(leftBumper.getAsBoolean())
//        {
//            motorScoringArm.setPower(scoringArmUpSpeed);
//        }
//        else if(leftTrigger.getAsDouble() > 0)
//        {
//            motorScoringArm.setPower(scoringArmDownSpeed);
//        }
//        else
//        {
//            motorScoringArm.setPower(0);
//        }
//    }
}
