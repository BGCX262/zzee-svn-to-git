package tigertech.zzee.utils;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class InputUtils {
	
	public boolean invActive = false;
	public boolean craftActive = false;
	public boolean equipActive = false;
	public boolean mapActive = false;
	public boolean settingsActive = false;
	public boolean EXTRAactive = false;

	public void stateChange(int state, int greaterX, int lessX, int greaterY, int lessY, GameContainer gc, StateBasedGame sbg) {
		Input input = gc.getInput();
		int posx = Mouse.getX();
		int posy = Math.abs(Mouse.getY()-sbg.getContainer().getHeight()) - 1;
		
		if((posx>=greaterX) && (posx<=lessX) && (posy>=greaterY) && (posy<=lessY)){
			if(input.isMousePressed(0)){
				sbg.enterState(state);
			}}}
	
	public void menuChange(int menuNum, int greaterX, int lessX, int greaterY, int lessY, GameContainer gc, StateBasedGame sbg){
		Input input = gc.getInput();
		int posx = Mouse.getX();
		int posy = Math.abs(Mouse.getY()-sbg.getContainer().getHeight()) - 1;
		
		if((posx>=greaterX) && (posx<=lessX) && (posy>=greaterY) && (posy<=lessY)){
				switch(menuNum){
				
				case 1: if(input.isMousePressed(0)){invActive = !invActive; craftActive = false; equipActive = false; mapActive = false; settingsActive = false; EXTRAactive = false;} break;
				case 2: if(input.isMousePressed(0)){craftActive = !craftActive; invActive = false; equipActive = false; mapActive = false; settingsActive = false; EXTRAactive = false;} break;
				case 3: if(input.isMousePressed(0)){equipActive = !equipActive; craftActive = false; invActive = false; mapActive = false; settingsActive = false; EXTRAactive = false;} break;
				case 4: if(input.isMousePressed(0)){mapActive = !mapActive; craftActive = false; equipActive = false; invActive = false; settingsActive = false; EXTRAactive = false;} break;
				case 5: if(input.isMousePressed(0)){settingsActive = !settingsActive; craftActive = false; equipActive = false; mapActive = false; invActive = false; EXTRAactive = false;} break;
				case 6: if(input.isMousePressed(0)){EXTRAactive = !EXTRAactive; craftActive = false; equipActive = false; mapActive = false; settingsActive = false; invActive = false;} break;
				default: System.out.println("ERROR: UNKNOWN CASE INPUT FOR MENU(S)");
			}}}
	
}
