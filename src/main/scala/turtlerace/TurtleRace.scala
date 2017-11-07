package turtlerace

import graphics.Turtle
import cslib.window._

class TurtleRace(val millisPerStep: Int = 5) {
  def race(
    turtles: Seq[RaceTurtle],
    rw: RaceWindow,
    title: String
  ): Seq[RaceTurtle] = {

    /*  1. Sätt alla turtle på respektive startposition
        2. while(någon inte vunnit)
           Alla som INTE vinnut tar ett steg
           Om (någon gick i mål
              flytta de nturtlen till en Seq[] som representerar vinnarna i korrekt ordning
     */
    val winners = Array.fill(8)[RaceTurtle]
    val winnerIndex = 0

    var i = 0
    for (t <- turtles.indices)
      turtles(t).jumpTo(graphics.Point(rw.startY(i), rw.startY(i)))

    while (true) {
      var t = 0
      for (t <- turtles.indices) {

        turtles(t).forward(1.0)
        if (turtles(t).x > rw.endX)
          winners(winnerIndex) = turtles(t)
        i += 1
      }
    }


    rw.writeTitle("TurtleRace NOT READY")
    rw.draw()
    Seq()
  }

}
