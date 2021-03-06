package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
/**
 * Autonomous made from tutorial
 */

@Autonomous(name="Autonomous template Linear OpMode", group="Linear OpMode")  // @Autonomous(...) is the other common choice
//@Disabled
public class AutonomousTutorialOpModeLinear extends LinearOpMode {

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    // Declare motors
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;

    private Servo armServo;

    double DRIVE_POWER = 1.0;

    @Override
    public void runOpMode() throws InterruptedException{
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize motors
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");

        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        // Initialize motors
        armServo = hardwareMap.servo.get("armServo");

        armServo.setPosition(0.8);


        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        //Go Robot Go

        DriveForwardTime(DRIVE_POWER, 4000);
        //Thread.sleep(4000);

        //turn left
        TurnLeft(DRIVE_POWER);
       /*
        leftMotor.setPower(-1);
        rightMotor.setPower(1);
       */
        Thread.sleep(500);
        DriveForwardTime(DRIVE_POWER, 4000);
        //Thread.sleep(4000);

        //turn right
        TurnRight(DRIVE_POWER);
        /*
         leftMotor.setPower(1);
        rightMotor.setPower(-1);
        */
        Thread.sleep(500);
        DriveForwardTime(DRIVE_POWER, 4000);
        //Thread.sleep(4000);

        //stop
        /*
        old way to stop
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        */
        stopDriving();

        // Complete objective

        armServo.setPosition(0.2);


    }


    //Drive method
    public void DriveForward(double power)
    {
        leftMotor.setPower(power);
        rightMotor.setPower(power);
    }
    // add Drive method and Time method
    public void DriveForwardTime(double power, long time) throws InterruptedException
    {
        DriveForward(power);
        Thread.sleep(time);
    }

    //Stop method
    public void stopDriving()
    {
        DriveForward(0);
    }
    //TurnLeft method
    public void TurnLeft(double power)
    {
        leftMotor.setPower(-power);
        rightMotor.setPower(power);
    }
    //TurnRight method
    public void  TurnRight(double power)
    {
        TurnLeft(-power);
    }

}
