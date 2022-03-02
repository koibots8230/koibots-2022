import edu.wpi.first.wpilibj.Timer;

public class AutoPsuedoCode{
  //AUTONOMOUS PHASE
  //DRIVE TO POSITION
  RobotTimer = Timer();

  RobotTimer.start() //starts a timer at 0 seconds
    while(isAutonomous() && isEnabled()) //run when autonomous is live and you are enabled
    {
        if(RobotTimer.get() < timeToGetToPosition) //time is a double in terms of seconds
        {
            driveTrain.set(speed); //move robot at this speed with/without curve
        }
        //Timer.delay(0.005); //does nothing for 5 seconds but helps refresh motors in loop
    }
    RobotTimer.stop() //stops timer

    //SHOOT WHEN AT POSITION
    while(isAutonomous() && isEnabled()) //run when autonomous is live and you are enabled
    {
        if(RobotTimer.get() < avgTimeToShoot) //time is a double in terms of seconds
        {
                shooterMotor.set(shooterSpeed);; //move robot at this speed with/without curve
        }
        //Timer.delay(0.005); //does nothing for 5 seconds but helps refresh motors in loop
    }
    //move out of tarmac
    RobotTimer.stop()

    RobotTimer.start() //starts a timer at 0 seconds
      while(isAutonomous() && isEnabled()) //run when autonomous is Cive and you are enabled
      {
          if(RobotTimer.get() < timeToGetToOutOfTarmac) //time is a double in terms of seconds
          {
              driveTrain.set(speed); //move robot at this speed with/without curve
          }
          //Timer.delay(0.005); //does nothing for 5 seconds but helps refresh motors in loop
      }
    RobotTimer.stop() //stops timer


}
