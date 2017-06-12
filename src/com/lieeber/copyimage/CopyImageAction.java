package com.lieeber.copyimage;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;

/**
 * Created by lieeber on 2017/6/12.
 */
public class CopyImageAction extends AnAction {

    private Project project;

    @Override
    public void actionPerformed(AnActionEvent e) {
        project = e.getData(PlatformDataKeys.PROJECT);
//        CopyDialog copyDialog = new CopyDialog(text -> {
//            File directory = new File(text);
//            if (directory.isDirectory()) {
//                for (File files : directory.listFiles()) {
//                    if (files.isDirectory()) {      //drawable-xhdpi等
//                        File[] fileImages = files.listFiles();
//                        if (fileImages != null) {
//                            for (File file : fileImages) {
//                                try {
//                                    File appDrawableDirectory = new File(getDrawablePath() + files.getName());
//                                    if (!appDrawableDirectory.exists()) {
//                                        boolean mkdir = appDrawableDirectory.mkdir();
//                                        System.out.println(mkdir);
//                                    }
//                                    File file1 = new File(getDrawablePath() + files.getName() + "/" + file.getName());
//
//                                    copyFile(files, file, file1);
//                                } catch (Exception e1) {
//                                    e1.printStackTrace();
//                                }
//                            }
//                        }
//                    }
//                }
//            } else {
//                Messages.showMessageDialog("您输入的不是目录，请重新输入", "警告", Messages.getInformationIcon());
//            }
//        });
//        copyDialog.setVisible(true);
        new AlertDialog().setVisible(true);

    }

    private void copyFile(File files, File file, File file1) throws IOException {
        if (!file1.isDirectory()) {
            if (file1.exists()) {
                if (file1.getName().contains(".")) {
                    String[] split = file1.getName().split("\\.");
                    File file2 = new File(getDrawablePath() + files.getName() + "/" +  split[0] + "_copy" + "." + split[1]);
                    copyFile(files, file, file2);
                }
            } else {
                Files.copy(file.toPath(), file1.toPath());
            }
        }
    }

    private String getDrawablePath() {
        String path = project.getBasePath() + "/App/src/main/res/";
        return path;
    }

}
