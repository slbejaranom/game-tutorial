package org.example.visual;

import java.awt.Canvas;
import lombok.Getter;

@Getter
public class Game extends Canvas implements Runnable {

  private static Game game;
  private RenderizableObject2D renderizableObject2D;
  private Game() {
    super();
    run();
  }

  public static Game getGame() {
    if(game == null) {
      game = new Game();
    }
    return game;
  }

  @Override
  public void run() {
    System.out.println("Running...");
  }
}
