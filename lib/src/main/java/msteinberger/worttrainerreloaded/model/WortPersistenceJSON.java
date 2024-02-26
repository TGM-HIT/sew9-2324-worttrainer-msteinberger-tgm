package msteinberger.worttrainerreloaded.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.filechooser.FileSystemView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Die Klasse speicher und lädt den Worttrainer mithilfe von JSON.
 * @author msteinberger
 *
 */
public class WortPersistenceJSON extends WortPersistence {
	private final String path = "/Documents/WortTrainer/worttrainer1.txt";
	
	/**
	 * Speichert den Worttrainer.
	 * @param wChecker Die Daten des Worttrainer
	 */
	public void save(WortChecker wChecker) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		File f = new File(WortPersistence.getSystemPath() + path);
		if(!f.isFile()) {
			try {
				f.getParentFile().mkdirs();
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try(BufferedWriter out = new BufferedWriter(new FileWriter(f))) {
			out.write(gson.toJson(wChecker));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Lädt den Worttrainer.
	 * @return Die Daten vom Worttrainer
	 */
	public WortChecker load() {
		WortChecker wChecker = null;
		File f = new File(WortPersistence.getSystemPath() + path);
		if(f.isFile()) {
			try(BufferedReader in = new BufferedReader(new FileReader(f))) {
				String json = "";
				String text;
				while((text = in.readLine()) != null) {
					json += text;
				}
				wChecker = new Gson().fromJson(json, WortChecker.class);
			} catch (IOException e) {
				wChecker = null;
				e.printStackTrace();
			}
		}
		return wChecker;
	}
}
