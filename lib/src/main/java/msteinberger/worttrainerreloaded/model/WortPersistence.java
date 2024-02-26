package msteinberger.worttrainerreloaded.model;

import javax.swing.filechooser.FileSystemView;

/**
 * Die Klasse speichert und lädt den Worttrainer.
 * @author msteinberger
 *
 */
public abstract class WortPersistence {
	static String systemPath;

	public abstract void save(WortChecker wChecker);
	
	public abstract WortChecker load();
	
	/**
	 * Gibt den System Path zurück.
	 * @return Der System Path
	 */
	protected static String getSystemPath() {
		if(systemPath == null)
			systemPath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
		return systemPath;
	}
}
