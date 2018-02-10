package org.team1085.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.networktables.NetworkTableInstance
import edu.wpi.first.wpilibj.DriverStation
import org.team1085.robot.Map
import org.team1085.robot.commands.Logging

class Dashboard : Subsystem () {

  private val station = DriverStation.getInstance()

  private val globalTable = NetworkTableInstance.create()
  private val visionTable = globalTable.getTable("vision")
  private val sensorTable = globalTable.getTable("sensor")
  private val errorsTable = globalTable.getTable("errors")

  private val leftStick = Joystick(Map.leftStickPort)
  private val rightStick = Joystick(Map.rightStickPort)

  override fun initDefaultCommand () = setDefaultCommand(new Logging())

  public fun selectAuto (): String = when (station.getGameSpecificMessage()) {
    "LLL" -> "lll"
    "LLR" -> "llr"
    else -> "other"
  }
}