package interfaces;

import gui.FormEvent;

import java.util.EventListener;

public interface FormListener extends EventListener {
	
	public void formEventOccured(FormEvent e);
}
