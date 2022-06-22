// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
public class ExampleSubsystem extends SubsystemBase {
  private CANSparkMax motor;
  private static final int motorID=10;//CAN id set in Rev Hardware Client
  private double speed; 
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    motor = new CANSparkMax(motorID, MotorType.kBrushless);
    speed = 0.0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    motor.set(speed);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void setMotorSpeed(){
    speed = 0.5;
  }

  public void stopMotor(){
    speed = 0.0;
  }
}
