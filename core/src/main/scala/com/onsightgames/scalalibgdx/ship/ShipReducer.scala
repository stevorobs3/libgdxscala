package com.onsightgames.scalalibgdx.ship

import com.onsightgames.scalalibgdx.Reducer
import com.onsightgames.scalalibgdx.events.Event
import com.onsightgames.scalalibgdx.events.KeyboardEventEmitter.{Key, KeyDownEvent, KeyUpEvent}
import com.onsightgames.scalalibgdx.events.LifecycleEventEmitter.Update
import com.onsightgames.scalalibgdx.libgdx.Vector2

object ShipReducer extends Reducer[Ship] {

  override def reduce: PartialFunction[(Ship, Event), Ship] = {
    case (ship, _: Update)               => ship.update()

    case (ship, KeyDownEvent(Key.Left))  => ship.accelerate(Vector2(-1f, 0))
    case (ship, KeyDownEvent(Key.Right)) => ship.accelerate(Vector2(+1f, 0))
    case (ship, KeyDownEvent(Key.Down))  => ship.accelerate(Vector2(0, -1f))
    case (ship, KeyDownEvent(Key.Up))    => ship.accelerate(Vector2(0, +1f))

    case (ship, KeyUpEvent(Key.Left))    => ship.accelerate(Vector2(+1f, 0))
    case (ship, KeyUpEvent(Key.Right))   => ship.accelerate(Vector2(-1f, 0))
    case (ship, KeyUpEvent(Key.Down))    => ship.accelerate(Vector2(0, +1f))
    case (ship, KeyUpEvent(Key.Up))      => ship.accelerate(Vector2(0, -1f))
  }
}