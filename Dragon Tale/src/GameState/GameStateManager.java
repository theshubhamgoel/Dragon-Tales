package GameState;

import java.util.ArrayList;

public class GameStateManager {

	private ArrayList<GameState> gamestates;
	private int currentState;

	public static final int MENUSTATE = 0;
	public static final int LEVEL1STATE = 1;

	public GameStateManager() {
		gamestates = new ArrayList<GameState>();
		currentState = MENUSTATE;
		gamestates.add(new MenuState(this));
		gamestates.add(new Level1State(this));
	}
	
	public void setState(int state){
		currentState = state;
		gamestates.get(currentState).init();
	}
	
	public void update(){
		gamestates.get(currentState).update();
	}
	
	public void draw(java.awt.Graphics2D g){
		gamestates.get(currentState).draw(g);
	}
	
	public void keyPressed(int k) {
		gamestates.get(currentState).keyPressed(k);
	}

	public void keyReleased(int k) {
		gamestates.get(currentState).keyReleased(k);
	}
}
