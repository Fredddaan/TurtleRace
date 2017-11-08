/*  Jacob Johnsson 2017-11-08
    Programmering Grundkurs Lab 09 */
package turtlerace

import graphics._
import cslib.window._

class TurtleRace(val millisPerStep: Int = 10) {
  def race(
    turtles: Seq[RaceTurtle],
    rw: RaceWindow,
    title: String
  ): Seq[RaceTurtle] = {
    rw.draw()

    // Skapa en lista fom representerar vinnarna i korrekt ordning 0 - n.
    val winners = new Array[RaceTurtle](turtles.length)

    // 1. Sätt alla turtles på respektive startposition
    for (t <- turtles.indices) {
      turtles(t) jumpTo Point(rw.startX, rw.startY(t))
    }

    // 2. Sätt en variabel som håller koll på hur många som gått i mål.
    var iMål = 0

    // 3. While(iMål < antalet tävlande)
    while (iMål < turtles.length) {

      // 3.1 Alla som INTE vunnit tar ett steg
      for (t <- iMål until turtles.length) {
        turtles(t).raceStep()

        // 3.2 Om (någon gick i mål)
        if (turtles(t).x > rw.endX){

          // Flytta den turtlen till listan av vinnare i korrekt ordning
          winners(iMål) = turtles(t)

          // Inkrementera antalet som gått i mål
          iMål += 1
        }
        Thread.sleep(millisPerStep)
      }
    }

    rw.writeTitle("TurtleRace MIGHT BE READY")
    // 4. Returnera listan av vinnare
    winners.toSeq
  }

}
