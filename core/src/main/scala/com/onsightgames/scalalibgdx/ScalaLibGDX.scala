package com.onsightgames.scalalibgdx

import akka.typed._
import akka.typed.scaladsl.Actor._
import com.badlogic.gdx.Game
import com.onsightgames.scalalibgdx.akkatyped.{Alien, AlienView}
import com.onsightgames.scalalibgdx.events.LifecycleManager

object ScalaLibGDX {
  val Width = 600
  val Height = 800
  val Title = "ScalaLibGDX"

}

class ScalaLibGDX extends Game
 with HasLogger {
  val LogId = "ScalaLibGDX"

  lazy val main: Behavior[akka.NotUsed] =
    Stateful(
      behavior = (_, _) ⇒ Unhandled,
      signal = { (ctx, sig) ⇒
        sig match {
          case PreStart ⇒
            val updaterSys = ActorSystem("updater", LifecycleManager.updater())
            implicit val context = ctx
            implicit val lifeCycleRef = ctx.spawn(LifecycleManager.create(updaterSys), "registry")

            val alien = new Alien(Alien.AlienData(1))
            val _ = new AlienView(alien)
            val screen = new LifecycleManager(updaterSys)
            setScreen(screen)

            info("Starting")
            //SpaceInvaders.start(ctx, lifeCycleRef)
            Same
          case _ ⇒
            Unhandled
        }
      })

  override def create(): Unit = {
    val _ = ActorSystem("SpaceInvadersGame", main)
  }
}