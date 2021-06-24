package cn.it1995;

public class Game {

    private String status;

    public void setStatus(String status){

        this.status = status;
    }

    public String getStatus(){

        return this.status;
    }

    public SaveFile saveStatusToFile(){

        return new SaveFile(status);
    }

    public void setStatusFromFile(SaveFile saveFile){

        status = saveFile.getFileContent();
    }
}
