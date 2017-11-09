package turtlerace

trait MoleTurtle extends RaceTurtle {
  val moleprobability = scala.util.Random.nextInt(5)+3
  val moleskala = moleprobability -3
 
 
 override def raceStep(): Unit = {
    if(scala.util.Random.nextInt(10)+1 > moleprobability){
      penDown()
      forward(scala.util.Random.nextInt(defaultStep))
    }
    
    else{
      penUp()
      forward(scala.util.Random.nextInt(defaultStep/2)) //det skall vara trögare att ta sig fram under jorden
    }
    
  }

  
  override def toString: String = s"Mole turtle ($moleskala): #$nbr name: $name"
}
