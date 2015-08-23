package tigertech.zzee;

import java.io.File;

import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import tigertech.zzee.states.Gameplay;

public class Game extends StateBasedGame {
	private static int WIDTH = 1200;
	private static int HEIGHT = 700;
	public Game() {
		super("Zinc Zirconiums Elemental Escape");
	}
	public static int getWidth() {
		return WIDTH;
	}
	public static int getHeight() {
		return HEIGHT;
	}
	public static void main(String[] args) throws SlickException {
		System.setProperty("org.lwjgl.librarypath", new File(new File(System.getProperty("user.dir"), "native"), LWJGLUtil.getPlatformName()).getAbsolutePath());
		System.setProperty("net.java.games.input.librarypath", System.getProperty("org.lwjgl.librarypath"));
		AppGameContainer container = new AppGameContainer(new Game(), WIDTH, HEIGHT, false);
		container.setShowFPS(false);
		container.setVSync(true);
		container.setMaximumLogicUpdateInterval(15);
		container.setMinimumLogicUpdateInterval(15);
		container.setAlwaysRender(true);
		container.start();
	}
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new Gameplay(1));
	}
}
