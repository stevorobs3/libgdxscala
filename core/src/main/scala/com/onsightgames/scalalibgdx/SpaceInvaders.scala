package com.onsightgames.scalalibgdx

import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.{Gdx, Screen}

class SpaceInvaders extends Screen
  with HasLogger {
  override def hide(): Unit = {
    info("Hiding")
  }
  override def resize(width: Int, height: Int): Unit = {
    info(s"Resizing to $width*$height")
  }
  override def dispose(): Unit = {
    info("Disposing")
  }
  override def pause(): Unit = {
    info("Pausing")
  }
  override def show(): Unit = {
    info("Showing")
  }
  override def resume(): Unit = {
    info("Resuming")
  }

  override def render(delta: Float): Unit = {
    update(delta)
    render()
  }

  lazy val batch  = new SpriteBatch

  val alienFleet = new AlienFleet(Level.One.alienFleet)
  val ship       = Ship.atStartingPosition

  override val LogId: String = "SpaceInvaders"

  Gdx.input.setInputProcessor(new KeyboardAdapter(ship))

  private def update(delta : Float) : Unit = {
    alienFleet.update(delta)
    ship.update()
  }

  private def render() : Unit = {
    Gdx.gl.glClearColor(0,0,0,1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    batch.begin()
    renderEntities(batch)
    batch.end()
  }

  private def renderEntities(batch : SpriteBatch) : Unit = {
    alienFleet.render(batch)
    ship.render(batch)
  }
}