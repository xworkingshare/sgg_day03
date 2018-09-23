package com.atguigu.gmall0416.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall0416.bean.SpuInfo;
import com.atguigu.gmall0416.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: SpuManageController
 * @Description:
 * @Author: 谢万清
 * @CreateTime: 2018/9/22  23:58
 * @Version: 1.0
 **/


@Controller
public class SpuManageController {

    @Reference
    private ManageService manageService;

    @RequestMapping("spuListPage")
    public String spuListPage() {
        return "spuListPage";
    }

    @RequestMapping("spuList")
    @ResponseBody
    public List<SpuInfo> spuList(String catalog3Id) {
        // select * from spuInfo where catalog3Id = ?
        // 调用后台
        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);
        return manageService.getSpuInfoList(spuInfo);
    }
}
