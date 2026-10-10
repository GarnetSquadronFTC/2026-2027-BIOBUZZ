package org.firstinspires.ftc.teamcode.garnet.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.ftccommon.internal.manualcontrol.parameters.SetMotorEnableParameters;

public class GarnetMotor {
    DcMotorEx motor;






    public GarnetMotor(HardwareMap hardwareMap, String name){
        motor = hardwareMap.get(DcMotorEx.class, name);
    }

    public void setPower(Double power){
        motor.setPower(power);
    }


    public void setBrakeOn0(boolean brakeOn0) {
        motor.setZeroPowerBehavior(brakeOn0 ? DcMotor.ZeroPowerBehavior.BRAKE : DcMotor.ZeroPowerBehavior.FLOAT);
    }
}
