package turtlerace

trait Dizzy extends RaceTurtle {
  val dizziness:Int = scala.util.Random.nextInt(5) + 1
  override def raceStep(): Unit = {
    turnRight(-direction)
    if(scala.util.Random.nextBoolean()){
      turnLeft(dizziness * 10)
      forward(scala.util.Random.nextInt(defaultStep))
    }else{
      turnRight(dizziness * 10)
      forward(scala.util.Random.nextInt(defaultStep))
    }
  }
  override def toString: String = s"Dizzy turtle ($dizziness): #$nbr name: $name"
}