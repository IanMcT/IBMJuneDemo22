// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.REVPhysicsSim;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
public class ExampleSubsystem extends SubsystemBase {
  //Class variables
  private CANSparkMax motor;
  private static final int motorID=10;//CAN id set in Rev Hardware Client
  private double speed; 
  private double voltage;

  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    motor = new CANSparkMax(motorID, MotorType.kBrushless);
    REVPhysicsSim.getInstance().addSparkMax(motor, DCMotor.getNEO(1));
    speed = 0.0;
    voltage = 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    motor.set(speed);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    motor.setVoltage(voltage);
    REVPhysicsSim.getInstance().run();
  }

  //sets the motor speed to 50%.  Voltage is set to speed.
  public void setMotorSpeed(){
    speed = 0.5;
    voltage = speed;
  }

  //Speed and voltage set to 0.
  public void stopMotor(){
    speed = 0.0;
    voltage = 0;
  }
}
