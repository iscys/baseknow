package com.baseknow.map;


public interface FileChooserFactory {

    FileChooser  newChooser(int mainFileCount,String id);

    interface FileChooser {

        String getMainFileName();

        String getFormatPartFileName();

    }
}
