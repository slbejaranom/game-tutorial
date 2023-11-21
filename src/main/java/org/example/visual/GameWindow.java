package org.example.visual;

import javax.swing.JFrame;
import lombok.Getter;
import org.example.config.ApplicationProperties;
import org.example.config.WindowConfig;

@Getter
public class GameWindow extends JFrame {

  private static GameWindow gameWindow;
  private Game game;

  public static GameWindow getGameWindow() {
    if(gameWindow == null) {
      gameWindow = new GameWindow();
    }
    return gameWindow;
  }

  public void setUpGameWindow() {
    this.game = Game.getGame();
    WindowConfig windowConfig = ApplicationProperties.getApplicationProperties().getWindowConfig();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.pack();
    this.add(this.game);
    int width = windowConfig.getWidth();
    int height =  windowConfig.getHeight();
    this.setSize(width, height);
    this.game.setSize(width, height);
    this.setTitle(windowConfig.getTitle());
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setVisible(true);
  }
}
