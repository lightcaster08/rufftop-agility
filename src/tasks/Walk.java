package tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.osbot.rs07.script.Script;
import org.osbot.rs07.utility.ConditionalSleep;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.GroundItem;
import org.osbot.rs07.api.model.Player;
import org.osbot.rs07.api.model.RS2Object;

import framework.Node;
import data.Data;

public class Walk implements Node {
	
	private Script s;
	private Player me;
	private Data data;
	RS2Object currentObj;
	List<Integer> failsafeDistances = new ArrayList<Integer>();
	
	public Walk(Script s, Data data) {
		this.s = s;
		this.me = s.myPlayer();
		this.data = data;
	}
	
	@Override
	public boolean validate() {
		return me.getZ() != 0 && !me.isAnimating() && !me.isMoving();
	}
	
	public boolean rInteract(RS2Object o, String str) throws InterruptedException {
		if (o.interact(str)) {
			int hr;
			if (Script.random(0, 10) < 8) {
				hr = 0;
			} else {
				hr = 3;
			}
			if (Script.random(0, 10) < 1) {
				for (int j = 0; j < hr; j++) {
					leftClick();
				}
			} else {
				for (int j = 0; j < hr; j++) {
					if (Script.random(0, 10) < 1) {
						o.interact(str);
					}
				}
			}
			if (Script.random(0, 100) > 90) {
				s.mouse.click(true);
			}
			return true;
		} else {
			return false;
		}
	}
	
	public void farObject(Position p, RS2Object o, String a) throws InterruptedException {
		vlog("Handling far object");
		s.getWalking().webWalk(p);
		if (o.isVisible()) {
			rInteract(o, a);
		} else {
			p.interact(s.getBot(), "Walk here");
			farObject(p, o, a);
		}
	}

	@Override
	public void run() throws InterruptedException {
		data.setStatus("Running...");
		if (Script.random(0, 512) == 84) {
			data.setStatus("Taking a quick break...");
			Script.sleep(Script.random(66000, 180000));
		}
		
		for (int i = 0; i < data.ARRAYSTART.length; i++) {
			checkForGrace(data.ARRAYSTART[i]);
			if (inVicinity(data.ARRAYEND[i])) {
				vlog("In vicinity of end position: " + data.ARRAYEND[i]);
				currentObj = s.objects.closest(data.ARRAYOBJECT[i]);
				if (currentObj != null) {
					if (currentObj.isVisible()) {
						vlog("Object " + data.ARRAYOBJECT[i] + " found");
						if (rInteract(currentObj, data.ARRAYACTION[i])) {
							data.setFailsaferu(0);
							if (i < data.ARRAYEND.length - 1) {
								vlog("Sleeping until position reached | " + data.ARRAYEND[i+1]);
								cSleep(data.ARRAYEND[i+1]);
							}
						}
					} else {
						farObject(data.ARRAYSTART[i], currentObj, data.ARRAYACTION[i]);
					}
				}
			} else {
				if (inVicinity(data.ARRAYSTART[i])) {
					vlog("In vicinity of start position: " + data.ARRAYEND[i]);
					currentObj = s.objects.closest(data.ARRAYOBJECT[i]);
					if (currentObj != null) {
						if (currentObj.isVisible()) {
							vlog("Object " + data.ARRAYOBJECT[i] + " found");
							if (rInteract(currentObj, data.ARRAYACTION[i])) {
								data.setFailsaferu(0);
								if (i < data.ARRAYEND.length - 1) {
									vlog("Sleeping until position reached | " + data.ARRAYEND[i+1]);
									cSleep(data.ARRAYEND[i+1]);
								}
							}
						} else {
							vlog("Adjusting camera to see if we can see object");
							s.getCamera().moveYaw(Script.random(data.getCameraX(), data.getCameraY()));
						}
					}
				}
			}
		}
		data.setFailsaferu(data.getFailsaferu() + 1);
		if (data.getFailsaferu() > 5) {
			tryArrayEnd();
		}
	}
	
	public void tryArrayEnd() throws InterruptedException {
		data.setStatus("Going back on path...");
		failsafeDistances.clear();
		for (int i = 0; i < data.ARRAYEND.length - 1; i++) {
			vlog("Comparing distance to " + data.ARRAYEND[i] + ": " + data.ARRAYEND[i].distance(me.getPosition()));
			failsafeDistances.add(data.ARRAYEND[i].distance(me.getPosition()));
		}
		final int minIndex = failsafeDistances.indexOf(Collections.min(failsafeDistances));
		vlog("Found index position: " + data.ARRAYEND[minIndex]);
		if (s.getWalking().webWalk(data.ARRAYEND[minIndex])) {
			vlog("Tails attempt made to walk there");
			new ConditionalSleep(Script.random(5500, 9500)) {
				@Override
				public boolean condition() {
					return me.getPosition().equals(data.ARRAYEND[minIndex]);
				}
			}.sleep();
		}
		if (!inVicinity(data.ARRAYEND[minIndex])) {
			vlog("Manually walking there as getWalking isn't precise enough");
			data.ARRAYEND[minIndex].interact(s.getBot(), "Walk here");
			new ConditionalSleep(Script.random(5500, 9500)) {
				@Override
				public boolean condition() {
					return me.getPosition().equals(data.ARRAYEND[minIndex]);
				}
			}.sleep();
		}
		if (inVicinity(data.ARRAYEND[minIndex])) {
			vlog("Back on path, resetting failsafe");
			data.setFailsaferu(0);
		} else {
			tryArrayStart();
		}
	}
	
	public void tryArrayStart() throws InterruptedException {
		vlog("Tails failed, trying heads");
		failsafeDistances.clear();
		for (int i = 0; i < data.ARRAYSTART.length; i++) {
			failsafeDistances.add(data.ARRAYSTART[i].distance(me.getPosition()));
		}
		final int minIndex = failsafeDistances.indexOf(Collections.min(failsafeDistances));
		vlog("Found index position: " + data.ARRAYSTART[minIndex]);
		if (s.getWalking().webWalk(data.ARRAYSTART[minIndex])) {
			vlog("Heads attempt made to walk there");
			new ConditionalSleep(Script.random(5500, 9500)) {
				@Override
				public boolean condition() {
					return me.getPosition().equals(data.ARRAYSTART[minIndex]);
				}
			}.sleep();
		}
		if (!inVicinity(data.ARRAYSTART[minIndex])) {
			vlog("Manually walking there as getWalking isn't precise enough");
			data.ARRAYSTART[minIndex].interact(s.getBot(), "Walk here");
			new ConditionalSleep(Script.random(5500, 9500)) {
				@Override
				public boolean condition() {
					return me.getPosition().equals(data.ARRAYSTART[minIndex]);
				}
			}.sleep();
		}
		if (inVicinity(data.ARRAYSTART[minIndex])) {
			vlog("Back on path, resetting failsafe");
			data.setFailsaferu(0);
		} else {
			tryArrayEnd();
		}
	}
	
	public void cSleep(final Position p) throws InterruptedException {
		new ConditionalSleep(Script.random(10000, 15000)) {
            @Override
            public boolean condition() throws InterruptedException {
                return me.getPosition().equals(p) || me.getZ() == 0;
            }
        }.sleep();
        vlog("Conditional sleep expired");
        Script.sleep(Script.random(1400, 1800));
	}
	
	public boolean inVicinity(Position p) {
		if (me.getPosition().distance(p) <= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean graceOnGround() {
		for (GroundItem g : s.getGroundItems().getAll()) {
			if (g.equals(data.MARK)) {
				return true;
			}
		}
		return false;
	}
    
    public void checkForGrace(final Position p) throws InterruptedException {
		GroundItem markOfGrace = s.getGroundItems().closest(data.MARK);
		if (markOfGrace != null && s.map.canReach(markOfGrace)) {
			data.setStatus("Picking up Mark of grace...");
			int graceCounter = (int) s.getInventory().getAmount("Mark of grace");
			takeGrace(markOfGrace);
			while (graceCounter == (int) s.getInventory().getAmount("Mark of grace")) {
				takeGrace(markOfGrace);
			} 
			s.getWalking().webWalk(p);
			if (!me.getPosition().equals(p)) {
				vlog("Manually walking there as getWalking isn't precise enough");
				p.interact(s.getBot(), "Walk here");
				new ConditionalSleep(Script.random(8500, 10500)) {
					@Override
					public boolean condition() {
						return inVicinity(p);
					}
				}.sleep();
			}
		}
    }
    
    public void takeGrace(GroundItem m) throws InterruptedException {
		if (m.interact("Take")) {
			for (int j = 0; j < Script.random(0, 3); j++) {
				m.interact("Take");
			}
			Script.sleep(Script.random(1000, 3000));
		}
    }
    

   
    private void leftClick() throws InterruptedException {
        s.mouse.click(false);
        Script.sleep(Script.random(111, 444));
    }

    private void vlog(String str) {
    	if (data.verbose) {
        	s.log(str);
    	}
    }
	
}
