package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.ArmControl;
import org.firstinspires.ftc.teamcode.subsystems.TwoMotorTank;

@TeleOp(name = "TeleopMain")
public class RobotTeleopMain extends OpMode {
    DcMotor motorRight;
    DcMotor motorLeft;;


//    DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
//    DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
//    DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
//    DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");


    DcMotor motorLiftArm;
    //DcMotor motorScoringArm;


    TwoMotorTank driveSystem;
    ArmControl armSystem;

    @Override
    public void init() {
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorLiftArm = hardwareMap.dcMotor.get("motorLiftArm");
        //motorScoringArm = hardwareMap.dcMotor.get("motorScoringArm");

        driveSystem = new TwoMotorTank(motorLeft, motorRight,
                () -> gamepad1.left_stick_y, () -> gamepad1.right_stick_x, () -> gamepad1.b);
        armSystem = new ArmControl(motorLiftArm, /*motorScoringArm,*/
                () -> gamepad1.right_bumper, () -> gamepad1.right_trigger);
                //() -> gamepad1.left_bumper, () -> gamepad1.left_trigger);
    }

    @Override
    public void loop()
    {
        driveSystem.drive();
        armSystem.controlLiftArm();
        // armSystem.controlScoringArm();
    }
}