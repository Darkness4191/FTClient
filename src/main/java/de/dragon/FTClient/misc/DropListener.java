package de.dragon.FTClient.misc;

import de.dragon.FTClient.frame.FTPFrame;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DropListener extends DropTarget {

	private FTPFrame frame;

	public DropListener(FTPFrame frame) {
		this.frame = frame;
	}

	@SuppressWarnings("unchecked")
	@Override
	public synchronized void drop(DropTargetDropEvent arg0) {
		arg0.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
		if(frame.isInit()) {
			try {
				List<File> fileList = (List<File>) arg0.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
				for(File c : fileList) {
					if(!c.isDirectory()) {
						frame.getUpload().upload(c);
						frame.refreshView(false);
						JOptionPane.showMessageDialog(frame.getDropField(), "Upload complete", "Info", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			} catch (UnsupportedFlavorException | IOException | InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		arg0.dropComplete(true);
	}

}
