package cn.it1995.service;

import cn.it1995.Response.PageResp;
import cn.it1995.object.TestDemo;
import cn.it1995.repository.TestDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TestDemoService {

    @Autowired
    private TestDemoRepository testDemoRepository;

    public PageResp<ArrayList> listAll(Integer pageNum, Integer size){

        Pageable pageable = PageRequest.of(pageNum, size);
        Page<TestDemo> all = testDemoRepository.findAll(pageable);
        PageResp<ArrayList> ret = new PageResp<>();
        ArrayList<TestDemo> list = new ArrayList<>();
        for(TestDemo demo : all){

            TestDemo testDemo = new TestDemo();
            testDemo.setId(demo.getId());
            testDemo.setValue1(demo.getValue1());
            testDemo.setValue2(demo.getValue2());
            list.add(testDemo);
        }

        ret.setTotalPages(all.getTotalPages());
        ret.setCurrentPage(all.getNumber() + 1);
        ret.setTotalElements(all.getTotalElements());
        ret.setData(list);
        return ret;
    }
}