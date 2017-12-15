package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

/**
 * Created by homefrankfurth on 2/21/17.
 */

@TeleOp(name="simpleDriveOp", group = "SimpleBot")
//@Disabled
/**
 * Created by homefrankfurth on 5/30/17.
 */

public class simpleDriveOpLinear extends LinearOpMode {
    DcMotor backLeft, frontLeft, backRight, frontRight;
    HardwareSimpleBot robot           = new HardwareSimpleBot();
    public void runOpMode(){


        robot.init(HardwareMap);

            backLeft = hardwareMap.dcMotor.get("backLeft");
            frontLeft = hardwareMap.dcMotor.get("frontLeft");
            backRight = hardwareMap.dcMotor.get("backRight");
            frontRight = hardwareMap.dcMotor.get("frontRight");

            backLeft.setDirection(DcMotor.Direction.FORWARD);
            frontLeft.setDirection(DcMotor.Direction.FORWARD);
            backRight.setDirection(DcMotor.Direction.REVERSE);
            frontRight.setDirection(DcMotor.Direction.REVERSE);




    }






}
