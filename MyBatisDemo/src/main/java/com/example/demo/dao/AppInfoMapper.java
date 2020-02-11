package com.example.demo.dao;


import com.example.demo.object.AppInfo;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface AppInfoMapper {

    List<AppInfo> getAllAPPInfo();
    void addAPPInfo(AppInfo appInfo);
    void updateAPPInfo(AppInfo appInfo);
    void deleteAPPInfo(AppInfo appInfo);
}
