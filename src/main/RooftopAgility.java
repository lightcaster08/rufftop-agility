package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;

import javax.imageio.ImageIO;

import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import data.Data;
import framework.Node;
import tasks.*;
import api.*;
import gui.GUI;


@ScriptManifest(author = "iMKitty", info = "RooftopAgility", name ="Rufftop Agility", version = 1.0, logo = "https://i.gyazo.com/9cec295dd78568b839c51908fd48c185.png")
public class RooftopAgility extends Script {
	public static Data data;
	private Timer timer;
	private Mouse m;
	private GUI gui;
	int aXP, axph;
	public int[] Worlds = {302, 303, 304, 305, 306, 309, 310, 311,
			312, 313, 314, 317, 318, 319, 320, 322, 327, 328, 329, 330, 333, 334, 
			336, 338, 341, 342, 343, 344, 346, 350, 352, 353, 354, 357, 358,
			359, 360, 362, 366, 365, 367, 368, 369, 370, 374, 375, 376, 377, 378,
			386};
		
	private final Image bg = getImage("https://i.gyazo.com/3c6259de241153a56602f5c25fa3d858.png");
	
	private Image getImage(String url){
	    try {
	      return ImageIO.read(new URL(url));
	    } catch (IOException e) {}
	    return null;
	  }
	
	public void onStart() throws InterruptedException {
		experienceTracker.start(Skill.AGILITY);
		timer = new Timer(System.currentTimeMillis());
		m = new Mouse(this);
		gui = new GUI();
		while (gui.running) {
			sleep(10);
		}

		if (checkIfMember()) {
			data.setLapsBeforeBreak((Script.random(skills.getStatic(Skill.AGILITY), (skills.getStatic(Skill.AGILITY) + Script.random(5, 15))) / 2));
			data.initializeCourse();
			setCameraAngles();
		}
	}
	
	public boolean checkIfMember() {
		for (int i = 0; i < Worlds.length; i++) {
			if (worlds.getCurrentWorld() == Worlds[i]) {
				return true;
			}
		}
		log("Not on member world, stopping");
		stop(false);
		return false;
	}
	
	public void setCameraAngles() {
		switch(data.getCourse()) {
		default:
			break;
		case "varrock":
			data.setCamera(25, 50);
			break;
		case "canifis":
			data.setCamera(179, 192);
			break;
		case "seers":
			data.setCamera(210, 227);
			break;
		case "draynor":
			data.setCamera(77, 94);
			break;
		case "alkharid":
			data.setCamera(0, 10);
			break;
		case "falador":
			data.setCamera(39, 50);
			break;
		case "pollnivneach":
			data.setCamera(25, 50);
			break;
		case "rellekka":
			data.setCamera(25, 50);
			break;
		case "ardougne":
			data.setCamera(25, 50);
			break;
	}	
	}
	
	@Override
	public int onLoop() throws InterruptedException {
		runTasks(buildTasks());
		return 100;
	}

	private Node[] buildTasks() {
		Node[] tasks = {
				new Stamina(this, data),
				new Walk(this, data),
				new Restart(this, data),
				};
		return tasks;
	}

	private void runTasks(Node[] tasks) throws InterruptedException {
		for (int i = 0; i < tasks.length; i++) {
			cameraReset(data.getCameraX(), data.getCameraY());
			if (tasks[i].validate()) {
				tasks[i].run();
			}
		}
	}

	public void onPaint(Graphics2D g) {
		m.draw(g);
		g.drawImage(bg, 6, 345, null);
		g.setFont(new Font("Myriad Pro", Font.PLAIN, 11));
		g.setColor(Color.YELLOW);
		g.drawString(timer.parse(timer.getElapsed()), 51, 432); // Timer
		g.drawString(data.getStatus(), 58, 406); // status
		aXP = experienceTracker.getGainedXP(Skill.AGILITY);
		axph =  experienceTracker.getGainedXPPerHour(Skill.AGILITY);
		g.drawString(aXP + " (" + NumberFormat.getNumberInstance(Locale.US).format(axph) + "xp/h)", 76, 460); // exp
		
	}
	
	public void onExit() {
	}
	
    public void cameraReset(int x, int y) throws InterruptedException {
		if (getCamera().getPitchAngle() < 59) {
			//log("Reset pitch");
    		getCamera().movePitch(Script.random(64, 67));
    		//Script.sleep(Script.random(1000, 3000));
    	}
		if (!(getCamera().getYawAngle() >= x && getCamera().getYawAngle() <= y)) {
			//log("Reset yaw");
    		getCamera().moveYaw(Script.random(x, y));
			//Script.sleep(Script.random(1000, 3000));
    	}
    }
}
