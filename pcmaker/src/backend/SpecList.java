package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import gui.Budget;

public class SpecList {
	private Budget budget;
	private CPU cpu;

	
	public SpecList(Budget budget)  {
		this.budget = budget;
	}

	public static void main(String[] args) {
		//System.out.println("Hello, here is your specification list with CPU Brand Preference: "+ budget.getCPUPreference() + ", Video Card Brand Preference: "+ budget.getCardPreference());
		
	}

	public String show() {
		//System.out.printf("Hello, here is your specification list with CPU Brand Preference: %s, Video Card Brand Preference: %s",budget.getCPUPreference(),budget.getCardPreference());
		//if (budget!=null)
		return "Hello, here is your specification list with follwoing limitation: \n1: CPU Brand Preference: "+ budget.getCPUPreference() + "\n2: Video Card Brand Preference: "+ budget.getCardPreference() + "\n3. Total cost: " + budget.getTotal();
		//else
			//return "The required list cannot be found";
	}
	
	public void update() {
		
	}

	public void print() {
		this.cpu = CPUController.getRequired(budget.getCPUPreference(),budget.getCpuPrice());
		if (cpu==null)
			System.out.println("No result found!");
		else {
			System.out.println("Hello, here is your specification list with follwoing limitation: \n1: CPU Brand Preference: "+ budget.getCPUPreference() + "\n2: Video Card Brand Preference: "+ budget.getCardPreference() + "\n3. Total cost: " + budget.getTotal());
			System.out.println("Our suggesttion will be: \n");
			System.out.println("CPU: " + cpu.getName() +", Price: " + cpu.getPrice());
		}
	}

}