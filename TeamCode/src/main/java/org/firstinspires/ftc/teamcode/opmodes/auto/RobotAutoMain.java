package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "AutoMain")
public class RobotAutoMain extends LinearOpMode {
    DcMotor motorRight;
    DcMotor motorLeft;
    ElapsedTime timer;



    final double driveTime = 3.5;
    final double drivePower = 0.2;

    @Override
    public void runOpMode()
    {
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorLeft = hardwareMap.dcMotor.get("motorLeft");

        timer = new ElapsedTime();


        waitForStart();


        driveForward(timer);
    }

    private void driveForward(ElapsedTime timer){
        timer.reset();

        while(timer.seconds() < driveTime)
        {
            motorRight.setPower(drivePower);
            motorLeft.setPower(-drivePower);
        }

        timer.reset();

        while(timer.seconds() < driveTime)
        {
            motorRight.setPower(-drivePower);
            motorLeft.setPower(drivePower);
        }

        motorRight.setPower(0);
        motorLeft.setPower(0);
    }
}
