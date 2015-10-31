package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import TileMap.Background;

public class MenuState extends GameState {

	private Background bg;

	private int currentChoice = 0;
	private String[] option = { "Start", "Help", "Quit" };

	private Color titleColor;
	private Font titleFont, font;

	public MenuState(GameStateManager gameStateManager) {
		this.gsm = gameStateManager;

		try {
			bg = new Background("/Backgrounds/menubg.gif", 1);
			bg.setVector(-0.1, 0);

			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);

			font = new Font("Arial", Font.PLAIN, 12);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void init() {

	}

	@Override
	public void update() {
		bg.update();
	}

	@Override
	public void draw(Graphics2D g) {
		// draw bg
		bg.draw(g);

		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Dragon Tale", 80, 70);

		// draw menu option
		g.setFont(font);
		for (int i = 0; i < option.length; i++) {
			if (i == currentChoice) {
				g.setColor(Color.BLACK);
			} else {
				g.setColor(Color.RED);
			}
			g.drawString(option[i], 145, 145 + i * 15);
		}
	}

	private void select() {
		if (currentChoice == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE);
		}

		if (currentChoice == 1) {
			// help
		}

		if (currentChoice == 2) {
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {
			select();
		}

		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			if (currentChoice == -1)
				currentChoice = option.length - 1;
		}

		if (k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if (currentChoice == option.length)
				currentChoice = 0;
		}
	}

	@Override
	public void keyReleased(int k) {

	}

}
