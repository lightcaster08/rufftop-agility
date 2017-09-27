package tasks;

import org.osbot.rs07.script.Script;
import org.osbot.rs07.utility.ConditionalSleep;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.Player;
import org.osbot.rs07.api.model.RS2Object;
//import org.osbot.rs07.api.ui.Option;
//import org.osbot.rs07.api.ui.Tab;

import org.osbot.rs07.api.ui.Skill;

import framework.Node;
import data.Data;

public class Restart implements Node {
	
	private Script s;
	private Player me;
	private Data data;
	
	public Restart(Script s, Data data) {
		this.s = s;
		this.me = s.myPlayer();
		this.data = data;
	}
	
	@Override
	public boolean validate() {
		return me.getZ() == 0 && !me.isAnimating() && !me.isMoving();
	}
	
	public void startCourse(Area ia, int iobj, String iaction, final int iz) {
		if (ia.contains(me)) {
			RS2Object objectToInteractWith = s.objects.closest(iobj);
			if (objectToInteractWith != null) {
				if (objectToInteractWith.isVisible()) {
					if (objectToInteractWith.interact(iaction)) {
						new ConditionalSleep(Script.random(5000, 8000)) {
				            @Override
				            public boolean condition() throws InterruptedException {
				                return me.getZ() == iz;
				            }
				        }.sleep();
				        data.totalLaps++;
					}
				}
			}
		} else {
			s.getWalking().webWalk(ia);
		}
	}

	@Override
	public void run() throws InterruptedException {
		data.setStatus("Restarting the course...");
		if (data.totalLaps > data.lapsBeforeBreak) {
			data.setStatus("Taking a long break...");
			Script.sleep(Script.random(75000, 240000));
			data.lapsBeforeBreak = (Script.random(s.skills.getStatic(Skill.AGILITY), (s.skills.getStatic(Skill.AGILITY) + Script.random(5, 15))) / 2);
			s.log("Taking a break, next # of laps before break is: " + data.lapsBeforeBreak);
			data.totalLaps = 0;
		}
		
		switch (data.getCourse()) {
		default:
			s.log("Course not set");
			s.stop(false);
			break;
		case "draynor":
			startCourse(data.dstart, 10073, "Climb", 3);
			break;
		case "alkharid":
			startCourse(data.astart, 10093, "Climb", 3);
			break;
		case "varrock":
			startCourse(data.vstart, 10586, "Climb", 3);
			break;
		case "canifis":
			startCourse(data.cstart, 10819, "Climb", 2);
			break;
		case "falador":
			startCourse(data.fstart, 10833, "Climb", 3);
			break;
		case "seers":
			startCourse(data.sstart, 11373, "Climb-up", 3);
			/*
			if (!s.tabs.getOpen().equals(Tab.MAGIC)) {
				s.tabs.open(Tab.MAGIC);
			}
			if (data.send.contains(me)) {
				if (mouseToTP()) {
					leftClick();
					new ConditionalSleep(Script.random(3500, 6500)) {
	                    @Override
	                    public boolean condition() throws InterruptedException {
	                        return data.stp.contains(me);
	                    }
	                }.sleep();
				}
			}*/
			break;
		case "pollnivneach":
			startCourse(data.pstart, 11380, "Climb-on", 1);
			break;
		case "rellekka":
			startCourse(data.rstart, 11391, "Climb", 3);
			break;
		case "ardougne":
			
			break;
		}
	}
	/*
    private boolean mouseToTP() throws InterruptedException {
    	s.mouse.move(Script.random(679, 701), Script.random(296, 314));
    	return isTPOption();
    }
	
    private boolean isTPOption() {
    	for (Option option : s.menu.getMenu()) {
    		if (option != null && option.action.equals("Seers'") && option.name.contains("Camelot Teleport")) {
					return true;
			}
		}
    	return false;
    }
    
    private void leftClick() throws InterruptedException {
    	for (int i = 0; i < Script.random(1, 4); i++) {
    		s.mouse.click(false);
    		Script.sleep(Script.random(200, 500));
    	}
    }*/
	
}
