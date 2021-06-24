package cn.it1995;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<SaveFile> saveFileList = new ArrayList<SaveFile>();

    public void add(SaveFile saveFile){

        saveFileList.add(saveFile);
    }

    public SaveFile get(Integer index){

        return saveFileList.get(index);
    }
}
