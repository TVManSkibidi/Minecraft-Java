from ursina import *


class Game(Ursina):
  def __init__(self):
    super().__init__()
    window.fullscreen = True
    self.load_game()

  def load_game(self):
    pass

  def input(self, key):
    super().input(key)


if __name__ == '__main__':
  game = Game()
  game.run()
