package de.dragon.FTClient.menu;

import de.dragon.FTClient.frame.FTPFrame;
import de.dragon.FTClient.ftpnet.Parser;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(FTPFrame frame, Parser parser) {
        super();

        JMenu file = new JMenu("File");
        file.add(new UploadFileOption(frame, parser));
        file.add(new DeleteOption(frame));
        file.add(new LogoutOption(frame));

        JMenu options = new JMenu("Options");
        options.add(new RefreshOption(frame));
        options.add(new AutoApproveDownloadOption());

        JMenu view = new JMenu("View");
        view.add(new EnableHiddenFilesOption(frame));

        this.add(file);
        this.add(options);
        this.add(view);
    }

}
