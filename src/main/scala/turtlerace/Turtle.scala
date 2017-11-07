package graphics

import cslib.window.SimpleWindow

class Turtle( val window: SimpleWindow,
              val initPosition: Point = new Point(0.0,0.0),
              val initDirection: Double = 0,
              val initIsPenDown: Boolean = true) {

  private var position = initPosition;
  private var _direction = initDirection;
  private var _penDown = initIsPenDown;

  override def toString = s"$position, $direction";

  def x: Int = { position.x.round.toInt }

  def y: Int = { position.y.round.toInt }

  def direction: Double = { _direction }

  def home(): Turtle = {
    position = initPosition;
    _direction = initDirection
    _penDown = initIsPenDown
    this
  }
  //def isPenDown: Boolean = { _penDown }

  def jumpTo(newPosition: Point): Turtle = {
    position = newPosition
    this
  }

  def forward(distance: Double): Turtle = {
    var toPoint = position + Point.polar(distance, _direction.toRadians.toDouble).negY

    if (_penDown){
      window.moveTo(position.x.round.toInt, position.y.round.toInt)
      window.lineTo(toPoint.x.toInt, toPoint.y.toInt)
    }
    position = toPoint
    this
  }

  def turnLeft(degrees: Double): Turtle = {
    _direction = (_direction + degrees) % 360
    this
  }

  def turnRight(degrees: Double): Turtle = {
    _direction = (_direction - degrees) % 360
    this
  }

  def turnNorth(): Turtle = {
    _direction = 90;
    this
  }

  def penDown(): Turtle = {
    _penDown = true;
    this
  }

  def penUp(): Turtle = {
    _penDown = false;
    this
  }
}
