package org.example.visual;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class RenderizableObject2D {
  public final int width;
  public final int height;
  public int[][] pixels;

  public RenderizableObject2D(int width, int height){
    this.height = height;
    this.width = width;
    this.pixels = new int[width][height];
  }

  public void draw(Game game, int xOffset, int yOffset) {
    Image img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    game.getGraphics().drawImage(img, xOffset, yOffset, game);
  }
}
