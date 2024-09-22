package Buildings;

import Villagers.Villager;
import java.util.ArrayList;
import java.util.List;

public abstract class Building {
    private String name;
    protected List<Villager> assignedVillagers;

    public Building(String name) {
        this.name = name;
        this.assignedVillagers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

   
    public boolean assignVillager(Villager villager) {
        if (villager.getAssignedBuilding() != null) {
            System.out.println(villager.getFirstName() + " is already assigned to " + villager.getAssignedBuilding().getName() + ".");
            return false;
        }
        assignedVillagers.add(villager);
        villager.setAssignedBuilding(this);
        System.out.println(villager.getFirstName() + " has been assigned to " + this.getName() + ".");
    
        return true;
    }

    public List<Villager> getAssignedVillagers() {
        return assignedVillagers;
    }

    public abstract void print();
}
