package tasks;

import org.osbot.rs07.script.Script;
import org.osbot.rs07.api.Inventory;
import framework.Node;
import data.Data;

public class Stamina implements Node {

	public static int STAMINA_ID = 12631, DSTAMINA_ID = 229;
	private Script s;
	private Inventory inv;
	private Data data;
	
	public Stamina(Script s, Data data) {
		this.s = s;
		this.inv = s.getInventory();
		this.data = data;
	}
	
	@Override
	public boolean validate() {
		return s.settings.getRunEnergy() <= data.getEnergyToDrinkAt();
	}

	@Override
	public void run() throws InterruptedException {
		if (s.getInventory().contains(data.STAM)) {
			s.getInventory().interact("Drink", data.STAM);
		} else if (inv.contains(data.STAM2)) {
			s.getInventory().interact("Drink", data.STAM2);
		} else if (inv.contains(data.STAM3)) {
			s.getInventory().interact("Drink", data.STAM3);
		} else if (inv.contains(data.STAM4)) {
			s.getInventory().interact("Drink", data.STAM4);
		}
		data.setEnergy(s.settings.getRunEnergy() - Script.random(18, 23));
		Script.sleep(Script.random(1200, 1500));
		if (s.getInventory().contains(data.VIAL)) {
			inv.getItem(data.VIAL).interact("Drop");
		}
	}
}