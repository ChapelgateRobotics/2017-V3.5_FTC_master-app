package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by kfrankfurth on 11/29/2017.
 */
@TeleOp
public class MyFirstJavaOpMode extends LinearOpMode {
    private Gyroscope imu;
    private DcMotor motorTest;
    private DistanceSensor digitalTouch;
    private DistanceSensor sensorColorRange;
    private Servo servoTest;

    @Override
    public void runOpMode()
    {
     imu = hardwareMap.get(Gyroscope.class, "imu");
     motorTest = hardwareMap.get(DcMotor.class, "motorTest");
     digitalTouch = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
     servoTest =hardwareMap.get(Servo.class, "servoTest");

     telemetry.addData("Status", "Initialized");
     telemetry.update();
     //Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        double tgtPower=0;
        while (opModeIsActive())
        {
            //Y value of a joystick ranges from -1, when a joystick is in its topmost position,
            //to +1, when a joystick is in its bottommost position.
            tgtPower= -this.gamepad1.left_stick_y;
            motorTest.setPower(tgtPower);
            telemetry.addData("Taget Power", tgtPower);
            telemetry.addData("MotorPower", motorTest.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
