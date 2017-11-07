package graphics

case class Point(val x: Double = 0, val y: Double = 0) {
  val r = math.hypot(x, y);
  val theta = math.atan2(x, y);
  def negY: Point = new Point(x, -y)
  def +(p: Point) = new Point(x + p.x, y + p.y)
  override def toString = s"$x, $y";
}
object Point {
  def polar(r: Double, theta: Double) = new Point(
    math.cos(theta) * r, math.sin(theta) * r )
}
