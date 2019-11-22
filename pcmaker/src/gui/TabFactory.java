package gui;

import java.io.IOException;

import backend.CPUController;
import backend.MemoryController;
import backend.MotherboardController;
import backend.PowerSupplyController;
import backend.StorageController;
import backend.VideoCardController;

public class TabFactory {
	
	public static ListTab getTab(String type) throws IOException{
        switch(type){
            case "cpu" : 
                return new ListTab(CPUController.getInstance());
            case "memory" : 
                return new ListTab(MemoryController.getInstance());
            case "motherboard" : 
                return new ListTab(MotherboardController.getInstance());
            case "powersupply" : 
                return new ListTab(PowerSupplyController.getInstance());
            case "storage" : 
                return new ListTab(StorageController.getInstance());
            case "videocard" : 
                return new ListTab(VideoCardController.getInstance());           
            default : return null;
        }
    }
}
