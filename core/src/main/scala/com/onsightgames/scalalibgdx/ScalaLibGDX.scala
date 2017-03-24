package com.onsightgames.scalalibgdx

import com.badlogic.gdx.Game
import com.onsightgames.scalalibgdx.spaceinvaders.store.SpaceInvadersStore

object ScalaLibGDX {
  val Width = 600
  val Height = 800
  val Title = "ScalaLibGDX"
}

class ScalaLibGDX extends Game
 with Logging {
  val LogId = "ScalaLibGDX"

  override def create(): Unit = {
    setScreen(SpaceInvadersStore.coreGameEvents)
  }
}