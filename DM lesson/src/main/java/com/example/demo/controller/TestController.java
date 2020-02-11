package com.example.demo.controller;

import com.example.demo.Exception.TestException;
import com.example.demo.error.TestEm;
import com.example.demo.object.TestTable;
import com.example.demo.service.TestTableService;
import com.example.demo.utils.ResultUtils;
import com.example.demo.vo.RecordErrorVO;
import com.example.demo.vo.ResultTestTableListVO;
import com.example.demo.vo.ResultTestTableVO;
import com.example.demo.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
public class TestController {

    @Autowired
    TestTableService service;


    @GetMapping("/test")
    public String test(){

        return "<h1>Hello world</h1><Button>Hello</Button>";
    }

    @PostMapping("/postTest")
    public String postTest(){

        return "PostTest";
    }


    @GetMapping("/simpleJS")
    public ResultVO simpleJS(){

//        ResultVO resultVO = new ResultVO();
////        resultVO.setCode(200);
////        resultVO.setMsg("测试");



        return ResultUtils.success(null);
    }


    @GetMapping("/getAllData")
    public ResultVO getAllTestTable(){

        List<TestTable> allData = service.getAllData();
        ResultTestTableListVO listVO = new ResultTestTableListVO();

        for(TestTable testTable : allData){

            listVO.getList().add(new ResultTestTableVO(testTable.getId(), testTable.getName(), testTable.getSource()));
        }

        return ResultUtils.success(listVO);
    }

    @GetMapping("/getOneRecord")
    public ResultVO getTestTableByID(@RequestParam("id") Integer id){

        TestTable testTableByID = service.getTestTableByID(id);

        if(testTableByID == null){

            RecordErrorVO errorVO  = new RecordErrorVO(TestEm.RECORD_NOT_EXIST);
            return ResultUtils.error(errorVO);
        }

        return ResultUtils.success(testTableByID);
    }
}
