package org.firstinspires.ftc.teamcode.garnet.opModes;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Localizer;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import static com.pedropathing.api.Paths.*;
import com.pedropathing.paths.Path;
import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.pedro.Constants;

@Autonomous
public class PedroTheGoat extends OpMode {
    private Follower follower;
    private final PoseFactory p = PoseFactory.degrees();
    private final Pose startPose = p.of(24.0, 24.0, 0.0);
    private final Pose endPose = p.of(48.0, 48.0, 90.0);

    private Path test() {
        return line(startPose, endPose).linear(startPose, endPose);
    }

    @Override
    public void init(){
        Scheduler.reset();

        follower = Constants.create(hardwareMap);
        follower.setPose(startPose);
    }
    @Override
    public void start() {
        schedule(follow(follower, test()));
    }

    @Override
    public void loop() {
        follower.update();
        Scheduler.execute();
    }
}
