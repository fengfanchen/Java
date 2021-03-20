package cn.it1995.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "cff-data-server")
public interface GetDataService {

    @GetMapping("/getAll")
    Object getAll();

    @GetMapping("/getOne")
    Object getOne(@RequestParam(value = "id") Integer id);
}
