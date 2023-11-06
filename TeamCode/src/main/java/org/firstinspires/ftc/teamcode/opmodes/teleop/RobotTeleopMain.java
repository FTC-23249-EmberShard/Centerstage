package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.ArmControl;
import org.firstinspires.ftc.teamcode.opmodes.testing.TwoMotorTank;

@TeleOp(name = "TeleopMain2")
public class RobotTeleopMain extends OpMode {
    DcMotor motorRight = hardwareMap.dcMotor.get("motorRight");
    DcMotor motorLeft = hardwareMap.dcMotor.get("motorLeft");


    DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
    DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
    DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
    DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");


    DcMotor motorArm = hardwareMap.dcMotor.get("motorArm");


    TwoMotorTank driveSystem;
    ArmControl armSystem;

    @Override
    public void init() {
        driveSystem = new TwoMotorTank(motorLeft, motorRight);
        armSystem = new ArmControl(motorArm,
                () -> gamepad1.right_bumper, () -> gamepad1.right_trigger);
    }

    @Override
    public void loop()
    {
        driveSystem.drive();
        armSystem.controlArm();
    }
}