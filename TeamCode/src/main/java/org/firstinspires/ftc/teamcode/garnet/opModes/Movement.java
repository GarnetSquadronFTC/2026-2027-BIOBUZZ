package org.firstinspires.ftc.teamcode.garnet.opModes;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.pedro.Constants;

@TeleOp (name = "do you have your drivers license?")
public class Movement extends OpMode {
    private Follower follower;

    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
    }

    @Override
    public void loop() {
        if(follower == null){
            telemetry.addData("null", true);

        }else{
            telemetry.addData("null", false);
        }
        telemetry.update();

        double forward = -gamepad1.left_stick_y;
        double lateral = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;

        follower.manual(forward, lateral, turn);
//        follower.manual(1, 1, 1);

        follower.update();
    }
}
