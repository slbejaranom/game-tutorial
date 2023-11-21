package org.example.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class WindowConfig {

  private final int width;
  private final int height;
  private final String title;
}
