package com.haynesy;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Adam
 * Date: 8/10/13
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {

        // Look into panel to display file

        if(file.isDirectory())
            return true;

        String name = file.getName();

        int lastIndex  = name.lastIndexOf(".");
        if(lastIndex == -1)
            return false;

        if(lastIndex == name.length() - 1)
            return false;

        return true;
    }

    @Override
    public String getDescription() {
        return "Person database file [*.per]";
    }
}
