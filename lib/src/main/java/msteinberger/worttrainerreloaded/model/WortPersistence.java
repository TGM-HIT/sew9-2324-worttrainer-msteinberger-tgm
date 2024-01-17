package msteinberger.worttrainerreloaded.model;

import javax.swing.filechooser.FileSystemView;

public abstract class WortPersistence {
	static String systemPath;

	public abstract void save(WortChecker wChecker);
	
	public abstract WortChecker load();
	
	protected static String getSystemPath() {
		if(systemPath == null)
			systemPath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
		return systemPath;
	}
}
