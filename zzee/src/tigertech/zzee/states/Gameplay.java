package tigertech.zzee.states;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import tigertech.zzee.utils.InputUtils;


public class Gameplay extends BasicGameState {
		
		//Integer
	int posx = 0;
	int posy = 0;
	
		//Images
	Image img_masterhud;
	Image img_inventory_button;
	Image img_crafting_button;
	Image img_equipment_button;
	Image img_map_button;
	Image img_settings_button;
	Image img_pause_button;
	
	Image img_inventory;
	Image img_crafting;
	Image img_equipment;
	Image img_map;
	Image img_settings;
	Image img_pause;
	
	String mouse = "No input yet.";
	
	InputUtils iu = new InputUtils();
	
	private int stateID = -1;
	public Gameplay(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		img_masterhud = new Image("res/master_hud.png");
		img_inventory_button = new Image("res/test_icon.png");
		img_crafting_button = new Image("res/test_icon.png");
		img_equipment_button = new Image("res/test_icon.png");
		img_map_button = new Image("res/test_icon.png");
		img_settings_button = new Image("res/test_icon.png");
		img_pause_button = new Image("res/test_icon.png");
		
		img_inventory = new Image("res/test_menu.png");
		img_crafting = new Image("res/test_menu.png");
		img_equipment = new Image("res/test_menu.png");
		img_map = new Image("res/test_menu.png");
		img_settings = new Image("res/test_menu.png");
		img_pause = new Image("res/test_menu.png"); // This is actually referred to as the EXTRAactive.
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		img_masterhud.draw(0, 0);
		img_inventory_button.draw(1005, 550);
		img_crafting_button.draw(1070, 550);
		img_equipment_button.draw(1135, 550);
		img_map_button.draw(1005, 615);
		img_settings_button.draw(1070, 615);
		img_pause_button.draw(1135, 615);
		
		if(iu.invActive){img_inventory.draw(5, 5);}
		if(iu.craftActive){img_crafting.draw(5, 5);}
		if(iu.equipActive){img_equipment.draw(5, 5);}
		if(iu.mapActive){img_map.draw(5, 5);}
		if(iu.settingsActive){img_settings.draw(5, 5);}
		if(iu.EXTRAactive){img_pause.draw(5, 5);}
		
		g.drawString(mouse, 10, 10); /////////REMOVE UPON FINAL RELEASE/////////////
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		iu.menuChange(1, 1005, 1067, 550, 612, gc, sbg); //Inventory Menu
		iu.menuChange(2, 1070, 1132, 550, 612, gc, sbg); //Crafting Menu
		iu.menuChange(3, 1135, 1197, 550, 612, gc, sbg); //Equipment Menu
		iu.menuChange(4, 1005, 1067, 615, 675, gc, sbg); // Map Menu
		iu.menuChange(5, 1070, 1132, 615, 675, gc, sbg); // Settings Menu
		iu.menuChange(6, 1135, 1197, 615, 675, gc, sbg); // Pause Menu
		
		mouseGetter(gc, sbg);
	}

	@Override
	public int getID() {
		return stateID;
	}
	
	public void mouseGetter(GameContainer gc, StateBasedGame sbg) throws SlickException{
		//Gets Mouse Position
	int mouseX = Mouse.getX();
	int mouseY = Math.abs(Mouse.getY()-sbg.getContainer().getHeight()) - 1; //Make mouse coordinates 0,0 at top left
	posx = mouseX;
	posy = mouseY;
	mouse = "X:" + mouseX + " Y:" + mouseY;
		}
	
	}
